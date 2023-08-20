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

    function calculateTotalCost() {
        var totalCost = 0;
        var checkboxes = document.querySelectorAll('input[type="checkbox"][data-row]:checked');
        
        checkboxes.forEach(function(checkbox) {
            var row = checkbox.closest('tr');
            var price = parseInt(row.querySelector('.shoping__cart__price').textContent);
            var count = parseInt(row.querySelector('.shoping__cart__quantity').textContent);
            totalCost += price * count;
        });
        
        document.getElementById('totalcost').textContent = totalCost + '원';
    }
function updateTotalCost() {
    var total = 0;
    var rows = document.querySelectorAll(".shoping__cart__table tbody tr");

    rows.forEach(function(row) {
        var price = parseInt(row.querySelector(".shoping__cart__price").textContent);
        var quantity = parseInt(row.querySelector(".shoping__cart__quantity").textContent);
        var rowTotal = price * quantity;
        total += rowTotal;
    });

    var totalCostElement = document.getElementById("totalcost");
    totalCostElement.textContent = total.toLocaleString() + "원";
}
updateTotalCost();

    function toggleCheckbox(checkbox) {
         calculateTotalCost();
		updateTotalCost();
    }

    function deleteRow(button) {
            var row = button.parentNode.parentNode;
    row.parentNode.removeChild(row);
    updateTotalCost();
    }



