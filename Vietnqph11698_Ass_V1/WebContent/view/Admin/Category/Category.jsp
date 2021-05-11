    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<form class="form-product" action="Vietnqph11698_Ass_V1/CategoryServlet" method="post">
				
				<div class="formP">
					<div class="form-group">
						<label for="usr">ID Category:</label> <input name="id" disabled="disabled" type="text"
							class="form-control" id="usr" value="${Category.idCategory}">
					</div>
					<div class="form-group">
						<label for="usr">Name Category:</label> <input name="nameCategory" type="text"
							class="form-control" id="usr" value="${Category.nameCategory}">
					</div>

		<div class="alert" style=" display: ${style==null?'none':style};  background-color:${backgroundErro}; ">
			<span class="closebtn"
				onclick="this.parentElement.style.display='none';">&times;</span> 
			${content}
		</div>
		<button type="submit" class="btn btn-success" formaction="/Vietnqph11698_Ass_V1/CategoryServlet/Submit?idct=${Category.idCategory}">Submit</button>
					<button type="submit" class="btn btn-light" formaction="/Vietnqph11698_Ass_V1/CategoryServlet/Reset">Reset</button>
		
	</div>
			</form>
			<form class="table-product" action="Vietnqph11698_Ass_V1/CategoryServlet" method="post">
				<div style="display: flex; ;margin: 10px 0 10px 0;">
				<input style="width: 300px" class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search" name="text-search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit" formaction="/Vietnqph11698_Ass_V1/CategoryServlet/Search">Search</button>
				</div>
					
			
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Id Category</th>
							<th scope="col">Name Category</th>
							<th scope="col">Status</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${lstCategory}" var="items">
						<tr>
							<th scope="row">${items.idCategory}</th>
							<td>${items.nameCategory}</td>
							<td>
								<a style="background: ${items.status_DTO.idStatus==1?'#ff76ac':'#2afed7'}" class="btn btn-primary delete" href="/Vietnqph11698_Ass_V1/CategoryServlet?action=delete&idCategory=${items.idCategory}" role="button">${items.status_DTO.idStatus==1?'Delete':'Restore'}</a>
								<a class="btn btn-primary" href="/Vietnqph11698_Ass_V1/CategoryServlet?action=show&idCategory=${items.idCategory}" role="button">Edit</a>
							</td>
						</tr>
						</c:forEach>
						

					</tbody>
				</table>
				<nav aria-label="Page navigation example ">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="/Vietnqph11698_Ass_V1/CategoryServlet?action=prev&page=${page}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
						<li class="page-item"><a class="page-link" href="#">${page==null?'1':page/5 + 1}</a></li>
						<li class="page-item"><a class="page-link" href="/Vietnqph11698_Ass_V1/CategoryServlet?action=next&page=${page}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
				</nav>
			</form>