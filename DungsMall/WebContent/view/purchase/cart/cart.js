function allselecttrue() {
    const checkboxes = document.querySelectorAll('input[type="checkbox"]');
    checkboxes.forEach(checkbox => {
        checkbox.checked = true;
    });
    calculateTotalCost();
}

function allselectfalse() {
    const checkboxes = document.querySelectorAll('input[type="checkbox"]');
    checkboxes.forEach(checkbox => {
        checkbox.checked = false;
    });
    calculateTotalCost();
}

window.addEventListener('load', function() {
    document.getElementById('selectAll').addEventListener('click', function(event) {
        event.preventDefault(); // 페이지 이동 막기
        allselecttrue(); // 기존 함수 호출
    });

    document.getElementById('deselectAll').addEventListener('click', function(event) {
        event.preventDefault(); // 페이지 이동 막기
        allselectfalse(); // 기존 함수 호출
    });
});

function toggleCheckbox(checkbox) {
    checkbox.checked = !checkbox.checked; // Toggle the checked state
    calculateTotalCost(); // Update total cost when checkbox state changes
}

document.addEventListener('change', function(event) {
    if (event.target && event.target.matches('input[type="checkbox"][data-row]')) {
        toggleCheckbox(event.target);
    }
});


function calculateTotalCost() {
        var totalCost = 0;
        var checkboxes = document.querySelectorAll('input[type="checkbox"][data-row]:checked');
        
        checkboxes.forEach(function(checkbox) {
            var row = checkbox.closest('tr');
            var price = parseInt(row.querySelector('.shoping__cart__price').textContent);
            var count = parseInt(row.querySelector('.shoping__cart__quantity').textContent);
            totalCost += price * count;
        });
        
var totalCostElement = document.getElementById('totalcost');
    totalCostElement.textContent = totalCost + '원';
        document.getElementById('totalcost').textContent = totalCost + '원';
    }


function deleteRow(button, itemName) {
    // AJAX 요청으로 아이템 이름을 서버로 보냄
    fetch('/DungsMall/cart.do', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: `itemName=${encodeURIComponent(itemName)}`,
    })
    .then(response => {
        // 응답 처리
        if (response.ok) {
            // 행 삭제
            const row = button.closest('tr');
            row.remove();
        } else {
            console.error('Error deleting item');
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
	   // Find the parent row and remove it from the table
    var row = button.parentNode.parentNode;
    row.parentNode.removeChild(row);

    // Update the total cost by subtracting the deleted item's cost from the current total
    var itemPrice = parseInt(row.querySelector(".shoping__cart__price").textContent);
    var itemCount = parseInt(row.querySelector(".shoping__cart__quantity").textContent);
    var itemTotal = itemPrice * itemCount;

    var totalCostElement = document.getElementById("totalcost");
    var currentTotal = parseInt(totalCostElement.textContent);
    
    // Ensure the total cost doesn't go below 0
    var newTotal = Math.max(currentTotal - itemTotal, 0);
    
    totalCostElement.textContent = newTotal + "원";
	
}

function placeOrder(event) {
    event.preventDefault(); // 폼 제출 기본 동작 막기

    var selectedItems = [];
    var checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');

    if (checkboxes.length === 0) {
        alert("주문할 상품을 선택해주세요.");
        return; // 상품 선택이 없을 때 함수 중단
    }

    checkboxes.forEach(function (checkbox) {
        var row = checkbox.closest('tr');
        var itemName = row.querySelector('.shoping__cart__item h5').textContent;
        var itemPrice = parseFloat(row.querySelector('.shoping__cart__price').textContent);
        var itemCount = parseInt(row.querySelector('.shoping__cart__quantity').textContent);

        selectedItems.push({
            name: itemName,
            price: itemPrice,
            count: itemCount
        });
    });
    
    var postData = JSON.stringify(selectedItems);
    document.getElementById('postDataInput').value = postData;

    // 폼을 수동으로 제출합니다.
    document.getElementById('orderForm').submit();
}