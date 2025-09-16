document.getElementById("loginForm").addEventListener("submit", function (e) {
   const empNo = document.getElementById("empNo").value.trim();
   const password = document.getElementById("password").value.trim();

   if(!empNo || !password) {
       e.preventDefault(); // 서버 요청 막기
       alert("사번과 비밀번호를 모두 입력하세요.");
   }
});