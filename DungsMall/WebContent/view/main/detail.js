const login = document.getElementsByClassName("login-button");
const count = document.getElementById("count");
const num = document.getElementById("var-value");
const minus = document.getElementById("btn-minus");
const plus = document.getElementById("btn-plus");
let number = 1;

minus.onclick = () => {
    if (number > 1) {
        number--;
        num.innerText = number;
        count.value = number;
    }
}

plus.onclick = () => {
    number++;
    num.innerText = number;
    count.value = number;
}

function showAlert() {
  alert('상품이 장바구니에 추가되었습니다.');
}