const signinBtn = document.getElementById('signinBtn');
console.log(signinBtn);
console.log("js잘됨");
signinBtn.addEventListener('click', () => {
	
    const id = document.getElementById('id').value;
    const password = document.getElementById('password').value;
    
    const formData = new FormData();
    formData.append('id', id);
    formData.append('password', password);

    const headers = new Headers();
    headers.append('Content-Type', 'application/x-www-form-urlencoded'); // 원하는 Content-Type으로 변경
    
    
	console.log(id);
	console.log(password);

    fetch('http://localhost:8080/TestProject/test', {
        method: 'POST',
        headers: headers, 
        body: formData
    })
    .then(response => response.text())
    .then(data => {
        console.log('Response:', data);
        // 여기서 필요한 작업 수행
    })
});