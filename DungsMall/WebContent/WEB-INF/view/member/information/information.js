var error = true;

document.getElementById("myForm").addEventListener("submit", function (event) {
    let id = document.forms["myForm"]["id"].value;
    let password = document.forms["myForm"]["password"].value;
    let password_check = document.forms["myForm"]["password_check"].value;
    let name = document.forms["myForm"]["name"].value;
    let email = document.forms["myForm"]["email"].value;
    
    checkEmpty(name, "name");
    checkEng(id, "id");
    checkEng(password, "password");
    ConfirmPassword(password, password_check);
    checkEmail(email);
    if (!error) {
       event.preventDefault(); // 폼 제출 막기
    }
});

var checkEng = function (text, name) {
   let div = document.getElementById("error-" + name);
   if (!/^[a-zA-Z]+$/.test(text)) {
      document.forms["myForm"][name].style.borderColor = "red";
      div.innerText = "영어를 입력해주세요";
      error = false;
   } else {
      document.forms["myForm"][name].style.borderColor = "#ccc";
      div.innerText = "";
      error = true;
   }
};

var ConfirmPassword = function (password, password_check) {
   let div = document.getElementById("error_password_check");
   if (password !== password_check) {
      document.forms["myForm"]["password_check"].style.borderColor = "red";
      div.innerText = "비밀번호를 확인해주세요";
      error = false;
   } else {
      document.forms["myForm"]["password_check"].style.borderColor = "#ccc";
      div.innerText = "";
      error = true;
   }
};

var checkEmail = function (email) {
   let div = document.getElementById("error_email");
   let regex = new RegExp("[a-z0-9]+@[a-z]+.[a-z]{2,3}");
   if (!regex.test(email)) {
      document.forms["myForm"]["email"].style.borderColor = "red";
      div.innerText = "이메일을 확인해주세요";
      error = false;
   } else {
      document.forms["myForm"]["email"].style.borderColor = "#ccc";
      div.innerText = "";
      error = true;
   }
};

var checkEmpty = function (type, name) {
   let div = document.getElementById("error_" + name);
   if (type == "") {
      document.forms["myForm"]["name"].style.borderColor = "red";
      div.innerText = "필수입력칸입니다";
      error = false;
   } else {
      document.forms["myForm"]["name"].style.borderColor = "#ccc";
      div.innerText = "";
      error = true;
   }
};
