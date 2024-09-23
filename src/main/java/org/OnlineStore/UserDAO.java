package org.OnlineStore;

import org.OnlineStore.utils.MySQLUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private MySQLUtils mySQLUtils;

    public UserDAO() {
        this.mySQLUtils = new MySQLUtils();
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = mySQLUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("Name");
                String password = resultSet.getString("Password");
                String email = resultSet.getString("Email");
                String sex = resultSet.getString("Sex");
                String country = resultSet.getString("Country");
                User user = new User(id, name, password, email, sex, country);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void addUser(User user) {
        try (Connection connection = mySQLUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Users (Name, Password, Email, Sex, Country) VALUES (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getSex());
            statement.setString(5, user.getCountry());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUser(User user) {
        try (Connection connection = mySQLUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE Users SET Name = ?, Password = ?, Email = ?, Sex = ?, Country = ? WHERE id = ?");
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getSex());
            statement.setString(5, user.getCountry());
            statement.setInt(6, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(int id) {
        try (Connection connection = mySQLUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Users WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User getUserById(int id) {
        User user = null;
        try (Connection connection = mySQLUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("Name");
                String password = resultSet.getString("Password");
                String email = resultSet.getString("Email");
                String sex = resultSet.getString("Sex");
                String country = resultSet.getString("Country");
                user = new User(id, name, password, email, sex, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}