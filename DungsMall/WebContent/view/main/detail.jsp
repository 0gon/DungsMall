<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="view/style/header.css">
    <title>Document</title>
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
    <main>
      <section class="bg-light">
        <div class="container pb-5">
          <div class="row">
            <div class="col-lg-5 mt-5">
              <div class="card mb-3">
                <img
                  class="card-img img-fluid"
                  src="/${item.img}"
                  alt="Card image cap"
                  id="product-detail"
                />
              </div>
              <div class="row"></div>
            </div>
            <div class="col-lg-7 mt-5">
              <div class="card">
                <div class="card-body">
                  <h1 class="h2">${item.name}</h1>
                  <p class="h3 py-2">${item.price} 원</p>
                  <p class="py-2">
                    <img
                      src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAAXNSR0IArs4c6QAAAU9JREFUSEu1lUF2gjAQhjNgt6XegN4ET1I5Qp90XV1XX4+gN9GbyA2s3dZk+iaENmgGhhayCfpgvpn8M39Ajbxg5PiqF+Dysd4DqDJOilyamBhw+dzMAXFLgY3B2d305SCByAFV9hkFRVSHyUMxGwzwdXrLogj2fkBpFaIK3Nnb7OslraITgKf31ET6GDiO0hjMu7T4AVSBzJNSmCKqlAIC2N0+M6t0mtidOoz2yMQrmD5X/9Ufho5BIiIHjpPisQHQ582rUrj8R9BffQDyyf1i1wDQjyEg1911I7I/UD2rCYoe7KI/QNiOYttUn9dkC3NJFW1DxwL6dRUs42SxCiXTVgFKsu/ypsE0qPv+OqmeAHBzcjsvnA5BQEDgRpc4fyJ39W1kF7qIOACZm/s4LKDnXfX0001n7cFfbRVkErckkAa95a7STruWdhL33uiAby1Mvhk+xRrDAAAAAElFTkSuQmCC"
                    />
                    <img
                      src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAAXNSR0IArs4c6QAAAU9JREFUSEu1lUF2gjAQhjNgt6XegN4ET1I5Qp90XV1XX4+gN9GbyA2s3dZk+iaENmgGhhayCfpgvpn8M39Ajbxg5PiqF+Dysd4DqDJOilyamBhw+dzMAXFLgY3B2d305SCByAFV9hkFRVSHyUMxGwzwdXrLogj2fkBpFaIK3Nnb7OslraITgKf31ET6GDiO0hjMu7T4AVSBzJNSmCKqlAIC2N0+M6t0mtidOoz2yMQrmD5X/9Ufho5BIiIHjpPisQHQ582rUrj8R9BffQDyyf1i1wDQjyEg1911I7I/UD2rCYoe7KI/QNiOYttUn9dkC3NJFW1DxwL6dRUs42SxCiXTVgFKsu/ypsE0qPv+OqmeAHBzcjsvnA5BQEDgRpc4fyJ39W1kF7qIOACZm/s4LKDnXfX0001n7cFfbRVkErckkAa95a7STruWdhL33uiAby1Mvhk+xRrDAAAAAElFTkSuQmCC"
                    />
                    <img
                      src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAAXNSR0IArs4c6QAAAU9JREFUSEu1lUF2gjAQhjNgt6XegN4ET1I5Qp90XV1XX4+gN9GbyA2s3dZk+iaENmgGhhayCfpgvpn8M39Ajbxg5PiqF+Dysd4DqDJOilyamBhw+dzMAXFLgY3B2d305SCByAFV9hkFRVSHyUMxGwzwdXrLogj2fkBpFaIK3Nnb7OslraITgKf31ET6GDiO0hjMu7T4AVSBzJNSmCKqlAIC2N0+M6t0mtidOoz2yMQrmD5X/9Ufho5BIiIHjpPisQHQ582rUrj8R9BffQDyyf1i1wDQjyEg1911I7I/UD2rCYoe7KI/QNiOYttUn9dkC3NJFW1DxwL6dRUs42SxCiXTVgFKsu/ypsE0qPv+OqmeAHBzcjsvnA5BQEDgRpc4fyJ39W1kF7qIOACZm/s4LKDnXfX0001n7cFfbRVkErckkAa95a7STruWdhL33uiAby1Mvhk+xRrDAAAAAElFTkSuQmCC"
                    />
                    <img
                      src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAAXNSR0IArs4c6QAAAU9JREFUSEu1lUF2gjAQhjNgt6XegN4ET1I5Qp90XV1XX4+gN9GbyA2s3dZk+iaENmgGhhayCfpgvpn8M39Ajbxg5PiqF+Dysd4DqDJOilyamBhw+dzMAXFLgY3B2d305SCByAFV9hkFRVSHyUMxGwzwdXrLogj2fkBpFaIK3Nnb7OslraITgKf31ET6GDiO0hjMu7T4AVSBzJNSmCKqlAIC2N0+M6t0mtidOoz2yMQrmD5X/9Ufho5BIiIHjpPisQHQ582rUrj8R9BffQDyyf1i1wDQjyEg1911I7I/UD2rCYoe7KI/QNiOYttUn9dkC3NJFW1DxwL6dRUs42SxCiXTVgFKsu/ypsE0qPv+OqmeAHBzcjsvnA5BQEDgRpc4fyJ39W1kF7qIOACZm/s4LKDnXfX0001n7cFfbRVkErckkAa95a7STruWdhL33uiAby1Mvhk+xRrDAAAAAElFTkSuQmCC"
                    />
                    <img
                      src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAAXNSR0IArs4c6QAAAU9JREFUSEu1lUF2gjAQhjNgt6XegN4ET1I5Qp90XV1XX4+gN9GbyA2s3dZk+iaENmgGhhayCfpgvpn8M39Ajbxg5PiqF+Dysd4DqDJOilyamBhw+dzMAXFLgY3B2d305SCByAFV9hkFRVSHyUMxGwzwdXrLogj2fkBpFaIK3Nnb7OslraITgKf31ET6GDiO0hjMu7T4AVSBzJNSmCKqlAIC2N0+M6t0mtidOoz2yMQrmD5X/9Ufho5BIiIHjpPisQHQ582rUrj8R9BffQDyyf1i1wDQjyEg1911I7I/UD2rCYoe7KI/QNiOYttUn9dkC3NJFW1DxwL6dRUs42SxCiXTVgFKsu/ypsE0qPv+OqmeAHBzcjsvnA5BQEDgRpc4fyJ39W1kF7qIOACZm/s4LKDnXfX0001n7cFfbRVkErckkAa95a7STruWdhL33uiAby1Mvhk+xRrDAAAAAElFTkSuQmCC"
                    />
                    <span class="list-inline-item text-dark"
                      >별점 5점 | 바로 배송</span
                    >
                  </p>
                  <ul class="list-inline">
                    <li class="list-inline-item">
                      <h6>판매자:</h6>
                    </li>
                    <li class="list-inline-item">
                      <p class="text-muted"><strong>DUNGS</strong></p>
                    </li>
                  </ul>

                  <h6>판매단위:</h6>
                  <p class="text-muted">한 ${item.unit}씩</p>
                  <p class="text-muted">${item.weight}g</p>
                  <ul class="list-inline">
                    <li class="list-inline-item">
                      <h6>원산지 :</h6>
                    </li>
                    <li class="list-inline-item">
                      <p class="text-muted"><strong>${item.origin}</strong></p>
                    </li>
                  </ul>

                  <h6>설명:</h6>
                  <ul class="list-unstyled pb-3">
                    <li>${item.descript} ${item.name}</li>
                    <li>받자마자 냉장 보관하세요.</li>
                    <li>23시 전 주문 시 내일 아침 7시 전 도착</li>
                    <li>(대구, 부산, 울산 배송 운영시간 별도 확인)</li>
                  </ul>

                  <form method="POST">
                    <input
                      type="hidden"
                      name="name"
                      id="name"
                      value="${item.name}"
                    />
                    <input
                      type="hidden"
                      name="count"
                      id="count"
                      value="1"
                    />
                    <input
                      type="hidden"
                      name="price"
                      id="price"
                      value="${item.price}"
                    />
                    <div class="row">
                      <div class="col-auto">
                        <ul class="list-inline pb-3">
                          <li class="list-inline-item text-right">
                            개수
                          </li>
                          <li class="list-inline-item">
                            <span class="btn btn-warning" id="btn-minus"
                              >-</span
                            >
                          </li>
                          <li class="list-inline-item">
                            <span class="badge bg-secondary" id="var-value"
                              >1</span
                            >
                          </li>
                          <li class="list-inline-item">
                            <span class="btn btn-warning" id="btn-plus">+</span>
                          </li>
                        </ul>
                      </div>
                    </div>
                    <div class="row pb-3">
                      <div class="col d-grid">
                        <button
                          type="submit"
                          class="btn btn-warning btn-lg"
                          name="submit"
                          value="buy"
                          formaction="/DungsMall/detail.do"
                        >
                          구매
                        </button>
                      </div>
                      <div class="col d-grid">
                        <button
                          type="submit"
                          class="btn btn-warning btn-lg"
                          name="submit"
                          value="addtocart"
                          formaction="/DungsMall/detail.do"
                        >
                          장바구니
                        </button>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </main>
    <script src="view/main/detail.js"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>