<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SmartCareSurgerySystem</title>
        <style>
            <%@include file="/WEB-INF/css/dashboardStyle.css"%>
        </style>
    </head>
    <body>
            <div class="dashboard login">
                <h1>Smart Care Surgery System</h1>
                <h2>Login</h2>
                <br>
                <form action="login.do" method="post">
                    <input id="username" name="username" required="required" type="text" placeholder="Username"/>
                    <input id="password" name="password" required="required" type="password" placeholder="Password" />
                    <input type="submit" value="Submit" />
                </form>
                <br>
                <br>
                <form action="logout.do" method="post">
                    <input type="submit" value="Change password" />
                </form>
                
            </div>
    </body>
</html>

