package database;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.*;

public class MySQLMethods {


//    private static Connection connection;


//    public static Driver driver = getDriver();` `
//
//    public static Connection getConnection() {
//
//        try {
//            connection = DriverManager.getConnection(MySQLConfig.URL, MySQLConfig.USERNAME, MySQLConfig.PASSWORD);
//
//        } catch (SQLException e) {
//            System.out.println("Error: " + e.getMessage());
//            e.printStackTrace();
//        }
//        return connection;
//
//    }


//    private static Driver getDriver() {
//        Driver d = null;
//        try {
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return d;
//    }

    public static ResultSet executeQuery(String execute) throws SQLException {
//        Connection connection = MySQLMethods.getConnection();

        Connection connection = DBCPDataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(execute);

        return resultSet;
    }


    public static void insertQuery(String insert) throws SQLException {
//       Connection connection = MySQLMethods.getConnection();

        Connection connection = DBCPDataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(insert);

    }

    public static void updateQyery(String update) throws SQLException {
//        Connection connection = MySQLMethods.getConnection();

        Connection connection = DBCPDataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(update);

    }

    public static void deleteQyery(String delete) throws SQLException {
//        Connection connection = MySQLMethods.getConnection();


        Connection connection = DBCPDataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(delete);
    }

}
