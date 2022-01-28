package chinh.anh.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMySQL {
    private static Connection connection;

    private ConnectMySQL() {
    }

//    public static final String URL = "jdbc:mysql://localhost:3306/c1021h1?characterEncoding=UTF-8";
    public static final String URL = "jdbc:mysql://b14a37c4b414d1:e67a119e@eu-cdbr-west-02.cleardb.net/heroku_e881e059959493e?reconnect=true?characterEncoding=UTF-8";
    //    public static final String URL = "mysql://b7132afa053dbf:fb387bec@eu-cdbr-west-01.cleardb.com/heroku_2302b9c80aec960?reconnect=true";
    public static final String USER = "b14a37c4b414d1";
    public static final String PASSWORD = "e67a119e";

    public static Connection getConnect(){
        if (connection==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD
                );
                System.out.println("ket noi thanh cong");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("ket noi khong thanh cong");
                e.printStackTrace();
            }
        }

        return  connection;
    }
}
