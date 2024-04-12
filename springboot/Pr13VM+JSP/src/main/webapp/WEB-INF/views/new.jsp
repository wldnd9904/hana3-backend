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
    <h1 class="text-center text-white">
        ${languagePack.get('자판기 상품 추가')}
    </h1>
    <form class="flex flex-col gap-2"
          action="/${languagePack.get('lang')}/new"
          method="post">
        <label>
            <span>${languagePack.get('상품명')}:</span>
            <input class="w-full rounded p-0.5 text-black" name="name" type="text" required/>
        </label>
        <label>
            <span>${languagePack.get('가격')}:</span>
            <input class="w-full rounded p-0.5 text-black" name="price" type="number" required/>
        </label>
        <label>
            <span>${languagePack.get('유통기한')}:</span>
            <input class="w-full rounded p-0.5 text-black" name="limit_date" type="date" required/>
        </label>
        <div class="flex flex-row justify-center gap-2">
            <input type="submit" class="bg-black rounded p-1 px-4 w-fit" value="${languagePack.get('상품 추가 완료!')}"/>
            <input type="button" onclick="history.back();" class="bg-white text-black rounded p-1 px-4 w-fit"
                   value="${languagePack.get('돌아가기')}"/>
        </div>
    </form>
</div>
</body>
</html>
