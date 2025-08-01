package src;

import java.sql.*;
import java.util.Scanner;

public class ProductDAO {

    public void addProduct(Product product) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, product.getName());
        ps.setDouble(2, product.getPrice());
        ps.setInt(3, product.getQuantity());
        ps.executeUpdate();
        con.close();
        System.out.println("Product Added Successfully!");
    }

    public void viewProducts() throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM products";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " | " +
                               rs.getString("name") + " | " +
                               rs.getDouble("price") + " | " +
                               rs.getInt("quantity"));
        }
        con.close();
    }

    public void updateStock(int id, Scanner sc) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE products SET quantity=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        System.out.print("Enter New Quantity: ");
        ps.setInt(1, Integer.parseInt(sc.nextLine()));
        ps.setInt(2, id);
        int rows = ps.executeUpdate();
        con.close();
        if (rows > 0) {
            System.out.println("Stock Updated Successfully!");
        } else {
            System.out.println("Product ID not found!");
        }
    }

    public void deleteProduct(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "DELETE FROM products WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        int rows = ps.executeUpdate();
        con.close();
        if (rows > 0) {
            System.out.println("Product Deleted Successfully!");
        } else {
            System.out.println("Product ID not found!");
        }
    }
}