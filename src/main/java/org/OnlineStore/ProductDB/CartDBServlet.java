package org.OnlineStore.ProductDB;

import org.OnlineStore.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/cartDB")
public class CartDBServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cartDB");

        request.setAttribute("cartDB", cart);
        request.getRequestDispatcher("/cartDB.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        HttpSession session = request.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cartDB");

        if (cart != null) {
            cart.removeIf(product -> product.getId().equals(productId));
        }

        response.sendRedirect(request.getContextPath() + "/cartDB");
    }
}