import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Base Product class
class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters for product properties
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // Display method
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Quantity: " + quantity + ", Price: $" + String.format("%.2f", price));
    }
}

// Electronics subclass
class Electronics extends Product {
    private String warranty;

    public Electronics(int id, String name, int quantity, double price, String warranty) {
        super(id, name, quantity, price);
        this.warranty = warranty;
    }

    // Getters for electronics properties
    public String getWarranty() {
        return warranty;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Warranty: " + warranty);
    }
}

// Main Stock Management System class
class StockManagementSystem {
    // Use ArrayList for dynamic sizing
    private List<Product> products = new ArrayList<>();
    private Scanner sc = new Scanner(System.in); // Single Scanner instance

    public static void main(String[] args) {
        StockManagementSystem s = new StockManagementSystem();
        s.run();
    }

    public void run() {
        int choice;
        boolean running = true; // More descriptive variable name

        while (running) {
            displayMenu();
            choice = getUserChoice();

            switch (choice) {
                case 1:
                    addGeneralProduct();
                    break;
                case 2:
                    addElectronicsProduct();
                    break;
                case 3:
                    viewAllProducts();
                    break;
                case 4:
                    System.out.println("Exiting Stock Management System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
            System.out.println(); // Add a blank line for better separation
        }
        sc.close(); // Close the scanner when done
    }

    // Displays the main menu options
    private void displayMenu() {
        System.out.println("--- Stock Management System ---");
        System.out.println("1. Add General Product");
        System.out.println("2. Add Electronics Product");
        System.out.println("3. View All Products");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    // Gets and validates user's menu choice
    private int getUserChoice() {
        while (true) {
            try {
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline left-over
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // Consume the invalid input
                System.out.print("Enter your choice: ");
            }
        }
    }

    // Helper method to get valid integer input
    private int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = sc.nextInt();
                sc.nextLine(); // Consume newline left-over
                if (value < 0) {
                    System.out.println("Value cannot be negative. Please try again.");
                } else {
                    return value;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                sc.nextLine(); // Consume the invalid input
            }
        }
    }

    // Helper method to get valid double input
    private double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = sc.nextDouble();
                sc.nextLine(); // Consume newline left-over
                if (value < 0) {
                    System.out.println("Value cannot be negative. Please try again.");
                } else {
                    return value;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                sc.nextLine(); // Consume the invalid input
            }
        }
    }

    void addGeneralProduct() {
        System.out.println("\n--- Add General Product ---");
        int id = getIntInput("Enter Product ID: ");
        String name = getStringInput("Enter Product Name: ");
        int quantity = getIntInput("Enter Quantity: ");
        double price = getDoubleInput("Enter Price: ");

        products.add(new Product(id, name, quantity, price));
        System.out.println("General Product '" + name + "' added successfully!");
    }

    void addElectronicsProduct() {
        System.out.println("\n--- Add Electronics Product ---");
        int id = getIntInput("Enter Product ID: ");
        String name = getStringInput("Enter Product Name: ");
        int quantity = getIntInput("Enter Quantity: ");
        double price = getDoubleInput("Enter Price: ");
        String warranty = getStringInput("Enter Warranty Period (e.g., 1 year, 6 months): ");

        products.add(new Electronics(id, name, quantity, price, warranty));
        System.out.println("Electronics Product '" + name + "' added successfully!");
    }

    // Helper method to get string input
    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }


    void viewAllProducts() {
        if (products.isEmpty()) { // Use isEmpty() for ArrayList
            System.out.println("No products available in the system.");
        } else {
            System.out.println("\n--- Product List ---");
            for (Product product : products) { // Enhanced for-loop
                product.display();
                System.out.println("--------------------");
            }
        }
    }
}
