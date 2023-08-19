<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>DungsMall</title>
<link rel="stylesheet" href="view/member/login/login.css" />
</head>
<body>
	<div class="container">
		<!-- Heading -->
		<h1>DungsMall</h1>

		<!-- Form -->
		<div class="form-div">
			<form method="post">
				<!-- email input -->
				<div class="input__block">
					<input type="text" placeholder="Id" class="input" id="id" name="id" />
				</div>
				<!-- password input -->
				<div class="input__block">
					<input type="password" placeholder="Password" class="input"
						id="password" name="password" />
				</div>
				<div>
					<input type="submit" class="signin__btn" id="signinBtn" value="로그인"></input>
				</div>
			</form>
		</div>
		<!-- sign in button -->
		<!-- google button -->
		<button class="google__btn" id="google__btn">
			<i class="fa fa-google"></i> 회원가입
		</button>
		<!-- google button -->
		<button class="github__btn">
			<i class="fa fa-github"></i> 임시버튼
		</button>
	</div>

	<footer>
		<p>
			Thank you for watching <i class="fa fa-heart"></i> <i
				class="fa fa-heart"></i> <i class="fa fa-heart"></i>
		</p>
		<p>
			Chouaib Blgn : <a href="https://www.facebook.com/chouaib45"> <i
				class="fa fa-facebook"></i>
			</a> <a href="http://twitter.com/chouaibblgn45"> <i
				class="fa fa-twitter"></i>
			</a> <a href="http://instagram.com/chouaib_blgn"> <i
				class="fa fa-instagram"></i>
			</a> <a href="http://linkedin.com/in/chouaibblgn/"> <i
				class="fa fa-linkedin"></i>
			</a> <a href="https://www.behance.net/geek30"> <i
				class="fa fa-behance"></i>
			</a>
		</p>
	</footer>
</body>
<script src="view/member/login/login.js"></script>
</html>
