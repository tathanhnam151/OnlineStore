<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
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

                .empty-message {
                    text-align: center;
                    color: #999;
                }

                .button-container {
                    display: flex;
                    justify-content: center;
                    margin-top: 20px;
                }

                input[type="button"],
                input[type="submit"] {
                    background-color: #4CAF50;
                    color: white;
                    padding: 12px 20px;
                    margin: 0 10px;
                    border: none;
                    border-radius: 4px;
                    cursor: pointer;
                    font-size: 16px;
                }

                input[type="button"]:hover,
                input[type="submit"]:hover {
                    background-color: #45a049;
                }
            </style>
        </head>

        <body>
            <div class="container">
                <h1>Product DB List</h1>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach var="product" items="${productsDB}">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.name}</td>
                            <td>$${product.price}</td>
                            <td>
                                <form method="post" action="${pageContext.request.contextPath}/productdb">
                                    <input type="hidden" name="productId" value="${product.id}" />
                                    <input type="submit" value="Add to DB Cart" />
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty productsDB}">
                        <tr>
                            <td colspan="4" style="text-align: center;">No products available in DB.</td>
                        </tr>
                    </c:if>
                </table>
                <div style="text-align: center;">
                    <input type="button" value="Check your DB cart"
                        onclick="window.location.href='${pageContext.request.contextPath}/cartDB';">
                </div>
            </div>
        </body>

        </html>