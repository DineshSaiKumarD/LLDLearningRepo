package ATMDESIGN.service;

import ATMDESIGN.entities.BankAccount;

public class DisplayBalanceTransaction implements Transaction{

    private BankAccount account;

    public DisplayBalanceTransaction(BankAccount account) {
        this.account = account;
    }

    @Override
    public void execute(BankAccount account) {
        account.displayBalance();
        System.out.println("Displaying balance for account: " + account.getAccountNumber());
    }

    @Override
    public void execute(BankAccount bankAccount, ATM atm) {
        // For balance display, ATM is not required
        execute(bankAccount);
    }
}
