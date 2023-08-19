<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>주문/결제</title>
    <link rel="stylesheet" href="view/purchase/order/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="view/purchase/order/style.css" type="text/css" />
<script type="text/javascript" src=view/purchase/order/order.js></script>
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
        <h2>주문/결제</h2>
        <hr />
        <div class="row">
          <div class="col-lg-12">
            <div class="shoping__cart__table">
              <table>
                <thead>
                  <tr>
                    <th class="shoping__product">제품 상세</th>
                    <th>가 격</th>
                    <th>개수(수량)</th>
                    <th>총 가격</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td class="shoping__cart__item">
                      <h5>Vegetable’s Package</h5>
                    </td>
                    <td class="shoping__cart__price">5500원</td>
                    <td class="shoping__cart__quantity">
                      <div class="quantity">
                        <span>0</span>
                      </div>
                    </td>
                    <td id="total1" class="shoping__cart__total">5500원</td>
                    <td></td>
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
          <div class="primary__btns">
            <a href="#" class="primary-btn checkout-btn">결제 하기</a>
          </div>
        </div>
      </div>
    </section>
  </body>
</html>
