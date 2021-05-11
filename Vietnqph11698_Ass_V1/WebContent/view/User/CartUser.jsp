 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
     <div class="container">
        <div class="row mt-4">
          <div class="col-md-12">
			<div class="cart-content ng-scope" ng-controller="orderController"
				ng-init="initOrderCartController()">
				<jsp:include page="/view/User/CartProduct/CartProduct.jsp" />
			</div>
		</div>
        </div>
      </div>