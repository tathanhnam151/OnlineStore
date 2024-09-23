package org.OnlineStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private List<Product> products; // Assume this is initialized with some products

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", products);
        request.getRequestDispatcher("/productList.jsp").forward(request, response);
    }

    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        Product product = findProductById(productId);

        if (product != null) {
            HttpSession session = request.getSession();
            List<Product> cart = (List<Product>) session.getAttribute("cart");
            if (cart == null) {
                cart = new ArrayList<>();
                session.setAttribute("cart", cart);
            }
            cart.add(product);
        }

        response.sendRedirect("/cart");
    }

    private Product findProductById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void init() throws ServletException {
        products = new ArrayList<>();
        products.add(new Product("P001", "Laptop", 1200.99));
        products.add(new Product("P002", "Smartphone", 799.49));
        products.add(new Product("P003", "Headphones", 150.00));
        products.add(new Product("P004", "Monitor", 300.00));
        products.add(new Product("P005", "Keyboard", 50.25));
        products.add(new Product("P006", "Mouse", 30.75));
        products.add(new Product("P007", "Smartwatch", 199.99));
        products.add(new Product("P008", "Tablet", 400.99));
        products.add(new Product("P009", "Camera", 950.00));
        products.add(new Product("P010", "Printer", 180.50));
    }
}
