<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/joinAction" method="post" onsubmit="return checkForm();" style="display:flex; flex-direction:column;">
    <label>
        아이디
        <input type="text" name="userId" id="userId" maxlength="20" required/>
    </label>
    <label>
        비밀번호
        <input type="password" name="userPw" id="userPw" maxlength="20" required/>
    </label>
    <label>
        이름
        <input type="text" name="userName" id="userName" maxlength="50"/>
    </label>
    <label>
        가입일자
        <input type="date" name="joinDate" id="joinDate" maxlength="50"/>
    </label>
    <label>
        주소
        <input type="text" name="userAddress" id="userAddress" maxlength="100"/>
    </label>
    <label>
        권한
        <select name="userRole" required>
            <option value="ROLE_USER">일반회원</option>
            <option value="ROLE_ADMIN">관리자</option>
        </select>
    </label>
    <a type="button" href="/">취소</a>
    <button type="submit">회원가입</button>

</form>
<script>
    const checkForm = () => {
        const userId = document.getElementById("userId");
        const userPw = document.getElementById("userPw");
        const userName = document.getElementById("userName");
        const joinDate = document.getElementById("joinDate");
        const userAddress = document.getElementById("userAddress");
        for (const [input, label] of [[userId, "아이디를"], [userName, "이름을"], [userPw, "비밀번호를"], [joinDate, "가입일을"], [userAddress, "주소를"],]) {
            if (input.value === "") {
                alert(`${label} 입력해 주세요.`);
                input.focus();
                return false;
            }
        }
        return true;
    }
</script>
</body>
</html>