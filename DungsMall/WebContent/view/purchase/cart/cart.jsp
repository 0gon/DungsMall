<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" href="view/purchase/cart/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="view/purchase/cart/style.css" type="text/css">
<script type="text/javascript" src=view/purchase/cart/cart.js></script>

</head>

<body>
	<header>
		<div id="logo">dungs</div>
		<div class="cart">
			<!-- SVG ICON HERE -->
		</div>
		<div class="search-bar">
			<input type="text" placeholder="재료 검색" />
			<button class="search-button">
				<!-- SVG ICON HERE -->
			</button>
		</div>
		<button class="login-button">로그인</button>
	</header>

	<!-- Shoping Cart Section Begin -->
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
                                        <td><input type="checkbox" data-row="1" onchange="toggleCheckbox(this)"></td>
                                        <td class="shoping__cart__item">
                                            <h5>${item.name}</h5>
                                        </td>
                                        <td class="shoping__cart__price">${item.price}원</td>
                                        <td class="shoping__cart__quantity">${item.count}</td>
                                        <td class="shoping__cart__total">${item.price * item.count}원</td>
                                        <td>
                                            <button class="shoping__cart__quantity__delete" onclick="deleteRow(this)">x</button>
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
					<button class="shoping__cart__btns__allselect"
						onclick="allselecttrue()">전체 선택</button>
					<button class="shoping__cart__btns__allselect"
						onclick="allselectfalse()">전체 취소</button>
				</div>
			</div>

			<div class="shoping__checkout">
				<h5>총 결제금액</h5>
				<ul>
					<li>금액에 변동이 없을 시 체크박스를 확인해주세요</li>
					<li>총 결제금액 <span id="totalcost" class="currency-wrapper">0<span>원</span></span></li>
				</ul>
				<div class="primary__btns">
					<a href="/DungsMall/main.do" class="primary-btn cart-btn">쇼핑 계속하기</a> <a
						href="#" class="primary-btn checkout-btn">주문 하기</a>
				</div>
			</div>
		</div>
	</section>
</body>

</html>