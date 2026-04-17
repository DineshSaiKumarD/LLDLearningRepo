package VendingMachineSystem.stateimpl;

import VendingMachineSystem.State;
import VendingMachineSystem.VendingMachine;

public class IdleState implements State {
    
    private VendingMachine vendingMachine;
    
    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    
    @Override
    public void init_transaction() {
        System.out.println("Transaction initiated. Please select an item.");
        vendingMachine.setState(new SelectingState(vendingMachine));
    }
    
    @Override
    public void selectItem() {
        throw new UnsupportedOperationException("Please initialize transaction first.");
    }
    
    @Override
    public void insertPayment() {
        throw new UnsupportedOperationException("Please initialize transaction first.");
    }
    
    @Override
    public void dispenseItem() {
        throw new UnsupportedOperationException("Please initialize transaction first.");
    }
    
    @Override
    public void outOfStock() {
        throw new UnsupportedOperationException("No transaction in progress.");
    }
    
    @Override
    public void cancelTransaction() {
        throw new UnsupportedOperationException("No transaction to cancel.");
    }
    
    @Override
    public void returnPayment() {
        throw new UnsupportedOperationException("No payment to return.");
    }
}
