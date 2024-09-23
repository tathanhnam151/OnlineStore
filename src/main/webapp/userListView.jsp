<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>User List</title>
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

                input[type="button"] {
                    background-color: #4CAF50;
                    color: white;
                    padding: 12px 20px;
                    margin: 0 10px;
                    border: none;
                    border-radius: 4px;
                    cursor: pointer;
                    font-size: 16px;
                }

                input[type="button"]:hover {
                    background-color: #45a049;
                }
            </style>
        </head>

        <body>
            <h1>User List</h1>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Sex</th>
                    <th>Country</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>${user.sex}</td>
                        <td>${user.country}</td>
                        <td>
                            <input type="button" value="Update"
                                onclick="window.location.href='${pageContext.request.contextPath}/users/update?id=${user.id}';">
                        </td>
                        <td>
                            <input type="button" value="Delete"
                                onclick="window.location.href='${pageContext.request.contextPath}/users/delete?id=${user.id}';">
                        </td>
                    </tr>
                </c:forEach>
                <c:if test="${empty users}">
                    <tr>
                        <td colspan="6" class="empty-message">No users available.</td> <!-- Updated colspan -->
                    </tr>
                </c:if>
            </table>
            <div class="button-container">
                <input type="button" value="Create User"
                    onclick="window.location.href='${pageContext.request.contextPath}/users/create';">
            </div>
        </body>

        </html>