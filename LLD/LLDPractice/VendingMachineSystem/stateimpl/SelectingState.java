package VendingMachineSystem.stateimpl;

import VendingMachineSystem.State;
import VendingMachineSystem.VendingMachine;

public class SelectingState implements State {
    
    private VendingMachine vendingMachine;
    
    public SelectingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    
    @Override
    public void init_transaction() {
        // Not allowed in SelectingState
        throw new UnsupportedOperationException("Transaction already initialized. Please select an item.");
    }

    @Override
    public void selectItem() {
        // Handle item selection logic
        System.out.println("Item selected. Please insert payment.");
        // Transition to ValidatingPaymentState
        vendingMachine.setState(new ValidingPayementState(vendingMachine));
    }

    @Override
    public void insertPayment() {
        // Not allowed in SelectingState
        throw new UnsupportedOperationException("Please select an item before inserting payment.");
    }

    @Override
    public void dispenseItem() {
        // Not allowed in SelectingState
        throw new UnsupportedOperationException("Please select an item and insert payment before dispensing.");
    }

    @Override
    public void outOfStock() {
        // Not allowed in SelectingState
        throw new UnsupportedOperationException("Cannot mark item as out of stock while selecting.");
    }

    @Override
    public void cancelTransaction() {
        // Handle transaction cancellation logic
        System.out.println("Transaction cancelled. Returning to idle state.");
        // Transition to IdleState
        vendingMachine.setState(new IdleState(vendingMachine));
    }

    @Override
    public void returnPayment() {
        // Not allowed in SelectingState
        throw new UnsupportedOperationException("No payment to return. Please select an item first.");
    }
}
