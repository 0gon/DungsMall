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
    const checkboxes = document.querySelectorAll('input[type="checkbox"]');
    let totalCost = 0;

    checkboxes.forEach(checkbox => {
        if (checkbox.checked) {
            const row = checkbox.closest('tr');
            const priceElement = row.querySelector('.shoping__cart__price');
            const quantityElement = row.querySelector('.quantity');
            const totalElement = row.querySelector('.shoping__cart__total');

            const price = parseFloat(priceElement.textContent.replace('원', '').replace(',', ''));
            const quantity = parseInt(quantityElement.textContent) || 0; // Default to 0 if NaN
            const total = price * quantity;

            totalCost += total;

            totalElement.textContent = total.toLocaleString() + '원';
        }
    });

    // Update the total cost
    const totalCostElement = document.getElementById('totalcost');
    totalCostElement.textContent = totalCost.toLocaleString() + '원';
}

    function toggleCheckbox(checkbox) {
        calculateTotalCost();
    }

    function deleteRow(button) {
        const row = button.closest('tr');
        row.remove();
        calculateTotalCost();
    }
