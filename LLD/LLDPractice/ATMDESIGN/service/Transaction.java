package ATMDESIGN.service;

import ATMDESIGN.entities.BankAccount;

public interface Transaction {

        void execute(BankAccount account);

    void execute(BankAccount bankAccount, ATM atm);
}
