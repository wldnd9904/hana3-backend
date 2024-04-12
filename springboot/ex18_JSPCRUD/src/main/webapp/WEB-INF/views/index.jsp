<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>회원목록 조회</title>
</head>
<body>


<h2>회원목록 (총 <span>${ list.size() }</span>명)</h2>
<table class="border border-black p-1">
    <thead>
    <tr>
        <th class="border border-black p-1">ID</th>
        <th class="border border-black p-1">USER_ID</th>
        <th class="border border-black p-1">USER_NAME</th>
        <th class="border border-black p-1">USER_PW</th>
        <th class="border border-black p-1">USER_ROLE</th>
        <th class="border border-black p-1">JOINDATE</th>
        <th class="border border-black p-1">단건조회</th>
        <th class="border border-black p-1">삭제</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="member" items="${ list }" varStatus="status">
        <tr>
            <td class="border border-black p-1">${status.count}</td>
            <td class="border border-black p-1">${member.getUserId()}</td>
            <td class="border border-black p-1">${member.getUserName()}</td>
            <td class="border border-black p-1">${member.getUserPw()}</td>
            <td class="border border-black p-1">${member.getUserRole()}</td>
            <td class="border border-black p-1">${member.getJoinDate()}</td>
            <td class="border border-black p-1">
                <button type="button" onclick="location.href='viewMember?id=${member.id}';"> 단건조회</button>
            </td>
            <td class="border border-black p-1">
                <button type="button" onclick="location.href='deleteDTO?id=${member.id}';"> 삭제</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/joinForm">회원가입</a>
</body>
</html>