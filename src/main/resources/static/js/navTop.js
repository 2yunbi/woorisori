function confirmLogout() {
    if(confirm("로그아웃 하시겠습니까?")) {
        document.getElementById("logoutForm").submit();
    }
}