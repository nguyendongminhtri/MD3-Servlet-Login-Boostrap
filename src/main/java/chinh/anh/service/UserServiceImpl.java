package chinh.anh.service;

import chinh.anh.config.ConnectMySQL;
import chinh.anh.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements IUserService{
    Connection connection = ConnectMySQL.getConnect();
//    public static final String SELECT_USER = "select * from users where username=? and password=?";
    public static final String SELECT_USER = "SELECT * FROM users WHERE username=? AND password=?";
    @Override
    public Users findByUsernameAndPassword(String username, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_USER);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            Users users = null;
            if (resultSet.next()) {
                users = new Users();
                users.setFullName(resultSet.getString("fullName"));
                users.setUsername(username);
                users.setPassword(password);
            }
            return users;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
