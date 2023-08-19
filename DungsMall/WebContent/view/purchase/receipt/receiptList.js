      const viewDetailButtons = document.querySelectorAll(".view-detail-btn");

      viewDetailButtons.forEach((button) => {
        button.addEventListener("click", () => {
          // Redirect to receipt.detail.html
          window.location.href = "receipt.detail.html";
        });
      });