# 📂 Product Filter with Exception Handling  

## 🎯 Objective  
Improve the previous File I/O task by **adding proper exception handling** to make the program **robust and reliable**.  

---

## 🛠 Tools  
- Java  
- IDE (Eclipse, IntelliJ, VS Code)  
- CSV file  

---

## 📚 Key Concepts  
- File Handling (read/write)  
- Exception Hierarchy  
- Checked vs Unchecked Exceptions  
- Custom Exceptions  
- `try-catch-finally` for safe resource handling  

---

## 🚀 Steps Implemented  

1. Start with **CSV reading** task (from Task 4).  
2. Wrap file reading in a **try-catch** to handle `FileNotFoundException`.  
3. Catch `NumberFormatException` when parsing product price.  
4. Create a **custom exception** `InvalidProductDataException` for invalid rows.  
5. Use `finally` (or try-with-resources) to close files safely.  
6. Test with **valid and invalid data**.  

---

## 📂 Files in Project  

1. **`products.csv`** → Input file (created manually).  
   **Example content:** 
   ```bash
   Laptop,85000
   Mobile,abc
   Tablet,1500
   Headphones
   TV,30000
   
2. **`ProductFilterCSVWithExceptions.java`** → Main program file.
   - Reads input file.
   - Handles invalid or missing data with proper exceptions.
   - Filters products with price > 1000.
   - Creates a new file with results.
     
3. **`filtered_products.csv`** → Output file (auto-generated).
   **Example after running:**
    ```bash
    Laptop,85000
    Tablet,1500
    TV,30000

---

## ▶️ How to Run
  Save your Java file as:
  **`ProductFilterCSVWithExceptions.java`**

  Place your **`products.csv`** in the same project folder as your Java file.

 Compile and run:

    ```bash
      javac ProductFilterCSVWithExceptions.java
      java ProductFilterCSVWithExceptions
      Check output in filtered_products.csv

---

## ✅ Example Output
**Console Output:**

    ```
    📂 Reading products.csv...
    ⚠️ Skipping invalid data: Mobile,abc
    ⚠️ Skipping invalid data: Headphones
    ✅ Filtering complete! Check filtered_products.csv
    
**Generated File (filtered_products.csv):**

    ```bash
      Laptop,85000
      Tablet,1500
      TV,30000
