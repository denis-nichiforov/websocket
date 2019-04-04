package servlets;


import database.MySQLMethods;
import org.json.JSONObject;
import validation.LoginPageValidation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginPage extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session != null) {
            session.getAttribute("sessionsId");
            System.out.println(session.getAttribute("sessionsId"));
            session.removeAttribute("sessionsId");
        }

        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JSONObject jsonEnt = new JSONObject();
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Integer id = null;


        if (user != null) {
            try {
                jsonEnt.put("name", LoginPageValidation.loginName(user));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (password != null) {
            try {
                jsonEnt.put("password", LoginPageValidation.passwordRepeat(user, password));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        String query = "SELECT id FROM date.user where name = '" + user + "'";
        ResultSet resultSet = null;
        try {
            resultSet = MySQLMethods.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                assert resultSet != null;
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                id = resultSet.getInt("id");
                jsonEnt.put("id", id);




            } catch (SQLException e) {
                e.printStackTrace();
            }
            session.setAttribute("sessionsId",id);



            out.print(jsonEnt);
            out.flush();
            out.close();
            request.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(request, response);

        }
    }
}
