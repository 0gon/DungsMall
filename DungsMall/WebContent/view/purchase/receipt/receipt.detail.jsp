<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>영수증 상세 내역</title>
    <link rel="stylesheet" href="view/purchase/receipt/bootstrap.min.css" type="text/css" />
    <link rel="stylesheet" href="view/purchase/receipt/receipt.detail.css" type="text/css" />
    <script></script>
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
        <h2>영수증 상세 내역</h2>
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
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td class="shoping__detail__item">
                      <h5>Vegetable’s Package</h5>
                    </td>

                    <td class="shoping__detail__date">
                      <span>0000.00</span>
                    </td>

                    <td class="shoping__detail__quantity">
                      <div class="quantity">
                        <span>0</span>
                      </div>
                    </td>

                    <td id="total1" class="shoping__item__total">원</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>

        <div class="shoping__cart__btns__selects"></div>

        <div class="shoping__checkout">
          <h5>총 결제금액</h5>
          <ul>
            <li>
              총 결제금액
              <span id="totalcost" class="currency-wrapper"
                >0<span>원</span></span
              >
            </li>
          </ul>
        </div>
      </div>
    </section>
  </body>
</html>
