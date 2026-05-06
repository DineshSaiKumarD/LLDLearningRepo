package ATMDESIGN.service;

public class ATM {

    private int atmId;
    private String location;
    private double balance; // ATM cash reserve
    private String insertedCardNumber; // Currently inserted card
    private String authenticatedAccountNumber; // Authenticated account
    
    public ATM(int atmId, String location, double balance) {
        this.atmId = atmId;
        this.location = location;
        this.balance = balance;
        this.insertedCardNumber = null;
        this.authenticatedAccountNumber = null;
    }

    public void insertCard(String cardNumber) {
        this.insertedCardNumber = cardNumber;
        System.out.println("Card inserted: " + cardNumber);
    }

    public boolean validatePin(String accountNumber, BankingService bankingService) {
        // Delegate to BankingService for authentication
        if (bankingService.authenticateUser(accountNumber, "")) {
            this.authenticatedAccountNumber = accountNumber;
            return true;
        }
        return false;
    }

    public void ejectCard() {
        if (insertedCardNumber != null) {
            System.out.println("Card ejected: " + insertedCardNumber);
            this.insertedCardNumber = null;
            this.authenticatedAccountNumber = null;
        }
    }
    
    public boolean hasSufficientCash(double amount) {
        return balance >= amount;
    }

    public double dispenseCash(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return amount;
        } else {
            System.out.println("Insufficient cash in ATM");
            return 0.0;
        }
    }
    
    public double getATMBalance() {
        return balance;
    }
    
    public String getAuthenticatedAccount() {
        return authenticatedAccountNumber;
    }
    
    public int getAtmId() {
        return atmId;
    }
    
    public String getLocation() {
        return location;
    }
}
