<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
   		<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DungsShop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="view/style/header.css">
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
        <div id="carouselExampleIndicators" class="carousel slide " data-bs-ride="true">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                    aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                    aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                    aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner" style="height: 40vw; object-fit: scale-down;">
                <div class="carousel-item active">
                    <img src="images/main-salt.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="images/main-vegetable.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="images/main-waffle.jpg" class="d-block w-100" alt="...">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
            <button type="button" id="goChat" class="btn btn-dark btn-lg"
                onclick="location.href='http://localhost:8080/foodChatBot/chat.html'">DUNG에게 음식 추천 받으러가기</button>
        </div>
    </main>
    <section class="py-5">
        <div class="container px-4 px-lg-5 mt-5">
            <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                
                <c:forEach var="item" items="${itemList}">
                <div class="col mb-5">
                    <div class="card h-100">
                        <img class="card-img-top" src="http://localhost:8080/${item.img}" alt="이미지" />
                        <div class="card-body p-4">
                            <div class="text-center">
                                <h5 class="fw-bolder">${item.name}</h5>
                                <p>${item.descript}</p>
                                ${item.price} 원
                            </div>
                        </div>
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">카트에 담기</a>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
                <!-- 세일되는 메뉴는 이렇게 표시 -->
                <div class="col mb-5">
                    <div class="card h-100">
                        <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale
                        </div>
                        <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                        <div class="card-body p-4">
                            <div class="text-center">
                                <h5 class="fw-bolder">세일될 메뉴</h5>
                                <div class="d-flex justify-content-center small text-warning mb-2">
                                    <div class="bi-star-fill"></div>
                                    <div class="bi-star-fill"></div>
                                    <div class="bi-star-fill"></div>
                                    <div class="bi-star-fill"></div>
                                    <div class="bi-star-fill"></div>
                                </div>
                                <span class="text-muted text-decoration-line-through">4000 ₩</span>
                                2000 ₩
                            </div>
                        </div>
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">옵션 보기</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <footer>

    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
   </body>
</html>