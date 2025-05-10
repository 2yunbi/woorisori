document.addEventListener("DOMContentLoaded", function (){
    const empNoInput = document.getElementById("empNo");
    const errorMsg = document.getElementById("errorMsg");

    empNoInput.addEventListener("blur", function () {
    const empNo = empNoInput.value.trim();

    if(!empNo) return;

    fetch(`/api/checkEmpNo?empNo=${encodeURIComponent(empNo)}`)
        .then(response => response.json())
        .then(data => {
            if (data.exists) {
                errorMsg.style.display = "block";
            } else {
                errorMsg.style.display = "none";
            }
        })
        .catch(() => {
            errorMsg.textContent = "오류가 발생했습니다.";
            errorMsg.style.display = "block";
        });
    });
});