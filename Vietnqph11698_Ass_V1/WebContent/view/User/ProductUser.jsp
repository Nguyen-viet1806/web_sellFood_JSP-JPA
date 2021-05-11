<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<div class="container">
        <div class="row mt-4 menu-product">
          <!--category -->
	<jsp:include page="/view/User/Category/Category.jsp" />
	
	<div class=" col-md-8 col-12">
      <div class="product" style="margin-top: 30px">
        <!--sortProduct -->
	<jsp:include page="/view/User/SortProduct/SortProduct.jsp" />
      </div>

      <div class="product-group" >
      
      <form action="/Vietnqph11698_Ass_V1/Product1User" method="get">
      <div style="display: flex; margin-left: 16px">
      <input style="width: 300px; height: 40px"
			name="textSearch" class="form-control" id="myInput" type="text" placeholder="Search.." />
		<button
			style="width: 80px; height: 40px; "
			class="btn btn-outline-danger" type="submit" formaction="/Vietnqph11698_Ass_V1/Product1User/action=search">Tìm</button>
      </div>
      </form>
      
        <div style="margin-top: 10px" class="row ml-2">
         <!--ProductUnit -->
	<jsp:include page="/view/User/ProductUnit/ProductUnit.jsp" />
        </div>
      </div>
      <div class="product-group">
        <div class="row ml-2">
         <!--ProductUnit -->
	<jsp:include page="/view/User/ProductUnit/ProductUnit1.jsp" />
        </div>
      </div>

      <nav aria-label="Page navigation example dieuhuong">
        <ul class="pagination">
          <li
            class="page-item"
          >
            <a class="page-link" aria-label="Previous" href="/Vietnqph11698_Ass_V1/Product1User?action=prev&page=${page}">
              <span aria-hidden="true">&laquo;</span>
              <span class="sr-only">Previous</span>
            </a>
          </li>
          <li class="page-item">
            <a class="page-link">${page==null?'1':page/6 + 1}</a>
          </li>
          <li
            class="page-item"
          >
            <a class="page-link" aria-label="Next" href="/Vietnqph11698_Ass_V1/Product1User?action=next&page=${page}">
              <span aria-hidden="true">&raquo;</span>
              <span class="sr-only">Next</span>
            </a>
          </li>
        </ul>
      </nav>
 
    </div>
	
        </div>
      </div>