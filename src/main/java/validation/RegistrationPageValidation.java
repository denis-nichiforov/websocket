package validation;

import database.MySQLMethods;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationPageValidation {


    public static String nameRegistration(String name) throws SQLException {
        String error = null;
        String query = "SELECT * FROM date.user where name = '" + name + "'";
        ResultSet exist = MySQLMethods.executeQuery(query);


        if (exist.next()) {
            error = "Already exists a person with this name";
            return error;
        } else {
            if (name.length() > 16) {
                error = "The length of the name no more 16 characters";
            }if (name.length() < 3) {
                error = "The length of the name at least 3 characters";
            }else {
                error = "";
            }

            return error;

        }
    }

    public static String passwordRegistration(String password) {
        String error = null;
        if (password.length() > 16) {
            error = "The length of the password no more 16 characters";
        }if (password.length() < 6) {
            error = "The length of the password at least 6 characters";
        }else {
            error = "";
        }

        return error;
    }

    public static String passwordRepeatRegistration(String password, String passwordRepeat) {

        String error = null;

        if (passwordRepeat.equals(password)) {
            error = "";
        }if (!passwordRepeat.equals(password)) {
            error = "Passwords do not match";
        }
        return error;
    }






}