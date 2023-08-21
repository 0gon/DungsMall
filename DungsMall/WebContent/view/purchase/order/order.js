   // 페이지 로딩 시 실행되는 함수
   window.onload = function() {
      // 테이블의 각 행을 읽어와서 총 가격 계산
      calculateTotal();
   };

   // 총 가격 계산 및 업데이트 함수
   function calculateTotal() {
      var rows = document.querySelectorAll('.shoping__cart__table tbody tr');
      var total = 0;

      for (var i = 0; i < rows.length; i++) {
         var price = parseFloat(rows[i].querySelector('.shoping__cart__price').textContent);
         var count = parseInt(rows[i].querySelector('.shoping__cart__quantity').textContent);
         total += price * count;
      }

      // 총 가격을 totalcost 요소에 업데이트
      var totalCostElement = document.getElementById('totalcost');
      totalCostElement.innerHTML = `${total}<span>원</span>`;
   }