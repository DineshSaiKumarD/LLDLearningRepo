package VendingMachineSystem;

import VendingMachineSystem.models.Item;

/**
 * PaymentService handles all payment-related operations
 * This service validates and processes payments
 */
public class PaymentService {
    
    private double minimumAmountRequired;
    
    public PaymentService() {
        this.minimumAmountRequired = 0.0;
    }
    
    public boolean validatePayment(double amountInserted, double itemPrice) {
        return amountInserted >= itemPrice;
    }
    
    public double calculateChange(double amountInserted, double itemPrice) {
        return amountInserted - itemPrice;
    }
    
    public void processRefund(double amount) {
        System.out.println("Processing refund of $" + String.format("%.2f", amount));
    }
}

