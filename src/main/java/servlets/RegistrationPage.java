package servlets;

import database.MySQLMethods;
import org.json.JSONObject;
import validation.RegistrationPageValidation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet("/registration")
public class RegistrationPage  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.getRequestDispatcher("/WEB-INF/view/registration.jsp").forward(request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject jsonEnt = new JSONObject();
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("passwordRepeat");
        PrintWriter out = response.getWriter();

        if (user != null ){
            try {
                jsonEnt.put("name", RegistrationPageValidation.nameRegistration(user));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (password != null){
            jsonEnt.put("password", RegistrationPageValidation.passwordRegistration(password));
        }
        if (
                !RegistrationPageValidation.passwordRepeatRegistration(password, passwordRepeat).equals("Passwords do not match")
                & !Objects.requireNonNull(user).equals("")
                & !Objects.requireNonNull(password).equals("")){

            String query = "INSERT INTO `date`.`user` (`name`, `password`) VALUES ('"+user+"', '"+password+"');";

            try {
                MySQLMethods.insertQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else {
            jsonEnt.put("passwordRepeat", RegistrationPageValidation.passwordRepeatRegistration(password,passwordRepeat));
        }

        out.print(jsonEnt);
        out.flush();
        out.close();


    }
}
