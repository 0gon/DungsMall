<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>주문목록</title>
    <link rel="stylesheet" href="view/style/header.css" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
  </head>
  <body>
      <header class="py-3 bg-light">
	      <div class="row flex-nowrap justify-content-between align-items-center">
	        <div class="col-2 pt-1 ms-3">
	          <a class="navbar-brand" id="logo" href="/DungsMall/main.do">DUNGS</a>
	        </div>
	        <div class="col-6 text-center">
	          <form class="d-flex" role="search" action="/DungsMall/search.do">
	              <input class="form-control me-1 rounded-pill" name="search" type="search" autocomplete="off" placeholder="재료 검색">
	              <button class="btn btn-sm btn-outline-warning rounded-pill" type="submit">
	                  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="mx-3" role="img" viewBox="0 0 24 24" focusable="false"><title>Search</title><circle cx="10.5" cy="10.5" r="7.5"></circle><path d="M21 21l-5.2-5.2"></path></svg>
	              </button>
	          </form>
	        </div>
	        <div class="col-3 d-flex justify-content-end align-items-center">
	            <c:if test="${empty login}">
		            <a class="text-muted me-4" href="/DungsMall/login.do">
			        	<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" style="fill: rgba(0, 0, 0, 1);transform: msFilter"><path d="M21.822 7.431A1 1 0 0 0 21 7H7.333L6.179 4.23A1.994 1.994 0 0 0 4.333 3H2v2h2.333l4.744 11.385A1 1 0 0 0 10 17h8c.417 0 .79-.259.937-.648l3-8a1 1 0 0 0-.115-.921z"></path><circle cx="10.5" cy="19.5" r="1.5"></circle><circle cx="17.5" cy="19.5" r="1.5"></circle></svg>
			        </a>
			        <a class="text-muted me-4" href="/DungsMall/login.do">
			        	<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" style="fill: rgba(0, 0, 0, 1);transform: msFilter"><path d="M20 12v6a1 1 0 0 1-2 0V4a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v14c0 1.654 1.346 3 3 3h14c1.654 0 3-1.346 3-3v-6h-2zm-6-1v2H6v-2h8zM6 9V7h8v2H6zm8 6v2h-3v-2h3z"></path></svg>
			        </a>
	          		<a class="btn btn-outline-secondary me-5 rounded-pill" href="/DungsMall/login.do">login</a>
	        	</c:if>
	        	<c:if test="${login eq 'true'}">
	        		<a class="text-muted me-4" href="/DungsMall/cart.do">
	              		<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" style="fill: rgba(0, 0, 0, 1);transform: msFilter"><path d="M21.822 7.431A1 1 0 0 0 21 7H7.333L6.179 4.23A1.994 1.994 0 0 0 4.333 3H2v2h2.333l4.744 11.385A1 1 0 0 0 10 17h8c.417 0 .79-.259.937-.648l3-8a1 1 0 0 0-.115-.921z"></path><circle cx="10.5" cy="19.5" r="1.5"></circle><circle cx="17.5" cy="19.5" r="1.5"></circle></svg>
		          	</a>
		          	<a class="text-muted me-4" href="/DungsMall/receipt.do">
		              	<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" style="fill: rgba(0, 0, 0, 1);transform: msFilter"><path d="M20 12v6a1 1 0 0 1-2 0V4a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v14c0 1.654 1.346 3 3 3h14c1.654 0 3-1.346 3-3v-6h-2zm-6-1v2H6v-2h8zM6 9V7h8v2H6zm8 6v2h-3v-2h3z"></path></svg>
		          	</a>
	                <a class="btn btn-outline-secondary me-5 rounded-pill" href="/DungsMall/logout.do">logout</a>
	            </c:if>
	        </div>
	      </div>
    	</header>
    <nav>
      <form class="d-flex m-5" role="search">
        <input
          class="form-control me-2"
          type="search"
          placeholder="Search"
          aria-label="Search"
        />
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </nav>
    <c:forEach var="item" items="${list}" varStatus="status">
    <div class="card mx-5 my-3">
      <div class="card-header">${item.date} 주문</div>
      <div class="card-body">
        <h5 class="card-title">총 ${total[status.index]}</h5>
        <c:forEach var="food" items="${item.detail}">
        <div class="card mb-2" style="max-height: 100px">
          <div class="row g-0">
            <div class="col-md-4">
              <img
                src="images/m.png"
                style="height: 90px"
                class="img-fluid rounded-start"
              />
            </div>
            <div class="col-md-8">
              <div class="card-body">
                <h5 class="card-text">신선하고 맛있는 ${food.item}</h5>
                <p class="card-text"> ${food.price}</p>
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
        <a href="#" class="btn btn-warning">후기 남기는 버튼 생성 예정</a>
      </div>
      </div>
    </c:forEach>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
  </body>
</html>