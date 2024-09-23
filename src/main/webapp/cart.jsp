<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.List" %>
        <%@ page import="org.OnlineStore.Product" %>
            <!DOCTYPE html>
            <html>

            <head>
                <title>Shopping Cart</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        margin: 0;
                        padding: 20px;
                        background-color: #f4f4f4;
                    }

                    h1 {
                        text-align: center;
                        color: #333;
                    }

                    table {
                        width: 80%;
                        margin: 20px auto;
                        border-collapse: collapse;
                        background-color: #fff;
                    }

                    th,
                    td {
                        padding: 12px;
                        text-align: left;
                        border-bottom: 1px solid #ddd;
                    }

                    th {
                        background-color: #4CAF50;
                        color: white;
                    }

                    tr:nth-child(even) {
                        background-color: #f2f2f2;
                    }

                    tr:hover {
                        background-color: #ddd;
                    }

                    a {
                        display: inline-block;
                        margin: 20px auto;
                        padding: 10px 15px;
                        background-color: #4CAF50;
                        color: white;
                        text-decoration: none;
                        border-radius: 4px;
                        text-align: center;
                        transition: background-color 0.3s ease;
                    }

                    a:hover {
                        background-color: #45a049;
                    }

                    .container {
                        max-width: 1200px;
                        margin: 0 auto;
                        padding: 20px;
                    }

                    .empty-cart {
                        text-align: center;
                        color: #999;
                    }
                </style>
            </head>

            <body>
                <div class="container">
                    <h1>Shopping Cart</h1>
                    <table>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                        </tr>
                        <% List<Product> cart = (List<Product>) request.getAttribute("cart");
                                if (cart != null && !cart.isEmpty()) {
                                for (Product product : cart) {
                                %>
                                <tr>
                                    <td>
                                        <%= product.getId() %>
                                    </td>
                                    <td>
                                        <%= product.getName() %>
                                    </td>
                                    <td>$<%= product.getPrice() %>
                                    </td>
                                </tr>
                                <% } } else { %>
                                    <tr>
                                        <td colspan="3" class="empty-cart">Your cart is empty.</td>
                                    </tr>
                                    <% } %>
                    </table>
                    <div style="text-align: center;">
                        <a href="/product">Continue Shopping</a>
                    </div>
                </div>
            </body>

            </html>