<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    	<header>
        <div id="logo">dungs</div>
        <div class="cart">
            <svg xmlns="http://www.w3.org/2000/svg" width="25" height="20" viewBox="0 0 38 31" fill="none">
                <path
                    d="M2.02559 0.0102449C1.39559 0.11737 0.831427 0.486078 0.457223 1.03526C0.0830191 1.58444 -0.0705772 2.2691 0.0302236 2.93863C0.131024 3.60816 0.477965 4.20772 0.994723 4.6054C1.51148 5.00308 2.15573 5.16631 2.78573 5.05919H9.91204L10.3396 6.32142L12.2875 12.6326L14.2353 18.9438C14.4254 19.6001 15.233 20.206 15.8506 20.206H32.4787C33.1438 20.206 33.904 19.6001 34.094 18.9438L37.9422 6.32142C38.1322 5.66506 37.8472 5.05919 37.1821 5.05919H16.0882L14.2828 1.42395C14.0906 1.0067 13.7937 0.653937 13.4248 0.404504C13.056 0.155071 12.6296 0.0186439 12.1925 0.0102449L2.69071 0.0102449C2.54848 -0.00341496 2.40537 -0.00341497 2.26313 0.0102449C2.1682 0.0041807 2.07301 0.0041807 1.97808 0.0102449L2.02559 0.0102449ZM17.0384 25.255C15.7081 25.255 14.6629 26.3657 14.6629 27.7794C14.6629 29.1931 15.7081 30.3039 17.0384 30.3039C18.3686 30.3039 19.4138 29.1931 19.4138 27.7794C19.4138 26.3657 18.3686 25.255 17.0384 25.255ZM31.291 25.255C29.9607 25.255 28.9155 26.3657 28.9155 27.7794C28.9155 29.1931 29.9607 30.3039 31.291 30.3039C32.6212 30.3039 33.6664 29.1931 33.6664 27.7794C33.6664 26.3657 32.6212 25.255 31.291 25.255Z"
                    fill="black" />
            </svg>
        </div>
        <div class="search-bar">
            <input type="text" placeholder="재료 검색">
            <button class="search-button">
                <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 25 25" fill="none">
                    <path
                        d="M10.8394 0.0309696C4.86223 0.0309696 0 4.8932 0 10.8703C0 16.8475 4.86223 21.7097 10.8394 21.7097C12.6666 21.7097 14.4628 21.2761 15.9803 20.44C16.1019 20.5862 16.2367 20.721 16.3829 20.8426L19.4799 23.9395C19.7659 24.2613 20.1146 24.5212 20.5046 24.7034C20.8947 24.8855 21.3179 24.986 21.7481 24.9986C22.1784 25.0113 22.6068 24.9359 23.0069 24.777C23.407 24.6181 23.7704 24.3792 24.0748 24.0748C24.3792 23.7704 24.6181 23.407 24.777 23.0069C24.9359 22.6068 25.0113 22.1784 24.9986 21.7481C24.986 21.3179 24.8855 20.8947 24.7034 20.5046C24.5212 20.1146 24.2613 19.7659 23.9395 19.4799L20.8426 16.3829C20.6917 16.232 20.5256 16.0971 20.347 15.9803C21.1832 14.4628 21.7097 12.6975 21.7097 10.8394C21.7097 4.86223 16.8475 0 10.8703 0L10.8394 0.0309696ZM10.8394 3.12793C15.1441 3.12793 18.5818 6.56556 18.5818 10.8703C18.5818 12.9143 17.8385 14.8035 16.5378 16.1971C16.5068 16.2281 16.4758 16.2591 16.4449 16.29C16.2986 16.4116 16.1638 16.5463 16.0423 16.6926C14.6796 17.9314 12.8214 18.6437 10.8084 18.6437C6.50362 18.6437 3.06599 15.2061 3.06599 10.9013C3.06599 6.59653 6.50362 3.1589 10.8084 3.1589L10.8394 3.12793Z"
                        fill="black" />
                </svg>
            </button>
        </div>
        <button class="login-button">로그인</button>
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

                  <form action="" method="GET">
                    <input
                      type="hidden"
                      name="name"
                      value="${item.name}"
                    />
                    <input
                      type="hidden"
                      name="name"
                      value="${item.price}"
                    />
                    <div class="row">
                      <div class="col-auto">
                        <ul class="list-inline pb-3">
                          <li class="list-inline-item text-right">
                            개수
                            <input
                              type="hidden"
                              name="quanity"
                              id="quanity"
                              value="1"
                            />
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
                        >
                          구매
                        </button>
                      </div>
                      <div class="col d-grid">
                        <button
                          type="submit"
                          class="btn btn-warning btn-lg"
                          name="submit"
                          value="addtocard"
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
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>