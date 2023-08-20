<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>영수증 상세 내역</title>
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
            <a class="text-muted me-4" href="/DungsMall/cart.do">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" style="fill: rgba(0, 0, 0, 1);transform: msFilter"><path d="M21.822 7.431A1 1 0 0 0 21 7H7.333L6.179 4.23A1.994 1.994 0 0 0 4.333 3H2v2h2.333l4.744 11.385A1 1 0 0 0 10 17h8c.417 0 .79-.259.937-.648l3-8a1 1 0 0 0-.115-.921z"></path><circle cx="10.5" cy="19.5" r="1.5"></circle><circle cx="17.5" cy="19.5" r="1.5"></circle></svg>
            </a>
            <a class="text-muted me-4" href="/DungsMall/receipt.do">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" style="fill: rgba(0, 0, 0, 1);transform: msFilter"><path d="M20 12v6a1 1 0 0 1-2 0V4a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v14c0 1.654 1.346 3 3 3h14c1.654 0 3-1.346 3-3v-6h-2zm-6-1v2H6v-2h8zM6 9V7h8v2H6zm8 6v2h-3v-2h3z"></path></svg>
            </a>
            <a class="btn btn-outline-secondary me-5 rounded-pill" href="/DungsMall/logout.do">logout</a>
          </div>
        </div>
      </header>
      <section class="mx-5">
      <div class="mt-5">
        <h2>영수증 목록</h2>
      </div>
      <hr/>
      <table class="table table-bordered table-hover text-center">
        <thead>
          <tr class="table-warning">
            <th scope="col">상품이름</th>
            <th scope="col">날짜</th>
            <th scope="col">개수(수량)</th>
            <th scope="col">총 가격</th>
          </tr>
        </thead>
        <tbody class="table-group-divider">
          <tr onClick="location.href='#'">
            <th scope="row">고기</th>
            <td>2023-08-20</td>
            <td>3개</td>
            <td>25000원</td>
          </tr>
          <tr>
            <th scope="row">고기</th>
            <td>2023-08-20</td>
            <td>3개</td>
            <td>25000원</td>
          </tr>
          <tr>
            <th scope="row">고기</th>
            <td>2023-08-20</td>
            <td>3개</td>
            <td>25000원</td>
          </tr>
        </tbody>
      </table>
      <div class="me-4" style="float: right; text-align: right;">
        <h5>총 결제금액</h5>
        <p>총
        <span style="font-size: 1.2em;">100000원</span>
        </p>
      </div>
    </section>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
</body>
</html>
