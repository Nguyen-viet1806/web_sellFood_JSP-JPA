 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
 <div class="col-md-4 col-12">
            <h3 >
              <span>Sản phẩm</span>
            </h3>
            <ul>
            <c:forEach var="items" items="${lstCategory}">
             <li >
                <span>
                  <a href="/Vietnqph11698_Ass_V1/Product1User?action=show&idCategory=${items.idCategory}">${items.nameCategory }</a>
                </span>
              </li>
            </c:forEach>
             
              
            </ul>
            <img src="http://runecom06.runtime.vn/Uploads/shop97/images/adv/left_1.png" width="350"/>
          </div>