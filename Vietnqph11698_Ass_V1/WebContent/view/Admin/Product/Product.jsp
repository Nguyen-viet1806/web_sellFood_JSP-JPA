
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<form class="form-product" action="Vietnqph11698_Ass_V1/ProductServlet"
	method="post" enctype="multipart/form-data">
	<div class="formP">
		<div class="form-group">
			<label for="exampleFormControlFile1" >Example file input</label> <input
				name="imgProduct" type="file" class="form-control-file"
				id="exampleFormControlFile1" > <img style="margin-top: 10px"
				src="${Product.imgProduct==null?'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQBY-YZl7MNp5apNCutue3ZJl0jGPT1wZyJQ&usqp=CAU':Product.imgProduct}"
				width="200">
		</div>
	</div>
	<div class="formP">
		<div class="form-group">
			<label for="usr">ID Product:</label> <input name="id"
				disabled="disabled" type="text" class="form-control" id="usr"
				value="${Product.idProduct}">
		</div>
		<div class="form-group">
			<label for="usr">Name Product:</label> <input type="text"
				class="form-control" id="usr" name="nameProduct"
				value="${Product.nameProduct}">
		</div>
		<div class="form-group">
			<label for="usr">Price Product:</label> <input type="text"
				class="form-control" id="usr" name="moneyProduct"
				value="${Product.moneyProduct}">
		</div>
		<div class="alert"
			style=" display: ${style==null?'none':style};  background-color:${backgroundErro}; width: 280px; margin-left: 15px ">
			<span class="closebtn"
				onclick="this.parentElement.style.display='none';">&times;</span>
			${content}
		</div>
	</div>
	<div class="formP">
		<select class="form-control" name="nameCategory">
			<option value="Thể loại">Thể loại</option>
			<c:forEach var="items" items="${lstCategory}">
				<option value="${items.idCategory}"
					${Product.category_DTO.idCategory==items.idCategory?'selected="selected"':''}>${items.nameCategory}</option>
			</c:forEach>

		</select>
		<div class="form-group">
			<label for="usr">Note:</label> <input value="${Product.noteProduct}"
				type="text" class="form-control" id="usr" name="noteProduct">
		</div>
		<button type="submit" class="btn btn-success"
			formaction="/Vietnqph11698_Ass_V1/ProductServlet/Submit?idP=${Product.idProduct}">Submit</button>
		<button type="submit" class="btn btn-light"
			formaction="/Vietnqph11698_Ass_V1/ProductServlet/Reset">Reset</button>

	</div>

</form>
<form class="table-product" action="Vietnqph11698_Ass_V1/ProductServlet"
	method="post">
	<div style="display: flex;; margin: 10px 0 10px 0;">
		<input style="width: 300px" class="form-control mr-sm-2" type="search"
			placeholder="Search" aria-label="Search" name="text-search">
		<button class="btn btn-outline-success my-2 my-sm-0" type="submit"
			formaction="/Vietnqph11698_Ass_V1/ProductServlet/Search">Search</button>
	</div>


	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id Product</th>
				<th scope="col">Product</th>
				<th scope="col">Name</th>
				<th scope="col">Price</th>
				<th scope="col">Category</th>
				<th scope="col">Note</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lstProduct}" var="items">
				<tr>
					<th scope="row">${items.idProduct}</th>
					<td><img src="${items.imgProduct}" width="100"></td>
					<td>${items.nameProduct}</td>
					<td>${items.moneyProduct}</td>
					<td>${items.category_DTO.nameCategory}</td>
					<td>${items.noteProduct}</td>
					<td><a
						style="background: ${items.status_DTO.idStatus==1?'#ff76ac':'#2afed7'}"
						class="btn btn-primary delete"
						href="/Vietnqph11698_Ass_V1/ProductServlet?action=delete&idProduct=${items.idProduct}"
						role="button">${items.status_DTO.idStatus==1?'Delete':'Restore'}</a>
						<a class="btn btn-primary"
						href="/Vietnqph11698_Ass_V1/ProductServlet?action=show&idProduct=${items.idProduct}"
						role="button">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<nav aria-label="Page navigation example ">
		<ul class="pagination">
			<li class="page-item"><a class="page-link"
				href="/Vietnqph11698_Ass_V1/ProductServlet?action=prev&page=${page}"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>
			<li class="page-item"><a class="page-link" href="#">${page==null?'1':page/5 + 1}</a></li>
			<li class="page-item"><a class="page-link"
				href="/Vietnqph11698_Ass_V1/ProductServlet?action=next&page=${page}"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
</form>