 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<div class="container">
	<div class="row mt-4">
		<div class="col-md-12">
			<div class="cart-content ng-scope" ng-controller="orderController"
				ng-init="initOrderCartController()">
				<div class="cart-block">
					<div class="cart-info table-responsive">

						<table class="table product-list billStatus">
							<thead>
								<tr>
									<th></th>
									<th><a href="?action=xuLi">Đang xử lí</a></th>
									<th><a href="?action=xacNhan">Đã xác nhận</a></th>
									<th><a href="?action=dangGiao">Đang giao</a></th>
									<th><a href="?action=thanhCong">Giao thành công</a></th>
									<th></th>
								</tr>
							</thead>
						</table>
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Ngày đặt</th>
									<th scope="col">Ghi chú</th>
									<th scope="col">Trạng thái</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="items" items="${lstbill}">
									<tr>
										<th scope="row">${items.idBill}</th>
										<td>${items.dateOrder}</td>
										<td>${items.noteBill}</td>
										<td>${items.status_DTO.nameStatus}</td>
										<td><a  ${updateBill==null?'style="display: none;"':updateBill } class="btn btn-primary" href="?action=updateBillTT&idBill=${items.idBill}" role="button">Đã nhận hàng</a></td>
									</tr>
								</c:forEach>


							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
