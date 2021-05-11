<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${tieude}</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<style type="text/css">
<%@include file="User.css" %>
</style>
</head>
<body>
	<!--navbar -->
	<jsp:include page="/view/User/Navbar/Navbar.jsp" />
	
	<!--slide -->
	<jsp:include page="/view/User/Slide/Slide.jsp" />
	
	<%-- <!--home -->
	<jsp:include page="/view/User/HomeUser.jsp" /> --%>
	<%-- <jsp:include page="/view/User/Profile/Profile.jsp" /> --%>
	<%-- <jsp:include page="/view/User/BillUser.jsp" /> --%>
 <jsp:include page="${View==null?'/view/User/HomeUser.jsp':View}" />  

	<%-- <!--product -->
	<jsp:include page="/view/User/ProductUser.jsp" /> --%>
	
	<%-- <!--cartProduct -->
	<jsp:include page="/view/User/CartUser.jsp" /> --%>
	
	<!--footer -->
	<jsp:include page="/view/User/Footer/Footer.jsp" />
</body>
</html>