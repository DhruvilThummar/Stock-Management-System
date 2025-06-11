---

# Stock Management System

This is a robust and user-friendly command-line **Stock Management System** developed in Java. It allows for the efficient management of various products, including general items and electronic goods, with enhanced features like product ID uniqueness and comprehensive CRUD (Create, Read, Update, Delete) operations.

---

## Features

* **Add General Products**: Easily add new products by providing a **unique ID**, **name**, **quantity**, and **price**. The system ensures that no two products share the same ID.
* **Add Electronics Products**: Beyond general products, you can add electronic items, including their **warranty period**, while still ensuring a **unique product ID**.
* **View All Products**: Get a comprehensive list of all products currently in your system, with their detailed information displayed clearly.
* **Update Product Information**: Modify the **quantity** or **price** of existing products by simply providing their ID. The system validates inputs to prevent negative values.
* **Delete Products**: Remove products from your stock by entering their unique ID.
* **Robust Input Validation**: The system includes advanced input validation to ensure that numerical inputs (like ID, quantity, and price) are valid, non-negative, and handles incorrect input types gracefully.

---

## How to Run

To get this Stock Management System up and running on your local machine, follow these steps:

1.  **Save the Code**: Copy all the provided Java code and save it into a single file named `StockManagementSystem.java`.
2.  **Compile**: Open your terminal or command prompt. Navigate to the directory where you saved the `StockManagementSystem.java` file and compile the code using the Java compiler:

    ```bash
    javac StockManagementSystem.java
    ```

3.  **Execute**: After successful compilation, run the application using the Java Virtual Machine:

    ```bash
    java StockManagementSystem
    ```

---

## Usage

Once you execute the application, you will be presented with a clear and interactive menu in your console:

```
--- Stock Management System ---
1. Add General Product
2. Add Electronics Product
3. View All Products
4. Update Product
5. Delete Product
6. Exit
Enter your choice:
```

Simply enter the number corresponding to your desired action and press Enter:

* **1 (Add General Product)**: You'll be prompted to enter the **Product ID**, **Product Name**, **Quantity**, and **Price**.
* **2 (Add Electronics Product)**: You'll provide the same information as a general product, plus the **Warranty Period** (e.g., "1 year", "6 months").
* **3 (View All Products)**: This will display a list of all products currently in the system, along with their detailed information.
* **4 (Update Product)**: Enter the ID of the product you wish to modify. You will then have options to update its quantity or price.
* **5 (Delete Product)**: Enter the ID of the product you want to remove from the system.
* **6 (Exit)**: This option will safely terminate the application.

---

## Code Structure

The project is thoughtfully structured into three primary classes:

* **`Product`**: This is the fundamental **base class** for all products. It encapsulates essential attributes such as `id` (unique and immutable), `name` (immutable), `quantity`, and `price`. It also provides methods for accessing and modifying `quantity` and `price` with basic validation, and a `display()` method to output product details.
* **`Electronics`**: This class **extends `Product`**, inheriting all its properties and behaviors. It introduces an additional immutable attribute: `warranty`. The `display()` method is overridden to include this specific warranty information in its output.
* **`StockManagementSystem`**: This is the **main class** that orchestrates the entire application. It contains the `main` method, manages the collection of `Product` objects, handles user input through a `Scanner` instance, and implements all the menu options for adding, viewing, updating, and deleting products. It also includes helper methods for robust input validation and unique ID checking.

---

## Possible Future Enhancements

* **Data Persistence**: Implement functionality to save product data to a file (e.g., CSV, JSON) or a database, so information isn't lost when the application closes.
* **Advanced Search**: Add more sophisticated search options, allowing users to find products by name, price range, or other criteria.
* **Sorting Capabilities**: Enable sorting of products by ID, name, quantity, or price for better organization.
* **More Product Categories**: Introduce additional `Product` subclasses (e.g., `Books`, `Groceries`) with attributes specific to their categories.
* **Graphical User Interface (GUI)**: Convert the console-based application into a GUI application using libraries like Swing or JavaFX for a more visual and interactive experience.

---
