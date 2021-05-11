 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
    
     <h1 class="title">
        <span>Giỏ hàng của tôi</span>
      </h1>
<form action="/Vietnqph11698_Ass_V1/Cart1User" method="post">
	<div class="cart-block">
		<div class="cart-info table-responsive">

			<table class="table product-list">
				<thead>
					<tr>
						<th></th>
						<th>Tên sản phẩm</th>
						<th>Giá</th>
						<th>Số lượng</th>
						<th>Thành tiền</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="items" items="${lstCartDetail}">
						<tr ng-repeat="item in OrderDetails" class="ng-scope">
							<td class="image"><a href="#"> <img
									class="img-responsive" src="${items.product_DTO.imgProduct}"
									width="100" />
							</a></td>
							<td class="des">
								<h2>
									<a href="#" class="ng-binding"></a>
								</h2> <span class="ng-binding">${items.product_DTO.nameProduct}</span>
							</td>
							<td class="price ng-binding">${items.product_DTO.moneyProduct}</td>
							<td class="quantity"><input type="number"
							 name="${items.idCartDetail}"	value="${items.quantityProduct}"
								class="text ng-pristine ng-untouched ng-valid"
								 min="1" /></td>
							<td  class="amount ng-binding">${items.product_DTO.moneyProduct*items.quantityProduct}</td>

							<td class="remove">
								<button style="border: none; color: red; background: white"
									type="button" class=" text-uppercase mr-3 ">
									<a
										href="/Vietnqph11698_Ass_V1/Cart1User?action=delete&idCartDetail=${items.idCartDetail}">Xóa</a>
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button class="btn btn-danger btn-updateCart"
				style="marginRight: 5px" formaction="/Vietnqph11698_Ass_V1/Cart1User/UpdateCart">Cập nhập giỏ hàng!</button>
		</div>
		<div class="clearfix text-right">
			<span> <b>Tổng thanh toán:</b>
			</span> <span class="pay-price ng-binding">${PriceAll}đ</span>
		</div>
	</div>
		<div class="alert"
			style=" display:  ${style==null?'none':style};  background-color:${backgroundErro}; width: 400px; margin-left: 400px; ">
			<span class="closebtn"
				onclick="this.parentElement.style.display='none';">&times;</span>
			${content}
		</div>
	<div class="button text-right mt-2">
					<button type="submit" class="btn btn-danger btn-TT" formaction="/Vietnqph11698_Ass_V1/Cart1User/Pay" >
						Tiến hành thanh toán</button>
					<a class="btn btn-default " href="/Vietnqph11698_Ass_V1/Product1User"> Tiếp tục mua hàng
					</a>
					<a class="btn btn-default " href="/Vietnqph11698_Ass_V1/Bill1User"> Xem đơn hàng
					</a>
				</div>
</form>
