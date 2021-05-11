<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div class="abc">
      <div class=" col-xs-12 col-sd-12 col-sm-12 col-lg-12 text-center ">
        <img
          src="${account.user_DTO.imgUser}" width="250"
          alt="Avatar"
          class="avatar border"
          style="width: 200px;"
        />
        
      </div>
      <div class="container row d-flex justify-content-center">
        <div class="col-xs-6 col-sd-6 col-sm-6 col-lg-6 p-3 text-center">
        
         <button class="profile custom-btn btn-9">Họ tên:${account.user_DTO.nameUser} </button>
          
         <button class="profile custom-btn btn-9">Ngày sinh:${account.user_DTO.birthDayUser} </button>
         <button class="profile custom-btn btn-9">Địa chỉ:${account.user_DTO.addressUser}   </button>
         
        </div>
        <div class="col-xs-6 col-sd-6 col-sm-6 col-lg-6 p-3 text-center">
         <button class="profile custom-btn btn-9">SĐT:${account.user_DTO.phoneNumber}</button>
          <button class="profile custom-btn btn-9">Note:${account.user_DTO.noteUser}</button>
           <button class="profile custom-btn btn-9"><a href="${account.role_DTO.idRole==1?'/Vietnqph11698_Ass_V1/ProductServlet':'#' }">${account.role_DTO.idRole==1?'Admin':'User' }</a></button>
          
        </div>
         <button class="profile custom-btn btn-9">Hobbies:</button>
      </div>
    </div>