package VendingMachineSystem.models;

import java.util.HashMap;
import java.util.Map;

public class Stock {
    private Map<String, Item> inventory;
    
    public Stock() {
        this.inventory = new HashMap<>();
    }
    
    public void addItem(Item item) {
        if (inventory.containsKey(item.getItemId())) {
            Item existingItem = inventory.get(item.getItemId());
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        } else {
            inventory.put(item.getItemId(), item);
        }
    }
    
    public Item getItem(String itemId) {
        return inventory.get(itemId);
    }
    
    public boolean isItemAvailable(String itemId) {
        Item item = inventory.get(itemId);
        return item != null && item.getQuantity() > 0;
    }
    
    public void dispenseItem(String itemId) {
        Item item = inventory.get(itemId);
        if (item != null && item.getQuantity() > 0) {
            item.decrementQuantity();
        }
    }
    
    public void displayInventory() {
        System.out.println("\n===== INVENTORY =====");
        for (Item item : inventory.values()) {
            System.out.println(item);
        }
        System.out.println("====================\n");
    }
}
