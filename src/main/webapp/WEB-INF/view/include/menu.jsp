<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="d" %>>



<d:url var="url_logout" value="/logout" />

<c:if test="${sessionScope.userId==null}">
    <%-- user is not logged in--%>
    <d:url var="url_reg_form" value="/reg_form" />
    <d:url var="url_home" value="/index" />
    <d:url var="url_about" value="/website_about" />
    <a href="${url_home}"> Home</a>  | <a href="#">Login</a>  | <a href="${url_reg_form}">Register</a>  | <a href="${url_about}">About</a>
    </c:if>
    
    
    
    <c:if test="${sessionScope.userId!=null && sessionScope.role==1}">
    <%-- admin is logged in--%>
    
    <d:url var="url_ahome" value="/admin/dashboard" />
    <a href="${url_ahome}">Home</a>  | <a href="<d:url value="/admin/users"/>">User List</a>  | <a href="${url_logout}">Logout</a> 
    </c:if>

 <c:if test="${sessionScope.userId!=null && sessionScope.role==2}">
     <%-- user is  logged in--%>
     <d:url var="url_uhome" value="/user/dashboard" />
     <d:url var="url_cform" value="/user/contact_form" />
    <d:url var="url_clist" value="/user/clist" />
    <a href="${url_uhome}">Home</a>  | <a href="${url_cform}">Add Contact</a>  | <a href="${url_clist}">Contact List</a> | <a href="${url_logout}">Logout</a>
    </c:if>
    
