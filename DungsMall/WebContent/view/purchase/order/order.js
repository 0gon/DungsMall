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

function placeOrder(event) {
    // 이 함수는 주문하기 버튼을 눌렀을 때 실행됩니다.

    // 선택한 제품 리스트를 가져옵니다. (예: JSON 형태로 배열에 담음)
    var productList = [];

    var items = document.querySelectorAll('.shoping__cart__item');
    items.forEach(function(item) {
        var productName = item.querySelector('h5').textContent;
        var price = parseInt(item.nextElementSibling.textContent);
        var count = parseInt(item.nextElementSibling.nextElementSibling.textContent);
        var total = parseInt(item.nextElementSibling.nextElementSibling.nextElementSibling.textContent);

        productList.push({
            name: productName,
            price: price,
            count: count,
            total: total
        });
    });

    // productList를 JSON 형식으로 문자열화합니다.
    var postData = JSON.stringify(productList);

    // POST 요청을 보내기 위해 hidden input에 데이터를 할당합니다.
    document.getElementById('postDataInput').value = postData;

    // 폼을 제출합니다.
    document.getElementById('paymentForm').submit();
}