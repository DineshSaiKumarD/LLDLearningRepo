package VendingMachineSystem.stateimpl;

import VendingMachineSystem.State;
import VendingMachineSystem.VendingMachine;

public class ValidingPayementState implements State {
    
    private VendingMachine vendingMachine;

    public ValidingPayementState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    
    @Override
    public void init_transaction() {
        // Not allowed in ValidingPaymentState
        throw new UnsupportedOperationException("Cannot initialize transaction while validating payment.");
    }

    @Override
    public void selectItem() {
        // Not allowed in ValidingPaymentState
        throw new UnsupportedOperationException("Cannot select item while validating payment.");
    }

    @Override
    public void insertPayment() {
        System.out.println("Payment received. Validating...");
        // Check if payment is sufficient
        if (vendingMachine.getAmountInserted() > 0) {
            System.out.println("Payment validated! Processing transaction...");
            vendingMachine.setState(new DispenseState(vendingMachine));
            vendingMachine.dispenseItem();
        } else {
            System.out.println("Insufficient payment. Please insert more money.");
        }
    }

    @Override
    public void dispenseItem() {
        // Not allowed in ValidingPaymentState
        throw new UnsupportedOperationException("Cannot dispense item while validating payment.");
    }

    @Override
    public void outOfStock() {
        // Not allowed in ValidingPaymentState
        throw new UnsupportedOperationException("Cannot mark item as out of stock while validating payment.");
    }

    @Override
    public void cancelTransaction() {
        // Transition back to IdleState
        System.out.println("Transaction cancelled. Returning to idle state.");
        vendingMachine.setState(new IdleState(vendingMachine));
    }

    @Override
    public void returnPayment() {
        // Transition back to IdleState and return payment
        System.out.println("Payment returned. Returning to idle state.");
    }
}
