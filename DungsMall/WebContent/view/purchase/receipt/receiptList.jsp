<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>영수증 상세 내역</title>
<link rel="stylesheet" href="view/purchase/receipt/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet" href="view/purchase/receipt/receiptList.css"
	type="text/css" />
<script type="text/javascript" src="view/purchase/receipt/receipt.js"></script>
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

	<section class="shoping__receipt__detail">
		<div class="container">
			<h2>영수증 목록</h2>
			<hr />
			<div class="row">
				<div class="col-lg-12">
					<div class="shoping__receipt__table">
						<table>
							<thead>
								<tr>
									<th class="shoping__product">상품 이름</th>
									<th>날 짜</th>
									<th>개수(수량)</th>
									<th>총 가격</th>
									<th></th>
									<!-- Empty header cell for the button -->
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="shoping__detail__item">
										<h5>Vegetable’s Package 외 몇개</h5>
									</td>
									<td class="shoping__detail__date"><span>0000.00</span></td>
									<td class="shoping__detail__quantity">
										<div class="quantity">
											<span>0</span>
										</div>
									</td>
									<td id="total1" class="shoping__item__total">원</td>
									<td>
										<button class="view-detail-btn">상세 보기</button>
									</td>
								</tr>
								<!-- Add more rows if needed -->
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
