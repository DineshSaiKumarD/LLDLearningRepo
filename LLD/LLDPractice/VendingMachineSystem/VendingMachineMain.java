package VendingMachineSystem;

import VendingMachineSystem.models.Item;
import VendingMachineSystem.models.Stock;
import java.util.Scanner;

public class VendingMachineMain {
    
    public static void main(String[] args) {
        
        // Initialize vending machine with id as 1 --can be extended to multiple machines...in future
        VendingMachine vendingMachine = new VendingMachine(1);
        
        // Initialize stock with items
        initializeStock(vendingMachine);
        
        // Start interactive menu
        startInteractiveMenu(vendingMachine);
    }
    
    private static void initializeStock(VendingMachine vendingMachine) {
        Stock stock = vendingMachine.getStock();
        
        // Add items to stock
        stock.addItem(new Item("A1", "Coke", 1.50, 10));
        stock.addItem(new Item("A2", "Sprite", 1.50, 8));
        stock.addItem(new Item("B1", "Candy Bar", 1.00, 15));
        stock.addItem(new Item("B2", "Chips", 1.25, 12));
        stock.addItem(new Item("C1", "Coffee", 2.00, 5));
        
        System.out.println("Stock initialized!");
        stock.displayInventory();
    }
    
    private static void startInteractiveMenu(VendingMachine vendingMachine) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            displayMenu();
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":
                    initiateTransaction(vendingMachine, scanner);
                    break;
                case "2":
                    vendingMachine.getStock().displayInventory();
                    break;
                case "3":
                    System.out.println("Thank you for using the vending machine!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("------ MAIN MENU ------");
        System.out.println("1. Start Transaction");
        System.out.println("2. View Inventory");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private static void initiateTransaction(VendingMachine vendingMachine, Scanner scanner) {
        System.out.println("\n--- Transaction Started ---");
        vendingMachine.initTransaction();
        
        // Select item
        System.out.print("Enter Item ID (ex: A1, B2, C1) ");
        String itemId = scanner.nextLine().trim().toUpperCase();
        
        // Validate item exists and is available
        if (!vendingMachine.getStock().isItemAvailable(itemId)) {
            System.out.println("Item not available or out of stock!");
            vendingMachine.cancelTransaction();
            return;
        }
        
        Item selectedItem = vendingMachine.getStock().getItem(itemId);
        vendingMachine.setSelectedItemId(itemId);
        
        System.out.println("Selected Item: " + selectedItem.getItemName() + " - Price: $" + selectedItem.getPrice());
        vendingMachine.selectItem();
        
        // Insert payment
        System.out.print("Enter payment amount: $");
        try {
            double paymentAmount = Double.parseDouble(scanner.nextLine().trim());
            
            if (paymentAmount < selectedItem.getPrice()) {
                System.out.println("Insufficient payment! Required: $" + selectedItem.getPrice());
                System.out.println("Transaction cancelled.");
                vendingMachine.cancelTransaction();
                return;
            }


            vendingMachine.setAmountInserted(paymentAmount);
            System.out.println("Payment of $" + paymentAmount + " received.");
            vendingMachine.insertPayment();
            
            // Calculate and return change
            double change = paymentAmount - selectedItem.getPrice();
            if (change > 0) {
                System.out.println("Change returned: $" + String.format("%.2f", change));
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid payment amount");
            vendingMachine.cancelTransaction();
        }
    }
}

