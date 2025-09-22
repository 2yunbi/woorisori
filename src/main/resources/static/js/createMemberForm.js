
let isSignUpCheck = false;

document.addEventListener("DOMContentLoaded", function (){
    const errorMsg = document.getElementById("errorMsg");

    //사번 중복 체크
    const inputEmpNo = document.getElementById("empNo");
    inputEmpNo.addEventListener("blur", function () {
    const empNo = inputEmpNo.value.trim();

    fetch(`/api/checkEmpNo?empNo=${encodeURIComponent(empNo)}`)
        .then(response => response.json())
        .then(data => {
            if (data.exists) {
                errorMsg.style.display = "block";
                errorMsg.innerHTML = '<i class="bi bi-exclamation-diamond"></i> 사번이 중복입니다.';
                inputEmpNo.classList.add("input-error");
                isSignUpCheck = true;
            } else {
                errorMsg.style.display = "none";
                inputEmpNo.classList.remove("input-error");
                isSignUpCheck = false;
            }
        })
        .catch(() => {
            errorMsg.style.display = "block";
            errorMsg.textContent = "오류가 발생했습니다.";
        });

    });

    //비밀번호 체크
    const inputPassword = document.getElementById("password");
    inputPassword.addEventListener("blur", function (){
        const password = document.getElementById("password").value.trim();
        const pwRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*()_+\-={}\[\]:;"'<>,.?/]).{8,}$/;

        if(!pwRegex.test(password)) {
            errorMsg.style.display = "block";
            errorMsg.innerHTML = '<i class="bi bi-exclamation-diamond"></i> 비밀번호는 8자리 이상, 영문/숫자/특수문자를 모두 포함해야 합니다.';
            inputPassword.classList.add("input-error");
            isSignUpCheck = true;
        } else {
            errorMsg.style.display = "none";
            inputPassword.classList.remove("input-error");
            isSignUpCheck = false;
        }
    });

    // 이메일 중복체크 및 null 체크
    const inputEmail = document.getElementById("email");
    inputEmail.addEventListener("blur", function () {
        const email = inputEmail.value.trim();
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        fetch(`/api/checkEmail?email=${encodeURIComponent(email)}`)
            .then(response => response.json())
            .then(data => {
                if (data.exists) {
                    errorMsg.style.display = "block";
                    errorMsg.innerHTML = '<i class="bi bi-exclamation-diamond"></i> 이메일이 중복입니다.';
                    inputEmail.classList.add("input-error");
                    isSignUpCheck = true;
                } else if (!emailRegex.test(email)) {
                    errorMsg.style.display = "block";
                    errorMsg.innerHTML = '<i class="bi bi-exclamation-diamond"></i> 이메일 형식이 올바르지 않습니다.';
                    inputEmail.classList.add("input-error");
                    isSignUpCheck = true;
                } else {
                    errorMsg.style.display = "none";
                    inputEmail.classList.remove("input-error");
                    isSignUpCheck = false;
                }
            })
            .catch(() => {
                errorMsg.textContent = "오류가 발생했습니다.";
                errorMsg.style.display = "block";
            });
    });

});

// 회원가입 빈 값 체크
document.getElementById("signUpForm").addEventListener("submit", function (e) {

    const empNo = document.getElementById("empNo").value.trim();
    const password = document.getElementById("password").value.trim();

    const userName = document.getElementById("userName").value.trim();
    const email = document.getElementById("email").value.trim();
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    // 공란 체크
    if(!empNo) {
        isSignUpCheck = true;
        alert('사번을 입력하세요!');
    } else if (!password) {
        isSignUpCheck = true;
        alert('비밀번호를 입력하세요!');
    } else if (!userName) {
        isSignUpCheck = true;
        alert('이름을 입력하세요!');
    } else if (!email) {
        isSignUpCheck = true;
        alert('이메일 주소를 입력하세요!')
    } else if (!emailRegex.test(email)) {
        isSignUpCheck = true;
        alert('이메일 형식이 올바르지 않습니다!')
    }

    if (isSignUpCheck) {
        e.preventDefault();
    }

});