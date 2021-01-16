<%-- 
    Document   : adminDashboard
    Created on : 09-Dec-2020, 20:15:47
    Author     : Niklas Sarup-Lytzen ID: 18036644
--%>
<%@ include file = "/objects/jspHeader.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard Page</title>
        <style>
            <%@include file="/WEB-INF/css/style.css"%>
        </style>
    </head>
    <body>
        <div class="grid-container">    

            <c:import url="objects/dashboardHeader.jsp"/>

            <aside class="sidenav">

            </aside>                  

            <main class="main">
                <div class="main-cards">
                    <div class="card">
                        <c:import url="objects/patientTable.jsp"/>
                    </div>
                    <div class="card">
                        <c:import url="objects/pendingEmployeesTable.jsp"/>
                    </div>
                    <div class="card">
                        <c:import url="objects/personalInfo.jsp"/>
                    </div>
                    
                </div>

            </main>

        </div>
    </body>
</html>


