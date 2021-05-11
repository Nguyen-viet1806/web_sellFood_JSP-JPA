  <%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%> 
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<form class="form-product" action="/Vietnqph11698_Ass_V1/BillServlet" method="post">

	<div class="formP">
		<div class="form-group"
			${imgBill==null?'style="display: none"':imgBill }>
			<label for="exampleFormControlFile1">Example file input</label> <input
				type="file" class="form-control-file" id="exampleFormControlFile1"
				disabled="disabled"> <img style="margin-top: 10px"
				src="${imgProduct==null?'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQBY-YZl7MNp5apNCutue3ZJl0jGPT1wZyJQ&usqp=CAU':imgProduct }"
				width="200">
		</div>
	
	</div>
	<div class="formP">
		<div class="form-group">
			<label for="usr">${lbl1==null?'ID Bill':lbl1}</label> <input
				disabled="disabled" type="text" class="form-control" id="usr"
				value="${input1}" >
		</div>
		<div class="form-group">
			<label for="usr">${lbl2==null?'Name User':lbl2}</label> <input
				disabled="disabled" type="text" class="form-control" id="usr"
				value="${input2}">
		</div>
		<div class="form-group">
			<label for="usr">${lbl3==null?'Date Oder':lbl3}</label> <input
				disabled="disabled" type="text" class="form-control" id="usr"
				value="${input3}">
		</div>
			<div class="alert"
			style=" display: ${style==null?'none':style};  background-color:${backgroundErro}; width: 280px; margin-left: 15px ">
			<span class="closebtn"
				onclick="this.parentElement.style.display='none';">&times;</span>
			${content}
		</div>
	</div>
	<div class="formP">
		<div class="form-group">
			<label for="usr">${lbl4==null?'Note':lbl4}</label> <input
				disabled="disabled" type="text" class="form-control" id="usr"
				value="${input4}">
		</div>
		<select ${statusBill==null?'':statusBill } style="margin-top: 58px" class="form-control" name="statusBill">
			<option value="Thể loại">Trạng thái</option>
			<c:forEach var="items" items="${listStatus}">
				<option value="${items.idStatus}"
					${Bill.status_DTO.idStatus==items.idStatus?'selected="selected"':''}>${items.nameStatus}</option>
			</c:forEach>

		</select>
		<button type="submit" ${sumbitBill==null?'':sumbitBill } class="btn btn-success" formaction="/Vietnqph11698_Ass_V1/BillServlet/UpdateBill?id=${input1}">Submit</button>
		<button type="button" class="btn btn-light">Reset</button>

	</div>
</form>
<form class="table-product" action="">
				<div style="display: flex; ;margin: 10px 0 10px 0;">
				<input style="width: 300px" class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</div>
					
			
				<table style="width: 500px" class="table table-bill">
					<thead>
						<tr>
							<th scope="col">Id Bill</th>
							<th scope="col">Name user</th>
							<th scope="col">Date Oder</th>
							<th scope="col">Status</th>
							<th scope="col">Note</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
			<c:forEach var="items" items="${listBIll}">
				<tr>
					<th scope="row">${items.idBill }</th>
					<td>${items.user_DTO.nameUser }</td>
					<td>${items.dateOrder }</td>
					<td>${items.status_DTO.nameStatus }</td>
					<td>${items.noteBill }</td>
					<td>
						<a class="btn btn-primary" href="/Vietnqph11698_Ass_V1/BillServlet?action=showBill&idBill=${items.idBill}" role="button">Edit</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
				</table>
				<table style="width: 500px" class="table table-bill">
					<thead>
						<tr>
							<th scope="col">Id BillDetail</th>
							<th scope="col">Id Bill</th>
							<th scope="col">Product</th>
							<th scope="col">Quantity</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
			<c:forEach var="items" items="${lstBillDetail}">
				<tr>
					<th scope="row">${items.idBillDetail }</th>
					<td>${items.bill_DTO.idBill }</td>
					<td>${items.product_DTO.nameProduct }</td>
					<td>${items.quantityProduct }</td>
					<td>
							<a class="btn btn-primary" href="/Vietnqph11698_Ass_V1/BillServlet?action=showBillDetail&idBillDetail=${items.idBillDetail}&idBill=${items.bill_DTO.idBill}" role="button">Edit</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
				</table>
				
				<nav style="margin-top: 60%" aria-label="Page navigation example ">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="#"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
				</nav>
			</form>