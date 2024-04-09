<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ex03</title>
</head>
<body>
<%-- 페이지 지시어 <%@ %> --%>
<%-- 출력문(표현식) <%= %> --%>
<%-- 전역변수, 함수 선언부 <%! %> --%>
<%-- 자바 코드 영역 - 스크립트릿 scriptlet--%>
<%!
    int globalVar = 10;

    public int sum(int a, int b) {
        return a + b;
    }
%>
<%
    //스크립트릿 : JSP 안의 Java 코드
    String title = "I'm Java";
    System.out.println(title);
%>
전역변수 : <%= globalVar%> <br/>
타이틀 : <%= title%> <br/>
합계 함수 : <%= sum(10, 20)%><br/>

<a href="/04">ex04</a>
</body>
</html>