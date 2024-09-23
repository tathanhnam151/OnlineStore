package org.OnlineStore;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/users/update")
public class UserUpdateServlet extends HttpServlet {
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.getUserById(id); // Retrieve the user data from the database
        request.setAttribute("user", user);
        request.getRequestDispatcher("/userUpdate.jsp").forward(request, resp);
}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        String country = request.getParameter("country");
        
        User user = new User(id, name, password, email, sex, country);
        userDAO.updateUser(user);
        
        response.sendRedirect(request.getContextPath() + "/users");
    }
}