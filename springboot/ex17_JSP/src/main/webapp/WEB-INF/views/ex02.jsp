<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ex02</title>
</head>
<body>
현재시간: <%= new java.util.Date() %>
<br>
<button onclick="window.location.reload();">새로고침</button>

<a href="/03">ex03</a>
</body>
</html>