const id = document.getElementById("id");
const password = document.getElementById("password");
const confirmPassword = document.getElementById("confirmPassword");
const named = document.getElementById("name");
const email = document.getElementById("email");
const submitButton = document.getElementById('submit');
const inputs = [id, password, confirmPassword, named, email];
const errordup = document.getElementById("errordup");
const errorid = document.getElementById("errorid");
const errorpassword = document.getElementById("errorpassword");
const errorconfirmPassword = document.getElementById("errorconfirmPassword");
const errorname = document.getElementById("errorname");
const erroremail = document.getElementById("erroremail");
const errors = [errordup, errorid, errorpassword, errorconfirmPassword, errorname, erroremail];

let flag = true;


inputs.forEach(e => {
	e.addEventListener("blur", check);
});



async function check(e) {
	let names = e.target.name;
	if (names == "id") {
		const username = e.target.value;
		fetch(`/DungsMall/IdCheckServlet?username=${username}`)
			.then(response => response.json())
			.then(data => {
				console.log(data.isTaken);
				if (data.isTaken) {
					errordup.innerText = '다른 아이디를 사용해주세요';

					//messageDiv.style.color = 'red';
				} else {
					errordup.innerText = '';
					//messageDiv.style.color = 'green';
				}
			})
			.catch(error => {
				console.error('Error:', error);
			});
		checkEng(e.target);
	}
	if (names == "password") {
		checkEng2(e.target);
		checkConfirm(e.target);
	}
	if (names == "confirmPassword") {
		checkConfirm(e.target);
	}
	if (names == "email") {
		checkEmail(e.target);
	}
	for (let i = 0; i < errors.length; i++) {
		if (!errors[i].textContent.trim() == '') {
			flag = true;
			break;
		}
		flag = false;
	};
	if (!flag) {
		for (let i = 0; i < inputs.length; i++) {
			let inputValue = inputs[i].value;
			if (inputValue.trim() === '') {
				flag = true;
				break;
			}
			flag = false;
		}
	}
	if (!flag) {
		submitButton.disabled = false;
	} else {
		submitButton.disabled = true;
	}
}
function checkdup() {
	return new Promise((resolve, reject) => {
		fetch(`/DungsMall/IdCheckServlet?username=${username}`)
			.then(response => response.json())
			.then(data => {
				console.log(data.isTaken);
				if (data.isTaken) {
					errordup.innerText = '';

					//messageDiv.style.color = 'red';
				} else {
					errordup.innerText = '다른 아이디를 사용해주세요';
					//messageDiv.style.color = 'green';
				}
			})
			.catch(error => {
				console.error('Error:', error);
			});
	})
}

function checkEmpty(e) {
	inputs.forEach(input => {
		if (input.value.trim() === '') {
			flag = false;
		}
	});
}

function checkEng(input) {
	let text = input.value;
	if (!/^[a-zA-Z]+$/.test(text)) {
		errorid.innerText = "아이디는 영어만 가능합니다.";
	} else {
		errorid.innerText = "";
	}
}

function checkEng2(input) {
	let text = input.value;
	if (!/^[a-zA-Z]+$/.test(text)) {
		errorpassword.innerText = "비밀번호는 영어만 가능합니다.";
	} else {
		errorpassword.innerText = "";
	}
}

function checkConfirm(e) {
	let pw = password.value;
	let conf = confirmPassword.value;
	if (pw !== conf) {
		errorconfirmPassword.innerText = "비밀번호를 확인해주세요";
	} else {
		errorconfirmPassword.innerText = "";
	}
};

function checkEmail() {
	let emailValue = email.value;
	let regex = new RegExp("[a-z0-9]+@[a-z]+.[a-z]{2,3}");
	if (!regex.test(emailValue)) {
		erroremail.innerText = "이메일을 형식을 확인해주세요";
	} else {
		erroremail.innerText = "";
	}
};
