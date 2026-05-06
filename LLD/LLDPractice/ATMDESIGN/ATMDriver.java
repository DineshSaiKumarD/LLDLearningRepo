package ATMDESIGN;

import ATMDESIGN.entities.BankAccount;
import ATMDESIGN.entities.Card;
import ATMDESIGN.service.ATM;
import ATMDESIGN.service.BankingService;
import ATMDESIGN.service.WithdrawTransaction;
import ATMDESIGN.service.DisplayBalanceTransaction;

public class ATMDriver {

    public static void main(String[] args) {

        System.out.println("========== ATM SYSTEM ==========");
        System.out.println();

        // Initialize BankingService
        BankingService bankingService = new BankingService();
        System.out.println("Banking Service initialized");
        System.out.println();

        // Create bank accounts
        BankAccount account1 = new BankAccount("ACC001", "Dinesh Kumar", 50000.00);
        BankAccount account2 = new BankAccount("ACC002", "Pawan Kalyan", 75000.00);
        
        // Register accounts with BankingService
        bankingService.registerAccount(account1);
        bankingService.registerAccount(account2);

        System.out.println("Bank accounts created and registered with BankingService:");
        System.out.println("   Account 1: " + account1.getAccountHolderName() + " | Balance: " + bankingService.getAccountBalance("ACC001"));
        System.out.println("   Account 2: " + account2.getAccountHolderName() + " | Balance: " + bankingService.getAccountBalance("ACC002"));
        System.out.println();

        // Create ATMs
        ATM atm1 = new ATM(101, "Vijayawada", 100000.00);
        ATM atm2 = new ATM(102, "Hyderabad", 150000.00);

        System.out.println("ATMs initialized:");
        System.out.println("   ATM 101 at Vijayawada | Cash: Rs. " + atm1.getATMBalance());
        System.out.println("   ATM 102 at Hyderabad | Cash: Rs. " + atm2.getATMBalance());
        System.out.println();

        // Create debit cards
        Card card1 = new Card("4532123456789012", "Dinesh Kumar", "12/25", "123");
        Card card2 = new Card("4532987654321098", "Pawan Kalyan", "11/26", "456");

        System.out.println("Debit cards created:");
        System.out.println("  - Card 1: " + card1.getCardHolderName());
        System.out.println("  - Card 2: " + card2.getCardHolderName());
        System.out.println();

        // ===== Transaction 1: Display Balance =====
        System.out.println("========== TRANSACTION 1: DISPLAY BALANCE ==========");
        System.out.println("Displaying balance for " + account1.getAccountHolderName());
        DisplayBalanceTransaction displayBalance = new DisplayBalanceTransaction(account1);
        displayBalance.execute(account1);
        System.out.println("Current Balance: Rs. " + bankingService.getAccountBalance("ACC001"));
        System.out.println();

        // ===== Transaction 2: Withdraw Cash (Successful) =====
        System.out.println("========== TRANSACTION 2: WITHDRAW CASH (SUCCESSFUL) ==========");
        WithdrawTransaction withdrawal1 = new WithdrawTransaction("TXN001", 10000.00, bankingService);
        withdrawal1.execute(account1, atm1);
        System.out.println("ATM Cash Remaining: Rs. " + atm1.getATMBalance());
        System.out.println();

        // ===== Transaction 3: Display Balance After Withdrawal =====
        System.out.println("========== TRANSACTION 3: DISPLAY BALANCE AFTER WITHDRAWAL ==========");
        System.out.println("Displaying updated balance for " + account1.getAccountHolderName());
        displayBalance.execute(account1);
        System.out.println("Updated Balance: Rs. " + bankingService.getAccountBalance("ACC001"));
        System.out.println();

        // ===== Transaction 4: Withdraw from Another Account =====
        System.out.println("========== TRANSACTION 4: WITHDRAW FROM ANOTHER ACCOUNT ==========");
        System.out.println("Processing withdrawal request for " + account2.getAccountHolderName());
        WithdrawTransaction withdrawal2 = new WithdrawTransaction("TXN002", 25000.00, bankingService);
        System.out.println("Amount to withdraw: Rs. " + withdrawal2.getAmount());
        withdrawal2.execute(account2, atm2);
        System.out.println();
        
        // ===== Transaction 5: FAILED - Insufficient ATM Cash =====
        System.out.println("========== TRANSACTION 5: WITHDRAW - INSUFFICIENT ATM CASH ==========");
        System.out.println("Processing large withdrawal request for " + account2.getAccountHolderName());
        WithdrawTransaction withdrawal3 = new WithdrawTransaction("TXN003", 200000.00, bankingService);
        System.out.println("Amount to withdraw: Rs. " + withdrawal3.getAmount());
        withdrawal3.execute(account2, atm2);
        System.out.println();
        
        // ===== Transaction 6: FAILED - Insufficient Account Balance =====
        System.out.println("========== TRANSACTION 6: WITHDRAW - INSUFFICIENT ACCOUNT BALANCE ==========");
        System.out.println("Processing large withdrawal request for " + account1.getAccountHolderName());
        WithdrawTransaction withdrawal4 = new WithdrawTransaction("TXN004", 50000.00, bankingService);
        System.out.println("Amount to withdraw: Rs. " + withdrawal4.getAmount());
        withdrawal4.execute(account1, atm1);
        System.out.println();

        // ===== Transaction 7: Display Final Balances =====
        System.out.println("========== TRANSACTION 7: DISPLAY FINAL BALANCES ==========");
        System.out.println("Displaying balance for " + account2.getAccountHolderName());
        displayBalance = new DisplayBalanceTransaction(account2);
        displayBalance.execute(account2);
        System.out.println("Current Balance: Rs. " + bankingService.getAccountBalance("ACC002"));
        System.out.println();

        // ===== Final Summary =====
        System.out.println("========== FINAL SUMMARY ==========");
        System.out.println("Account 1 (" + account1.getAccountHolderName() + "): Rs. " + bankingService.getAccountBalance("ACC001"));
        System.out.println("Account 2 (" + account2.getAccountHolderName() + "): Rs. " + bankingService.getAccountBalance("ACC002"));
        System.out.println("ATM 1 Cash: Rs. " + atm1.getATMBalance());
        System.out.println("ATM 2 Cash: Rs. " + atm2.getATMBalance());
        System.out.println("================================");

    }
}
