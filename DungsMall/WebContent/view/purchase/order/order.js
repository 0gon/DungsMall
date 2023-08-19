      function updateTotal(rowNumber) {
        const quantityInput = document.getElementById(`quantity${rowNumber}`);
        const totalCell = document.getElementById(`total${rowNumber}`);
        const priceCell = quantityInput
          .closest("tr")
          .querySelector(".shoping__cart__price");
        const price = parseFloat(
          priceCell.textContent.replace("원", "").replace(",", "")
        ); // '원'과 ',' 제거
        const quantity = parseInt(quantityInput.value);
        const total = price * quantity;
        totalCell.textContent = `${total.toLocaleString()}원`;

        updateTotalCost(); // 여기서 totalcost를 갱신합니다.
      }

      function adjustQuantity(change, rowNumber) {
        const quantityInput = document.getElementById(`quantity${rowNumber}`);
        const currentQuantity = parseInt(quantityInput.value);
        const newQuantity = Math.max(currentQuantity + change, 1); // Avoid negative quantities
        quantityInput.value = newQuantity;
        updateTotal(rowNumber); // Update the total based on the new quantity
      }

      function allselecttrue() {
        const checkboxes = document.querySelectorAll('input[type="checkbox"]');
        checkboxes.forEach((checkbox) => {
          checkbox.checked = true;
        });
        updateTotalCost();
      }

      function allselectfalse() {
        const checkboxes = document.querySelectorAll('input[type="checkbox"]');
        checkboxes.forEach((checkbox) => {
          checkbox.checked = false;
        });
        updateTotalCost();
      }

      function deleteRow(rowButtonElement) {
        const row = rowButtonElement.closest("tr");
        row.parentNode.removeChild(row);
        updateTotalCost(); // 행이 삭제된 후에 totalcost를 갱신합니다.
      }

      function updateTotalCost() {
        let totalCost = 0;
        const checkboxes = document.querySelectorAll('input[type="checkbox"]');
        checkboxes.forEach((checkbox, index) => {
          if (checkbox.checked) {
            const totalCell = document.getElementById(`total${index + 1}`);
            const total = parseFloat(
              totalCell.textContent.replace("원", "").replace(",", "")
            ); // '원'과 ',' 제거
            totalCost += total;
          }
        });
        document.getElementById("totalcost").textContent = `${parseInt(
          totalCost
        )}원`; // 소수점 이하 자리 제거
      }

      function toggleCheckbox(checkboxElement) {
        updateTotal(checkboxElement.dataset.row);
        updateTotalCost();
      }