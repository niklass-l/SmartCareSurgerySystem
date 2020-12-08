<%-- 
    Document   : index
    Created on : 30-Nov-2020, 12:32:20
    Author     : patdizon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <style>
            td{
            padding: 10px;
            }
            div{
                width: 50%;
                border: 1px solid black;
                border-radius: 5px;
                background-color: lightcoral;
            }
            </style>
    </head>
    <body>
    <center><h1><u>Login Here</u></h1></center>
    <center>
        <div>
            <table>
                <tr>
                    <td>User name</td>
                    <td><input type="text" class="form-control" name="username" placeholder="User name"></td>
                </tr>
                
                <tr>
                    <td>Password</td>
                    <td><input type="password"  class="form-control" name="password" placeholder="Password"></td>
                </tr>
                   <tr>
                       <td colspan="2" style="text-align: center"><input class="btn btn-success" type="submit" value="Submit"></td>   
                      </tr> 
            </table>
        </div>
    </center>
    </body>
</html>
