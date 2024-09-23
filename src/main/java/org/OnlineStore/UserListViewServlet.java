package org.OnlineStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserListViewServlet extends HttpServlet {
    private UserDAO userDAO;

    public UserListViewServlet() {
        this.userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userDAO.getAllUsers();
        System.out.println(users);
        req.setAttribute("users", users);
        req.getRequestDispatcher("/userListView.jsp").forward(req, resp);
    }
}