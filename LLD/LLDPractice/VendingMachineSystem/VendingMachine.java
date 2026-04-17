package VendingMachineSystem;

import VendingMachineSystem.models.Stock;
import VendingMachineSystem.stateimpl.IdleState;

public class VendingMachine {
    
    private int machineId;
    private Stock stock;
    private State currentState;
    private String selectedItemId;
    private double amountInserted;
    
    public VendingMachine(int machineId) {
        this.machineId = machineId;
        this.stock = new Stock();
        this.currentState = new IdleState(this);
        this.selectedItemId = null;
        this.amountInserted = 0.0;
    }
    
    public void setState(State state) {
        this.currentState = state;
    }
    
    public void initTransaction() {
        currentState.init_transaction();
    }
    
    public void selectItem() {
        currentState.selectItem();
    }
    
    public void insertPayment() {
        currentState.insertPayment();
    }
    
    public void dispenseItem() {
        currentState.dispenseItem();
    }
    
    public void outOfStock() {
        currentState.outOfStock();
    }
    
    public void cancelTransaction() {
        currentState.cancelTransaction();
    }
    
    public void returnPayment() {
        currentState.returnPayment();
    }
    
    public int getMachineId() {
        return machineId;
    }
    
    public Stock getStock() {
        return stock;
    }
    
    public State getCurrentState() {
        return currentState;
    }
    
    public String getSelectedItemId() {
        return selectedItemId;
    }
    
    public void setSelectedItemId(String itemId) {
        this.selectedItemId = itemId;
    }
    
    public double getAmountInserted() {
        return amountInserted;
    }
    
    public void setAmountInserted(double amount) {
        this.amountInserted = amount;
    }
    
    public void addToAmountInserted(double amount) {
        this.amountInserted += amount;
    }
    
    public void resetTransaction() {
        this.selectedItemId = null;
        this.amountInserted = 0.0;
    }
}
