<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>DungsMall</title>
      <link rel="stylesheet" href="view/member/join/join.css" />
   </head>
   <body>
      <div class="container">
         <!-- Heading -->
         <h1>DungsMall</h1>

         <!-- Form -->
         <form id="myForm" method="get">
            <div class="input__block">
               <input
                  type="text"
                  placeholder="아이디를 입력해주세요"
                  class="input"
                  id="id"
                  name="id"
               />
            </div>
            <div id="error-id" class="error-block"></div>
            <div class="input__block">
               <input
                  type="password"
                  placeholder="비밀번호를 입력해주세요"
                  class="input"
                  id="password"
                  name="password"
               />
            </div>
            <div id="error-password" class="error-block"></div>
            <div class="input__block">
               <input
                  type="password"
                  placeholder="비밀번호를 확인해주세요"
                  class="input"
                  id="password_check"
                  name="password_check"
               />
            </div>
            <div id="error_password_check" class="error-block"></div>
            <div class="input__block">
               <input
                  type="text"
                  placeholder="이름을 입력해주세요"
                  class="input"
                  id="name"
                  name="name"
               />
            </div>
            <div id="error_name" class="error-block"></div>
            <div class="input__block">
               <input
                  type="text"
                  placeholder="이메일을 입력해주세요"
                  class="input"
                  id="email"
                  name="email"
               />
            </div>
            <div id="error_email" class="error-block"></div>
            <div>
               <input class="first__btn" type="submit" value="완료" />
            </div>
         </form>
      </div>

      <footer>
         <p>
            Thank you for watching
            <i class="fa fa-heart"></i>
            <i class="fa fa-heart"></i>
            <i class="fa fa-heart"></i>
         </p>
         <p>aaa</p>
      </footer>
   </body>
   <script src="view/member/join/join.js"></script>
</html>
