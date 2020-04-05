

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>  <%--to add url u have to use taglib(s for spring)--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard: Contact Application</title>
        <link href="static/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <s:url var="url_bg" value="/static/images/back5.jpeg"/>  <%--to add url u have to use taglib--%>
    <body background="${url_bg}">
        <table border="1" width="80%" align="center">
            
                <tr>
                <td height="80px">  <%--Header--%>
                <jsp:include page="include/header.jsp"/>
                
                </td>
                </tr>
                
                <tr>
                <td height="25px" >  <%--Menu--%>
                    <jsp:include page="include/menu.jsp"/>
                    </td>
                </tr>
                
                <tr>
                <td height="350px" valign="top">  <%--Page Content--%>
                    <h1>Admin Dashboard</h1>
                    </td>
                </tr>
                
                 <tr>
                <td height="25px">  <%--Footer--%>
                    <jsp:include page="include/footer.jsp"/>
                    </td>
                </tr>
            
            
        </table>
    </body>
</html>

