import java.io.*;

// Custom Exception for invalid product data
class InvalidProductDataException extends Exception {
    public InvalidProductDataException(String message) {
        super(message);
    }
}

public class ProductFilter {

    public static void main(String[] args) {
        String inputFile = "products.csv";               // Input file
        String outputFile = "filtered_products.csv";     // Output file

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            // Open files
            reader = new BufferedReader(new FileReader(inputFile));
            writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(",");
                    if (parts.length < 2) {
                        throw new InvalidProductDataException("Invalid row: " + line);
                    }

                    String name = parts[0].trim();
                    double price;

                    try {
                        price = Double.parseDouble(parts[1].trim());
                    } catch (NumberFormatException e) {
                        throw new InvalidProductDataException("Invalid price format in row: " + line);
                    }

                    // Condition: price > 1000
                    if (price > 1000) {
                        writer.write(name + "," + price);
                        writer.newLine();
                    }
                } catch (InvalidProductDataException e) {
                    System.err.println(e.getMessage()); // Log invalid rows
                }
            }

            System.out.println("Filtering complete! Check " + outputFile);

        } catch (FileNotFoundException e) {
            System.err.println("Error: Input file not found → " + inputFile);
        } catch (IOException e) {
            System.err.println("Error while processing file: " + e.getMessage());
        } finally {
            // Ensure resources are closed
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
