<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>${languagePack.get('자판기')}</title>

    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div
        class="flex flex-col bg-red-700 p-2 gap-2 text-white font-bold"
>
    <!-- 상단부 -->
    <h1 class="bg-white text-center rounded-t-lg text-red-700">
        ${languagePack.get('★자판기 프로그램★')}
    </h1>
    <div class="flex flex-row vertical-align-center">
        <h1 class="bg-white text-center rounded-r-lg text-red-700 w-1/3">
            ${languagePack.get('▽ 자판기 상품 목록')}
        </h1>
        <div class="flex w-7/12 flex-row justify-center items-center">
            한글
            <a href="${languagePack.get('lang').equals('eng')? '/kor':'/eng'}"
               class="border border-white border-2 rounded-full w-8 h-4 box-content ${languagePack.get('lang').equals('eng') ? 'text-right':'text-left'} mx-2"
            >
                <span class="relative -top-1"> ● </span>
            </a>
            ENG
        </div>
        <span
                class="w-1/12 border border-white border-2 rounded-full text-center"
                style="letter-spacing: -0.2rem; text-indent: -0.2rem"
        >
          ----
        </span>
    </div>
    <!-- 중하단부 -->

    <!-- 상품 목록-->
    <div class="bg-white text-center text-black p-1">
        <c:if test="${products.isEmpty()}">
            <h1>${languagePack.get('상품 목록이 비어있습니다.')}</h1>
        </c:if>
        <c:if test="${!products.isEmpty()}">

        </c:if>
        <table class="border border-red-700 w-full">
            <thead>
            <tr>
                <td class="border border-red-700 p-2 text-red-700">${languagePack.get('번호')}</td>
                <td class="border border-red-700 p-2">${languagePack.get('상품명')}</td>
                <td class="border border-red-700 p-2">${languagePack.get('가격')}</td>
                <td class="border border-red-700 p-2">${languagePack.get('유통기한')}</td>
                <td class="border border-red-700 p-2">${languagePack.get('수정')}</td>
                <td class="border border-red-700 p-2">${languagePack.get('삭제')}</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${products}">

                <tr>
                    <td class="border border-red-700 p-2">${products.indexOf(product)+1}</td>
                    <td class="border border-red-700 p-2">${product.getName()}</td>
                    <td class="border border-red-700 p-2">${product.getPrice()}</td>
                    <td class="border border-red-700 p-2">${product.getLimit_date()}</td>
                    <td class="border border-red-700 p-2">
                        <a href="/${languagePack.get('lang')}/edit?index=${ products.indexOf(product) }"
                           class="bg-blue-500 text-white p-2 px-3 rounded-lg">${languagePack.get('수정')}</a>
                    </td>
                    <td class="border border-red-700 p-2">
                        <a href="/${languagePack.get('lang')}/delete?index=${ products.indexOf(product) }"
                           class="bg-red-500 text-white p-2 px-3 rounded-lg">${languagePack.get('삭제')}</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="flex flex-row">
        <div class="w-7/12"></div>
        <h1 class="bg-white text-center w-5/12 rounded-l-lg text-red-700">
            <span> ${languagePack.get('▲ 총 ')}</span>
            <span class="text-black"> ${products.size()}</span>
            <span> ${languagePack.get('개의 상품이 있습니다.')}</span>
        </h1>
    </div>
    <a href="/${languagePack.get('lang')}/new"
       class="bg-red-500 rounded p-1 px-4 w-fit mx-auto">
        ${languagePack.get('상품 추가하기!')}
    </a>
</div>
</body>
</html>
