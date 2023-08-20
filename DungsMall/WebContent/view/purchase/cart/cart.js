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

    function toggleCheckbox(checkbox) {
         calculateTotalCost();
    }

    function deleteRow(button) {
        const row = button.closest('tr');
        row.remove();
        calculateTotalCost();
    }
