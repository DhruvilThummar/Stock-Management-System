---

# Stock Management System

This is a simple command-line based Stock Management System developed in Java. It allows you to manage different types of products, specifically general products and electronic products with an added warranty feature.

---

## Features

* **Add General Products:** Add products with basic details like ID, name, quantity, and price.
* **Add Electronics Products:** Add electronic products with the same basic details as general products, plus a warranty period.
* **View All Products:** Display a list of all products currently in the system, showing their specific details.
* **Input Validation:** The system includes basic input validation to ensure that numerical inputs (ID, quantity, price) are valid and non-negative, and handles incorrect input types gracefully.

---

## How to Run

1.  **Save the Code:** Save all the provided Java code into a single file named `StockManagementSystem.java`.
2.  **Compile:** Open a terminal or command prompt, navigate to the directory where you saved the file, and compile the code using the Java compiler:
    ```bash
    javac StockManagementSystem.java
    ```
3.  **Run:** After successful compilation, run the application:
    ```bash
    java StockManagementSystem
    ```

---

## Usage

Once you run the application, you'll see a menu:

```
--- Stock Management System ---
1. Add General Product
2. Add Electronics Product
3. View All Products
4. Exit
Enter your choice:
```

Enter the number corresponding to your desired action:

* **1 (Add General Product):** You'll be prompted to enter the product's ID, name, quantity, and price.
* **2 (Add Electronics Product):** You'll be prompted for the product's ID, name, quantity, price, and warranty period.
* **3 (View All Products):** This will display a list of all products added so far, along with their details.
* **4 (Exit):** This will close the application.

---

## Code Structure

The code is organized into three main classes:

* **`Product`**: This is the base class for all products. It holds common attributes like ID, name, quantity, and price. It also has a `display()` method to show product details.
* **`Electronics`**: This class extends `Product` and adds a specific attribute for `warranty`. It overrides the `display()` method to include warranty information.
* **`StockManagementSystem`**: This is the main class that contains the `main` method and manages the overall application flow. It handles user input, adds products to a list, and displays them. It also includes helper methods for robust input handling.

---
