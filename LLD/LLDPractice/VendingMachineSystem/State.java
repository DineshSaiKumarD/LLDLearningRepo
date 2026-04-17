package VendingMachineSystem;

public interface State {
    void init_transaction();
    void selectItem();
    void insertPayment();
    void dispenseItem();
    void outOfStock();
    void cancelTransaction();
    void returnPayment();
}
