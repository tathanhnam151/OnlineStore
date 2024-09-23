<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Create User</title>
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

            form {
                width: 50%;
                margin: 20px auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            label {
                display: block;
                font-size: 14px;
                margin-bottom: 8px;
                color: #333;
            }

            input[type="text"],
            input[type="password"],
            input[type="email"],
            select {
                width: 100%;
                padding: 10px;
                margin-bottom: 20px;
                border: 1px solid #ddd;
                border-radius: 4px;
                box-sizing: border-box;
            }

            .button-container {
                display: flex;
                justify-content: space-between;
            }

            input[type="submit"],
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

            input[type="submit"]:hover,
            input[type="button"]:hover {
                background-color: #45a049;
            }

            .form-container {
                display: flex;
                flex-direction: column;
                align-items: center;
            }
        </style>
    </head>

    <body>
        <h1>Create User</h1>
        <form action="${pageContext.request.contextPath}/users/create" method="post">
            <div class="form-container">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name">

                <label for="password">Password:</label>
                <input type="password" id="password" name="password">

                <label for="email">Email:</label>
                <input type="email" id="email" name="email">

                <label for="sex">Sex:</label>
                <select id="sex" name="sex">
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>

                <label for="country">Country:</label>
                <input type="text" id="country" name="country">

                <div class="button-container">
                    <input type="submit" value="Submit">
                    <input type="button" value="Cancel"
                        onclick="window.location.href='${pageContext.request.contextPath}/users';">
                </div>
            </div>
        </form>
    </body>

    </html>