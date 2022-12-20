package pl.coderslab.entity;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.utils.DbUtil;
import pl.coderslab.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {
    private static final String CREATE_USER_QUERY =
            "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
    private static final String READ_USER_QUERY_BY_ID =
            "select * from users u where u.id = ?";
    private static final String READ_USER_QUERY_BY_EMAIL =
            "select * from users u where u.email = ?";
    private static final String UPDATE_USER_QUERY =
            "update users u " +
                    "set u.email = ?, u.username = ?, u.password = ? " +
                    "where id = ?";
    private static final String DELETE_USER_QUERY =
            "delete from users u where u.id = ?";
    private static final String READ_ALL_USER_QUERY =
            "select * from users";

    public User create(User user) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();
            //Pobieramy wstawiony do bazy identyfikator, a następnie ustawiamy id obiektu user.
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User read(int userId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement prepStatement = conn.prepareStatement(this.READ_USER_QUERY_BY_ID);
            prepStatement.setString(1, String.valueOf(userId));
            ResultSet resultSet = prepStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void update(User user) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(this.UPDATE_USER_QUERY);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUserName());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int userId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(this.DELETE_USER_QUERY);
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public ArrayList<User> findAll() {
        ArrayList<User> allUsers = new ArrayList<>();

        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(this.READ_ALL_USER_QUERY);
            ResultSet allUsersResultSet = statement.executeQuery();
            while (allUsersResultSet.next()) {
                User user = new User();
                user.setId(allUsersResultSet.getInt("id"));
                user.setUserName(allUsersResultSet.getString("username"));
                user.setEmail(allUsersResultSet.getString("email"));
                user.setPassword(allUsersResultSet.getString("password"));
                allUsers.add(user);
            }
            return allUsers;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public String verifyHash(String password, String hashed) {
        return BCrypt.hashpw(password, hashed);
    }
}
