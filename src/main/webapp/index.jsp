<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<% if(request.getSession().getAttribute("usuario") == null){
	response.sendRedirect("JSP/login.jsp");
}%>
   	<div class="container mt-5">
        <form action="ListProductsController" method="GET">
            <button type="submit" class="btn btn-primary">Acceder a la aplicación</button>
        </form>
    </div>
</body>
</html>
