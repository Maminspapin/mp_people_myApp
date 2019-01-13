package ru.maminspapin.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "PersonServlet", urlPatterns = "/people", displayName = "People")
public class PersonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/people",
                    "maminspapin",
                    "mamapapa");

            int z = 5;
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String patronymic = request.getParameter("patronymic");
            String sex = request.getParameter("sex");
            int age = Integer.valueOf(request.getParameter("age"));
            String profession = request.getParameter("profession");
            String status = request.getParameter("status");

            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate
                    ("insert into people (firstName, lastName, patronymic, sex, age, profession, status) " +
                            "values ('"+firstName+"','"+lastName+"','"+patronymic+"','"+sex+"','"+age+"','"+profession+"','"+status+"')");

            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        doGet(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/");
        rd.forward(request, response);

    }
}
