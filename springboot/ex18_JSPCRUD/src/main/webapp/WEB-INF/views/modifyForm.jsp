<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="moifyAction" method="post" onsubmit="return checkForm();" style="display:flex; flex-direction:column;">
    <label>
        아이디
        <input type="text" name="userId" id="userId" value="${member.getId()}" maxlength="20" required/>
    </label>
    <label>
        비밀번호
        <input type="password" name="userPw" id="userPw" value="${member.getUserPw()}" maxlength="20" required/>
    </label>
    <label>
        이름
        <input type="text" name="userName" id="userName" value="${member.getUserName()}" maxlength="50"/>
    </label>
    <label>
        가입일자
        <input type="date" name="joinDate" id="joinDate" value="${member.getJoinDate()}" maxlength="50"/>
    </label>
    <label>
        주소
        <input type="text" name="userAddress" id="userAddress" maxlength="100"/>
    </label>
    <label>
        권한
        <select name="userRole" value="${member.getUserRole()}" required>
            <option value="ROLE_USER"
                    <c:if test="${member.getUserRole() eq 'ROLE_USER'}">selected</c:if>
            >일반회원
            </option>
            <option value="ROLE_ADMIN"
                    <c:if test="${member.getUserRole() eq 'ROLE_ADMIN'}">selected</c:if>
            >관리자
            </option>
        </select>
    </label>
    <a type="button" href="/">취소</a>
    <button type="submit">회원가입</button>

</form>
<script>
    const checkForm = () => {
        const userId = document.getElementById("userId").value;
        const userPw = document.getElementById("userPw").value;
        const userName = document.getElementById("userName").value;
        const joinDate = document.getElementById("joinDate").value;
        const userAddress = document.getElementById("userAddress").checked;
        for (const [input, label] of [[userId, "아이디를"], [userName, "이름을"], [userPw, "비밀번호를"], [joinDate, "가입일을"], [userAddress, "주소를"],]) {
            if (input === "") {
                alert(`${label} 입력해 주세요.`);
                return false;
            }
        }
        return true;
    }
</script>
</body>
</html>