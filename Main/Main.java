import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional; // Used for safer handling of search results
import java.util.Scanner;

// Base Product class
// Represents a generic product with common attributes.
class Product {
    private final int id; // Product ID, made final as it should be immutable
    private final String name; // Product name, made final
    private int quantity; // Current stock quantity, mutable
    private double price; // Price per unit, mutable

    /**
     * Constructor to initialize a new Product.
     * @param id Unique identifier for the product.
     * @param name Name of the product.
     * @param quantity Initial stock quantity.
     * @param price Price of the product.
     */
    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // --- Getters for product properties ---
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

    // --- Setters for mutable properties with basic validation ---
    /**
     * Sets the quantity of the product.
     * Ensures the quantity is not negative.
     * @param quantity The new quantity to set.
     */
    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.err.println("Error: Quantity cannot be negative. Value not updated.");
        }
    }

    /**
     * Sets the price of the product.
     * Ensures the price is not negative.
     * @param price The new price to set.
     */
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.err.println("Error: Price cannot be negative. Value not updated.");
        }
    }

    /**
     * Displays the details of the product to the console.
     * Formats the price to two decimal places.
     */
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Quantity: " + quantity + ", Price: $" + String.format("%.2f", price));
    }
}

// Electronics subclass
// Extends Product to include a specific attribute: warranty.
class Electronics extends Product {
    private final String warranty; // Warranty period for the electronic product, made final

    /**
     * Constructor to initialize a new Electronics product.
     * @param id Unique identifier for the product.
     * @param name Name of the product.
     * @param quantity Initial stock quantity.
     * @param price Price of the product.
     * @param warranty Warranty period (e.g., "1 year", "6 months").
     */
    public Electronics(int id, String name, int quantity, double price, String warranty) {
        super(id, name, quantity, price); // Call to the superclass constructor
        this.warranty = warranty;
    }

    // Getter for electronics specific property
    public String getWarranty() {
        return warranty;
    }

    /**
     * Overrides the display method from the Product class to include warranty information.
     */
    @Override
    public void display() {
        super.display(); // Call to the superclass's display method
        System.out.println("Warranty: " + warranty);
    }
}

// Main Stock Management System class
// Manages the collection of products and user interactions.
class StockManagementSystem {
    // A dynamic list to store all products (both general and electronics)
    private List<Product> products = new ArrayList<>();
    // Single Scanner instance to handle all console inputs
    private Scanner sc = new Scanner(System.in);

    /**
     * Main method - entry point of the application.
     * Creates an instance of StockManagementSystem and starts its execution.
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        StockManagementSystem s = new StockManagementSystem();
        s.run();
    }

    /**
     * Runs the main application loop, displaying the menu and processing user choices.
     * Continues until the user chooses to exit.
     */
    public void run() {
        int choice;
        boolean running = true; // Flag to control the application's running state

        while (running) {
            displayMenu(); // Show menu options to the user
            choice = getUserChoice(); // Get validated user input for the menu choice

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
                    updateProduct(); // New functionality: Update product
                    break;
                case 5:
                    deleteProduct(); // New functionality: Delete product
                    break;
                case 6:
                    System.out.println("Exiting Stock Management System. Goodbye!");
                    running = false; // Set flag to false to terminate the loop
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
            System.out.println(); // Add a blank line for better visual separation between iterations
        }
        sc.close(); // Close the scanner to release system resources when the application exits
    }

