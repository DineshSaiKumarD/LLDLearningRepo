package ATMDESIGN.service;

import ATMDESIGN.entities.BankAccount;
import java.util.HashMap;
import java.util.Map;

public class BankingService {

    private Map<String, BankAccount> accounts; // Simulating database
    
    public BankingService() {
        this.accounts = new HashMap<>();
    }
    
    public void registerAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public boolean authenticateUser(String accountNumber, String pin) {
        // Implement authentication logic here
        // For now, simple validation
        return accounts.containsKey(accountNumber);
    }

    public double getAccountBalance(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber).getBalance();
        }
        return -1; // Invalid account
    }

    public boolean withdraw(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            BankAccount account = accounts.get(accountNumber);
            return account.withdraw(amount);
        }
        return false;
    }

    public boolean deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            BankAccount account = accounts.get(accountNumber);
            account.deposit(amount);
            return true;
        }
        return false;
    }
    
    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
