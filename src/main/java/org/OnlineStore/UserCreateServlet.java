package org.OnlineStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/create")
public class UserCreateServlet extends HttpServlet {
    private UserDAO userDAO;

    public UserCreateServlet() {
        this.userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/userCreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String sex = req.getParameter("sex");
        String country = req.getParameter("country");

        User user = new User(0, name, password, email, sex, country);
        userDAO.addUser(user);

        resp.sendRedirect(req.getContextPath() + "/users");
    }
}