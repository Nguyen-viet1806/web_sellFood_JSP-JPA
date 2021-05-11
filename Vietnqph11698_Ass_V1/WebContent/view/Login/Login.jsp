<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>Login & Signup Form | CodingNepal</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
<%@ include file="Login.css" %>
</style>
</head>
<body>
	<div class="wrapper">
		<div class="title-text">
			<div class="title login">Login Form</div>
			<div class="title signup">Signup Form</div>
		</div>
		<div class="form-container">
			<div class="slide-controls">
				<input type="radio" name="slide" id="login" checked> <input
					type="radio" name="slide" id="signup"> <label for="login"
					class="slide login">Login</label> <label for="signup"
					class="slide signup">Signup</label>
				<div class="slider-tab"></div>
			</div>
			<div class="form-inner">
				<form action="Vietnqph11698_Ass_V1/Login" class="login" method="post">
					<div class="field">
						<input name="Email" type="text" placeholder="Email Address" required>
					</div>
					<div class="field">
						<input name="Pass" type="password" placeholder="Password" required>
					</div>
					<div class="pass-link">
						<a href="#">Forgot password?</a>
					</div>
					<div class="alert"
			style=" display: ${style==null?'none':style};  background-color:${backgroundErro}; width: 280px; margin-left: 15px ">
			<span class="closebtn"
				onclick="this.parentElement.style.display='none';">&times;</span>
			${content}
		</div>
					<div class="field btn">
						<div class="btn-layer"></div>
						<input formaction="/Vietnqph11698_Ass_V1/Login/LoginPage" type="submit" value="Login">
					</div>
					<div class="signup-link">
						Not a member? <a href="">Signup now</a>
					</div>
				</form>
				<form action="#" class="signup">
				<div class="field">
						<label for="exampleFormControlFile1">Image</label> <input 
							type="file" class="form-control-file"
							id="exampleFormControlFile1">
							<p></p>
					</div>
				<div class="field">
						<input type="text" placeholder="Name" required>
					</div>
					<div class="field">
						<input type="text" placeholder="Birthday" required>
					</div>
					<div class="field">
						<input type="text" placeholder="Address" required>
					</div>
					<div class="field">
						<input type="text" placeholder="Phone Number" required>
					</div>
					<div class="field">
						<input type="text" placeholder="Note" required>
					</div>
					<hr style="border: 1px solid #a445b2;">
					<div  class="field">
						<input type="text" placeholder="Email Address" required>
					</div>
					<div class="field">
						<input type="password" placeholder="Password" required>
					</div>
					<div class="field">
						<input type="password" placeholder="Confirm password" required>
					</div>
					<div class="field btn">
						<div class="btn-layer"></div>
						<input type="submit" value="Signup">
					</div>
				</form>
			</div>
		</div>
	</div>
	<script>
      const loginText = document.querySelector(".title-text .login");
      const loginForm = document.querySelector("form.login");
      const loginBtn = document.querySelector("label.login");
      const signupBtn = document.querySelector("label.signup");
      const signupLink = document.querySelector("form .signup-link a");
      signupBtn.onclick = (()=>{
        loginForm.style.marginLeft = "-50%";
        loginText.style.marginLeft = "-50%";
      });
      loginBtn.onclick = (()=>{
        loginForm.style.marginLeft = "0%";
        loginText.style.marginLeft = "0%";
      });
      signupLink.onclick = (()=>{
        signupBtn.click();
        return false;
      });
    </script>

</body>
</html>
