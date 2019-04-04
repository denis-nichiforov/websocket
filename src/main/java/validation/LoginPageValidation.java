package validation;

import database.MySQLMethods;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPageValidation {

    public static String loginName(String name) throws SQLException {
        String error = null;
        String query = "SELECT * FROM date.user where name = '" + name + "'";
        ResultSet exist = MySQLMethods.executeQuery(query);

        if (!exist.next())
            error = "A user not found";
        return error;

    }


    public static String passwordRepeat(String login, String password) throws SQLException {

        String error = null;

        String query = "SELECT password FROM date.user where name = '" + login + "'";
        ResultSet resultSet = MySQLMethods.executeQuery(query);

        while (resultSet.next()) {
            String savePassword = resultSet.getString("password");

            if (savePassword.equals(password)) {
                error = "";
            } else if (!savePassword.equals(password)) {
                error = "Passwords do not match";
            }
            return error;

        }
        return error;
    }
}
