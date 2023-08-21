<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" href="view/purchase/cart/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="view/purchase/cart/style.css"
	type="text/css">
<script type="text/javascript" src=view/purchase/cart/cart.js></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<link rel="stylesheet" href="view/style/header.css">
</head>

<body>
	<header class="py-3 bg-light">
		<div
			class="row flex-nowrap justify-content-between align-items-center">
			<div class="col-2 pt-1 ms-3">
				<a class="navbar-brand" id="logo" href="/DungsMall/main.do">DUNGS</a>
			</div>
			<div class="col-6 text-center">
				<form class="d-flex" role="search" action="/DungsMall/search.do">
					<input class="form-control me-1 rounded-pill" name="search"
						type="search" autocomplete="off" placeholder="재료 검색">
					<button class="btn btn-sm btn-outline-warning rounded-pill"
						type="submit">
						<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
							fill="none" stroke="currentColor" stroke-linecap="round"
							stroke-linejoin="round" stroke-width="2" class="mx-3" role="img"
							viewBox="0 0 24 24" focusable="false">
							<title>Search</title><circle cx="10.5" cy="10.5" r="7.5"></circle>
							<path d="M21 21l-5.2-5.2"></path></svg>
					</button>
				</form>
			</div>
			<div class="col-3 d-flex justify-content-end align-items-center">
				<c:if test="${empty login}">
					<a class="text-muted me-4" href="/DungsMall/login.do"> <svg
							xmlns="http://www.w3.org/2000/svg" width="24" height="24"
							viewBox="0 0 24 24"
							style="fill: rgba(0, 0, 0, 1); transform: msFilter">
							<path
								d="M21.822 7.431A1 1 0 0 0 21 7H7.333L6.179 4.23A1.994 1.994 0 0 0 4.333 3H2v2h2.333l4.744 11.385A1 1 0 0 0 10 17h8c.417 0 .79-.259.937-.648l3-8a1 1 0 0 0-.115-.921z"></path>
							<circle cx="10.5" cy="19.5" r="1.5"></circle>
							<circle cx="17.5" cy="19.5" r="1.5"></circle></svg>
					</a>
					<a class="text-muted me-4" href="/DungsMall/login.do"> <svg
							xmlns="http://www.w3.org/2000/svg" width="24" height="24"
							viewBox="0 0 24 24"
							style="fill: rgba(0, 0, 0, 1); transform: msFilter">
							<path
								d="M20 12v6a1 1 0 0 1-2 0V4a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v14c0 1.654 1.346 3 3 3h14c1.654 0 3-1.346 3-3v-6h-2zm-6-1v2H6v-2h8zM6 9V7h8v2H6zm8 6v2h-3v-2h3z"></path></svg>
					</a>
					<a class="btn btn-outline-secondary me-5 rounded-pill"
						href="/DungsMall/login.do">login</a>
				</c:if>
				<c:if test="${login eq 'true'}">
					<a class="text-muted me-4" href="/DungsMall/cart.do"> <svg
							xmlns="http://www.w3.org/2000/svg" width="24" height="24"
							viewBox="0 0 24 24"
							style="fill: rgba(0, 0, 0, 1); transform: msFilter">
							<path
								d="M21.822 7.431A1 1 0 0 0 21 7H7.333L6.179 4.23A1.994 1.994 0 0 0 4.333 3H2v2h2.333l4.744 11.385A1 1 0 0 0 10 17h8c.417 0 .79-.259.937-.648l3-8a1 1 0 0 0-.115-.921z"></path>
							<circle cx="10.5" cy="19.5" r="1.5"></circle>
							<circle cx="17.5" cy="19.5" r="1.5"></circle></svg>
					</a>
					<a class="text-muted me-4" href="/DungsMall/receipt.do"> <svg
							xmlns="http://www.w3.org/2000/svg" width="24" height="24"
							viewBox="0 0 24 24"
							style="fill: rgba(0, 0, 0, 1); transform: msFilter">
							<path
								d="M20 12v6a1 1 0 0 1-2 0V4a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v14c0 1.654 1.346 3 3 3h14c1.654 0 3-1.346 3-3v-6h-2zm-6-1v2H6v-2h8zM6 9V7h8v2H6zm8 6v2h-3v-2h3z"></path></svg>
					</a>
					<a class="btn btn-outline-secondary me-5 rounded-pill"
						href="/DungsMall/logout.do">logout</a>
				</c:if>
			</div>
		</div>
	</header>

	<!-- Shoping Cart Section Begin -->
	<form id="orderForm" action="order.do" method="post">
		<section class="shoping-cart spad">

			<div class="container">
				<h2>장바구니</h2>
				<hr>
				<div class="row">
					<div class="col-lg-12">
						<div class="shoping__cart__table">
							<table>
								<thead>
									<tr>
										<th></th>
										<th class="shoping__product">제품 상세</th>
										<th>가 격</th>
										<th>개수(수량)</th>
										<th>총 가격</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${basketList}" var="item">
										<tr>
											<td><input type="checkbox" value="false" data-row="1"
												onchange="toggleCheckbox(this)"></td>
											<td class="shoping__cart__item">
												<h5>${item.name}</h5>
											</td>
											<td class="shoping__cart__price">${item.price}원</td>
											<td class="shoping__cart__quantity">${item.count}</td>
											<td class="shoping__cart__total">${item.price * item.count}원</td>
											<td>
												<button class="shoping__cart__quantity__delete"
													onclick="deleteRow(this, '${item.name}')">x</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>

				<div class="shoping__cart__btns__selects">
					<div class="shoping__cart__btns__select__left">
						<button class="shoping__cart__btns__allselect" type="button"
							id="selectAll">전체 선택</button>
						<button class="shoping__cart__btns__allselect" type="button"
							id="deselectAll">전체 취소</button>

					</div>
				</div>

				<div class="shoping__checkout">
					<h5>총 결제금액</h5>
					<ul>
						<li>금액에 변동이 없을 시 체크박스를 확인해주세요</li>
						<li>총 결제금액 <span id="totalcost" class="currency-wrapper">0<span>원</span></span></li>
					</ul>
					<div class="primary__btns">
						<a href="/DungsMall/main.do" class="primary-btn cart-btn">쇼핑
							계속하기</a>

						<!-- 여기에 테이블과 체크박스 등의 HTML 구조를 작성합니다. -->
						<!-- ... -->
						<!-- 아래에 hidden input 필드를 추가하여 JSON 데이터를 전달할 준비를 합니다. -->
						<input type="hidden" id="postDataInput" name="postData">
						<!-- 주문하기 버튼을 클릭하면 JavaScript 함수를 실행하여 데이터를 전달합니다. -->
						<button type="button" class="primary-btn checkout-btn"
							onclick="placeOrder(event)">주문 하기</button>
					</div>
				</div>
			</div>
		</section>
	</form>
</body>

</html>