package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while (true) {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product Stock");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Product Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Product Price: ");
                        double price = Double.parseDouble(sc.nextLine());
                        System.out.print("Enter Product Quantity: ");
                        int quantity = Integer.parseInt(sc.nextLine());
                        dao.addProduct(new Product(0, name, price, quantity));
                        break;
                    case 2:
                        dao.viewProducts();
                        break;
                    case 3:
                        System.out.print("Enter Product ID to Update Stock: ");
                        int updateId = Integer.parseInt(sc.nextLine());
                        dao.updateStock(updateId, sc);
                        break;
                    case 4:
                        System.out.print("Enter Product ID to Delete: ");
                        int deleteId = Integer.parseInt(sc.nextLine());
                        dao.deleteProduct(deleteId);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid Option!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}