    /**
     * Displays the main menu options to the console.
     */
    private void displayMenu() {
        System.out.println("--- Stock Management System ---");
        System.out.println("1. Add General Product");
        System.out.println("2. Add Electronics Product");
        System.out.println("3. View All Products");
        System.out.println("4. Update Product");
        System.out.println("5. Delete Product");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Gets and validates the user's menu choice.
     * Handles InputMismatchException for non-integer inputs.
     * @return The validated integer choice from the user.
     */
    private int getUserChoice() {
        while (true) {
            try {
                int choice = sc.nextInt();
                sc.nextLine(); // Consume the leftover newline character
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // Consume the invalid input to clear the scanner buffer
                System.out.print("Enter your choice: "); // Re-prompt the user
            }
        }
    }

    /**
     * Helper method to get a validated integer input from the user.
     * Ensures the input is a whole number and non-negative.
     * @param prompt The message to display to the user.
     * @return The validated integer value.
     */
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

    /**
     * Helper method to get a validated double input from the user.
     * Ensures the input is a numeric value and non-negative.
     * @param prompt The message to display to the user.
     * @return The validated double value.
     */
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

    /**
     * Helper method to get a string input from the user.
     * @param prompt The message to display to the user.
     * @return The string input from the user.
     */
    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    /**
     * Checks if a product with the given ID already exists in the system.
     * @param id The ID to check for uniqueness.
     * @return true if the ID is already taken, false otherwise.
     */
    private boolean isProductIdTaken(int id) {
        return products.stream().anyMatch(p -> p.getId() == id);
    }

    /**
     * Finds a product by its ID in the list of products.
     * @param id The ID of the product to find.
     * @return An Optional containing the Product if found, or an empty Optional if not found.
     */
    private Optional<Product> findProductById(int id) {
        return products.stream()
                       .filter(p -> p.getId() == id)
                       .findFirst();
    }

    /**
     * Guides the user through adding a new general product.
     * Ensures the product ID is unique.
     */
    void addGeneralProduct() {
        System.out.println("\n--- Add General Product ---");
        int id;
        // Loop until a unique product ID is entered by the user
        while (true) {
            id = getIntInput("Enter Product ID: ");
            if (isProductIdTaken(id)) {
                System.out.println("Product with ID " + id + " already exists. Please enter a unique ID.");
            } else {
                break; // Exit loop if ID is unique
            }
        }
        String name = getStringInput("Enter Product Name: ");
        int quantity = getIntInput("Enter Quantity: ");
        double price = getDoubleInput("Enter Price: ");

        products.add(new Product(id, name, quantity, price));
        System.out.println("General Product '" + name + "' added successfully!");
    }

    /**
     * Guides the user through adding a new electronics product.
     * Ensures the product ID is unique and collects warranty information.
     */
    void addElectronicsProduct() {
        System.out.println("\n--- Add Electronics Product ---");
        int id;
        // Loop until a unique product ID is entered by the user
        while (true) {
            id = getIntInput("Enter Product ID: ");
            if (isProductIdTaken(id)) {
                System.out.println("Product with ID " + id + " already exists. Please enter a unique ID.");
            } else {
                break; // Exit loop if ID is unique
            }
        }
        String name = getStringInput("Enter Product Name: ");
        int quantity = getIntInput("Enter Quantity: ");
        double price = getDoubleInput("Enter Price: ");
        String warranty = getStringInput("Enter Warranty Period (e.g., 1 year, 6 months): ");

        products.add(new Electronics(id, name, quantity, price, warranty));
        System.out.println("Electronics Product '" + name + "' added successfully!");
    }

    /**
     * Displays all products currently stored in the system.
     * Informs the user if no products are available.
     */
    void viewAllProducts() {
        if (products.isEmpty()) { // Check if the products list is empty
            System.out.println("No products available in the system.");
        } else {
            System.out.println("\n--- Product List ---");
            // Iterate through each product and call its specific display method (polymorphism)
            for (Product product : products) {
                product.display();
                System.out.println("--------------------"); // Separator for better readability
            }
        }
    }

    /**
     * Allows the user to update the quantity or price of an existing product.
     * Prompts for product ID, finds it, and then allows specific field updates.
     */
    void updateProduct() {
        System.out.println("\n--- Update Product ---");
        if (products.isEmpty()) {
            System.out.println("No products to update.");
            return;
        }

        int idToUpdate = getIntInput("Enter the ID of the product to update: ");
        Optional<Product> productOptional = findProductById(idToUpdate); // Use Optional for safer handling

        if (productOptional.isPresent()) {
            Product product = productOptional.get(); // Get the actual product object
            System.out.println("Current details for product ID " + idToUpdate + ":");
            product.display();

            System.out.println("\nWhat do you want to update?");
            System.out.println("1. Quantity");
            System.out.println("2. Price");
            System.out.print("Enter your choice: ");
            int updateChoice = getUserChoice(); // Reusing getUserChoice for sub-menu

            switch (updateChoice) {
                case 1:
                    int newQuantity = getIntInput("Enter new Quantity: ");
                    product.setQuantity(newQuantity); // Use setter with validation
                    System.out.println("Quantity updated for product '" + product.getName() + "'.");
                    break;
                case 2:
                    double newPrice = getDoubleInput("Enter new Price: ");
                    product.setPrice(newPrice); // Use setter with validation
                    System.out.println("Price updated for product '" + product.getName() + "'.");
                    break;
                default:
                    System.out.println("Invalid update choice. No changes made.");
            }
        } else {
            System.out.println("Product with ID " + idToUpdate + " not found.");
        }
    }

    /**
     * Allows the user to delete an existing product by its ID.
     * Prompts for product ID, finds it, and removes it from the list.
     */
    void deleteProduct() {
        System.out.println("\n--- Delete Product ---");
        if (products.isEmpty()) {
            System.out.println("No products to delete.");
            return;
        }

        int idToDelete = getIntInput("Enter the ID of the product to delete: ");
        Optional<Product> productOptional = findProductById(idToDelete); // Use Optional for safer handling

        if (productOptional.isPresent()) {
            Product productToRemove = productOptional.get(); // Get the product to remove
            products.remove(productToRemove); // Remove the product from the list
            System.out.println("Product '" + productToRemove.getName() + "' (ID: " + idToDelete + ") deleted successfully!");
        } else {
            System.out.println("Product with ID " + idToDelete + " not found.");
        }
    }
}
