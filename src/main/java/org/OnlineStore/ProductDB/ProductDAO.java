package org.OnlineStore.ProductDB;

import org.OnlineStore.Product;
import org.OnlineStore.utils.MySQLUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private MySQLUtils mySQLUtils;

    public ProductDAO() {
        this.mySQLUtils = new MySQLUtils();
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = mySQLUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                Product product = new Product(id, name, price);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public void addProduct(Product product) {
        try (Connection connection = mySQLUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Product (id, name, price) VALUES (?, ?, ?)");
            statement.setString(1, product.getId());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateProduct(Product product) {
        try (Connection connection = mySQLUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE Product SET name = ?, price = ? WHERE id = ?");
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setString(3, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProduct(String id) {
        try (Connection connection = mySQLUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Product WHERE id = ?");
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Product getProductById(String id) {
        Product product = null;
        try (Connection connection = mySQLUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE id = ?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                product = new Product(id, name, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return product;
    }
}