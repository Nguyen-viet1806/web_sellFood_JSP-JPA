<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${tieude}</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style type="text/css">
<%@ include file="Admin.css" %>
</style>
</head>
<body >
<div class="all">
<nav id="sidebar">
<div class="sidebar-header">
<h4>Việt NQV</h4>
<p>Coder</p>
</div>
  <a class="dropdown-item" href="/Vietnqph11698_Ass_V1/HomeServlet" >Trang chủ ></a>
  <a class="dropdown-item" href="/Vietnqph11698_Ass_V1/ProductServlet">Quản lí sản phẩm ></a>
  <a class="dropdown-item" href="/Vietnqph11698_Ass_V1/CategoryServlet">Quản lí thể loại ></a>
  <a class="dropdown-item" href="/Vietnqph11698_Ass_V1/BillServlet">Quản lí hóa đơn ></a>
  <a class="dropdown-item" href="?action=on"  ${menuSmart1==null?'style="display: none"':menuSmart1}>Menu Thông minh></a>
    <a class="dropdown-item" href="/Vietnqph11698_Ass_V1/Home1User">User></a>
  
</nav>
<div class="nav sticky-top">
<ul>
<li><a href="./HomeServlet"  >Trang chủ</a></li>
<li><a href="./ProductServlet">Sản phẩm</a></li>
<li><a href="./CategoryServlet">Thể loại</a></li>
<li><a href="./BillServlet">Hóa đơn</a></li>
</ul>
<img src="${account.user_DTO.imgUser}" alt="Avatar" class="avatar" />
<p>${account.user_DTO.nameUser}</p>
</div>
		<div class="page">
			<jsp:include page="MenuSmart.jsp"></jsp:include>
			<jsp:include
				page="${View==null?'./Category/Category.jsp':View}"/>
			<!-- ../Admin/Bill/Bill.jsp -->
		</div>
		<div class="footer">
<h3>Đây là footter</h3>
</div>
</div>

</body>
</html>