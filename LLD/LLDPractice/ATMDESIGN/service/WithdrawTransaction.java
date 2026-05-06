package ATMDESIGN.service;

import ATMDESIGN.entities.BankAccount;

public class WithdrawTransaction implements Transaction {

    private String transactionId;
    private double amount;
    private BankingService bankingService;

    public WithdrawTransaction(String transactionId, double amount, BankingService bankingService) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.bankingService = bankingService;
    }

    @Override
    public void execute(BankAccount account) {
        // Not used in current implementation
    }

    @Override
    public void execute(BankAccount bankAccount, ATM atm) {
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Amount requested: Rs.... " + amount);
        System.out.println();
        
        // Check if ATM has sufficient cash
        if (!atm.hasSufficientCash(amount)) {
            System.out.println("ATM does not have sufficient cash");
            System.out.println("Withdrawal cancelled ... insufficient funds in ATM");
            return;
        }
        System.out.println("ATM has sufficient cash");
        
        //  Use BankingService to check and process withdrawal
        String accountNumber = bankAccount.getAccountNumber();
        double currentBalance = bankingService.getAccountBalance(accountNumber);
        
        if (currentBalance < amount) {
            System.out.println("Bank account does not have sufficient balance");
            System.out.println("Withdrawal canceled - insufficient funds in account");
            System.out.println("Current balance: Rs... " + currentBalance);
            return;
        }
        System.out.println("Account has sufficient balance");
        
        //  Withdraw from bank account using BankingService
        boolean withdrawSuccess = bankingService.withdraw(accountNumber, amount);
        if (!withdrawSuccess) {
            System.out.println("Withdrawal from account failed");
            return;
        }
        System.out.println("Withdrawn from account successfully");
        
        //  Dispense cash from ATM
        double dispensed = atm.dispenseCash(amount);
        if (dispensed > 0) {
            System.out.println("Cash dispensed from ATM: Rs. " + dispensed);
            System.out.println("Transaction completed successfully");
            double updatedBalance = bankingService.getAccountBalance(accountNumber);
            System.out.println("Updated account balance: Rs. " + updatedBalance);
        } else {
            System.out.println("Cash dispensing failed");
            // Rollback: restore money to account if cash dispensing failed
            bankingService.deposit(accountNumber, amount);
            System.out.println("Amount restored to account");
        }
    }

    public String getTransactionId() {
        return transactionId;
    }


    public double getAmount() {
        return amount;
    }
}
