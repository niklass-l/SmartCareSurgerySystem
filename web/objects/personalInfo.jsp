<%-- 
    Document   : personalInfo
    Author     : Niklas Sarup-Lytzen ID: 18036644
--%>

<%@ include file = "/objects/jspHeader.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Personal information</h3>
        <p>
            Date of birth: ${currentUser.dateOfBirth}<br>

            <c:catch>
                <c:if test = "${not empty currentUser.insured}">
                    Insured by the NHS: ${currentUser.insured ? 'Yes' : 'No'}<br>
                </c:if>
            </c:catch>
            <c:catch>
                <c:if test = "${not empty currentUser.fullTime}">
                    Full-time employee: ${currentUser.fullTime ? 'Yes' : 'No'}<br>
                </c:if>
            </c:catch>

            <br>
            ${currentUser.address.addressLine1}<br>

            <c:if test = "${not empty currentUser.address.addressLine2}">
                ${currentUser.address.addressLine2}<br>
            </c:if>
            ${currentUser.address.postcode}<br>
            ${currentUser.address.county}<br>
            ${currentUser.address.town}<br>
            ${currentUser.address.telephoneNumber}<br>
        </p>
    </body>
</html>
