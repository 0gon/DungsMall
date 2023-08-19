
const idinput = document.getElementById("id");
// blur 이벤트 리스너 추가
idinput.addEventListener("blur", function(event) {
	const inputValue = event.target.value;
	console.log("Input value changed:", inputValue);
	// 여기에 입력 값이 변경됐을 때 실행하고자 하는 코드를 추가할 수 있습니다.
	
});





var error = true;

document.getElementById("myForm").addEventListener("submit", function(event) {
	let id = document.forms["myForm"]["id"].value;
	let password = document.forms["myForm"]["password"].value;
	let confirmPassword = document.forms["myForm"]["confirmPassword"].value;
	let name = document.forms["myForm"]["name"].value;
	let email = document.forms["myForm"]["email"].value;




	checkIdDupl(id, "id");
	checkEmpty(name, "name");
	checkEng(id, "id");
	checkEng(password, "password");
	ConfirmPassword(password, confirmPassword);
	checkEmail(email);
	if (!error) {
		event.preventDefault(); // 폼 제출 막기
	}
});

var checkEng = function(text, name) {
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

var ConfirmPassword = function(password, confirmPassword) {
	let div = document.getElementById("error_confirmPassword");
	if (password !== confirmPassword) {
		document.forms["myForm"]["confirmPassword"].style.borderColor = "red";
		div.innerText = "비밀번호를 확인해주세요";
		error = false;
	} else {
		document.forms["myForm"]["confirmPassword"].style.borderColor = "#ccc";
		div.innerText = "";
		error = true;
	}
};


var checkEmail = function(email) {
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

var checkEmpty = function(type, name) {
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
