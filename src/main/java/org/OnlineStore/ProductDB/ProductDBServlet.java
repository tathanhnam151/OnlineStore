package org.OnlineStore.ProductDB;

import org.OnlineStore.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/productdb")
public class ProductDBServlet extends HttpServlet {
    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productDAO.getAllProducts();
        request.setAttribute("productsDB", products);
        request.getRequestDispatcher("/productDBList.jsp").forward(request, response);
    }

    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost called");
        String productId = request.getParameter("productId");
        System.out.println("productId: " + productId);
        Product product = productDAO.getProductById(productId);
        System.out.println("product: " + product);
    
        if (product != null) {
            HttpSession session = request.getSession();
            List<Product> cart = (List<Product>) session.getAttribute("cartDB");
            if (cart == null) {
                cart = new ArrayList<>();
                session.setAttribute("cartDB", cart);
            }
            System.out.println("cart before: " + cart);
            cart.add(product);
            System.out.println("cart after: " + cart);
        }
    
        response.sendRedirect(request.getContextPath() + "/cartDB");
    }
}