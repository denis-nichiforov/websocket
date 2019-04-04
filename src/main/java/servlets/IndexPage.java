package servlets;

import database.MySQLMethods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/main")
public class IndexPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        Integer id = Integer.parseInt(request.getParameter("id"));
//
//        System.out.println(id);


        HttpSession session = request.getSession();




        Integer a = (Integer) session.getAttribute("sessionsId");
//
//        boolean check = !id.equals(a);
//
//        if (check) {
//            request.setAttribute("id", a);
//            request.getRequestDispatcher("resources/template/mistakes/mistake404.jsp").forward(request, response);
//        }

//        String stringId = a.toString();

        if (a == null) {
            request.getRequestDispatcher("resources/template/mistakes/mistake404.jsp").forward(request, response);
        } else {
            String query = "SELECT name FROM date.user where id = '" + a + "'";
            ResultSet resultSet = null;
            String name = null;

            try {
                resultSet = MySQLMethods.executeQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                assert resultSet != null;
                if (resultSet.next()) {

                    name = resultSet.getString("name");
                    request.setAttribute("id", a);
                    request.setAttribute("answer", name); // Will be available as ${products} in JSP
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("id", a);
            request.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}