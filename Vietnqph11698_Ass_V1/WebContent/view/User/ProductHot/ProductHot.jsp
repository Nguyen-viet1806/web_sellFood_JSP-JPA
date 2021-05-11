<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="container">
		<div class="row mt-4">
			<h6 class="list-product-title">Sản phẩm nổi bật</h6>
		</div>
		<div class="product-group">
			<div class="row ml-2">
			<c:forEach var="items" items="${lstproduct}">
			<div class="col-md-3 col-sm-6 col-12">
					<div class="card card-product">
						<img src="${items.imgProduct}" class="card-img-top" alt="..." />
						<div class="card-body">
							<h6 class="card-title">${items.nameProduct}</h6>
							<p class="card-text">${items.moneyProduct}</p>
							<a class="btn btn-outline-danger" href="/Vietnqph11698_Ass_V1/Cart1User?idProduct=${items.idProduct}">Mua hàng
			</a>

						</div>
					</div>
				</div>
			</c:forEach>
				
				
			</div>
		</div>
	</div>