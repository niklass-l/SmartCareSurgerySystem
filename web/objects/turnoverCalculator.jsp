<%-- 
    Document   : turnoverCalculator
    Author     : Niklas Sarup-Lytzen ID: 18036644
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "/objects/jspHeader.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Invoice table</h3> <br>

        <form method="post" action="${pageContext.request.contextPath}/protected/refresh.do" name="dateSelector">
            <input type="hidden" name="jspName" value="${pageScope['javax.servlet.jsp.jspPage']}" />
            <label for="fromDate">Show from date:</label>
            <input type="date" name="fromDate"> 
            <label for="toDate">to date:</label>
            <input type="date" name="toDate" onchange="this.form.submit();">
        </form>

        <br>

        <table class="timeTable">
            <thead>
                <tr>
                    <th>Patient name</th>
                    <th>Invoice date</th>
                    <th>Invoice total</th>
                    <th>Paid</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="invoice" items="${invoices}">
                    <tr>
                        <td>${invoice.patient.firstName} ${invoice.patient.surName}</td>
                        <td>${ex:formatDate(invoice["dateOfInvoice"], "dd-MM-yyyy")}</td>
                        <td>${invoice.price}</td>
                        <td>${invoice.paid ?  'Yes' : 'No'}</td>
                    </tr>
                </c:forEach>   
            </tbody>
        </table>

        <h4>Total turnover: £${turnoverPaid}. Total unpaid: £${turnoverUnpaid}</h4>
    </body>
</html>
