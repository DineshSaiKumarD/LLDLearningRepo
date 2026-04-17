package VendingMachineSystem.stateimpl;

import VendingMachineSystem.State;
import VendingMachineSystem.VendingMachine;

public class DispenseState implements State {

    private VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void init_transaction() {
        // Not allowed in DispenseState
    }

    @Override
    public void selectItem() {
        // Not allowed in DispenseState
    }

    @Override
    public void insertPayment() {
        // Not allowed in DispenseState
    }

    @Override
    public void dispenseItem() {
        // Simulate dispensing item
        System.out.println("Dispensing item...");
        if (vendingMachine.getSelectedItemId() != null) {
            vendingMachine.getStock().dispenseItem(vendingMachine.getSelectedItemId());
            System.out.println("Item dispensed successfully!");
            vendingMachine.resetTransaction();
        }
        // Transition back to IdleState after dispensing
        vendingMachine.setState(new IdleState(vendingMachine));
    }

    @Override
    public void outOfStock() {
        // Not allowed in DispenseState
        throw new IllegalStateException("Item is out of stock");
    }

    @Override
    public void cancelTransaction() {
        // Not allowed in DispenseState
            throw new IllegalStateException("Cannot cancel transaction while dispensing");
    }

    @Override
    public void returnPayment() {
        // Not allowed in DispenseState
        throw new IllegalStateException("Cannot return payment while dispensing");
    }
}
