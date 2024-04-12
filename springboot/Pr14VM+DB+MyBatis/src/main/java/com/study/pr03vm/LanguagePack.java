package com.study.pr03vm;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
class LanguagePack {
    static Map<String, Map<String, String>> packs = new HashMap<>();
}

@Component
class KoreanPack {
    static Map<String, String> dictionary;

    static {
        dictionary = new HashMap<>();
        dictionary.put("lang", "kor");
        dictionary.put("자판기", "자판기");
        dictionary.put("★자판기 프로그램★", "★자판기 프로그램★");
        dictionary.put("▽ 자판기 상품 목록", "▽ 자판기 상품 목록");
        dictionary.put("상품 목록이 비어있습니다.", "상품 목록이 비어있습니다.");
        dictionary.put("번호", "번호");
        dictionary.put("상품명", "상품명");
        dictionary.put("가격", "가격");
        dictionary.put("유통기한", "유통기한");
        dictionary.put("수정", "수정");
        dictionary.put("삭제", "삭제");
        dictionary.put("▲ 총 ", "▲ 총 ");
        dictionary.put("개의 상품이 있습니다.", "개의 상품이 있습니다.");
        dictionary.put("상품 추가하기!", "상품 추가하기!");
        dictionary.put("자판기 상품 추가", "자판기 상품 추가");
        dictionary.put("상품 추가 완료!", "상품 추가 완료!");
        dictionary.put("돌아가기", "돌아가기");
        dictionary.put("자판기 상품 수정", "자판기 상품 수정");
        dictionary.put("상품 수정 완료!", "상품 수정 완료!");
        dictionary.put("상품 삭제 완료!", "상품 삭제 완료!");
    }
}


@Component
final class EnglishPack {
    static Map<String, String> dictionary;

    static {
        dictionary = new HashMap<>();
        dictionary.put("lang", "eng");
        dictionary.put("자판기", "Vending Machine");
        dictionary.put("★자판기 프로그램★", "★ VENDING MACHINE");
        dictionary.put("▽ 자판기 상품 목록", "| Product List ▽");
        dictionary.put("상품 목록이 비어있습니다.", "Product list is empty.");
        dictionary.put("번호", "Num");
        dictionary.put("상품명", "Name");
        dictionary.put("가격", "Price");
        dictionary.put("유통기한", "LimitDate");
        dictionary.put("수정", "Edit");
        dictionary.put("삭제", "Remove");
        dictionary.put("▲ 총 ", "▲ total (");
        dictionary.put("개의 상품이 있습니다.", " item)");
        dictionary.put("상품 추가하기!", "Add Product");
        dictionary.put("자판기 상품 추가", "Add New Product");
        dictionary.put("상품 추가 완료!", "Add Product");
        dictionary.put("돌아가기", "Back");
        dictionary.put("자판기 상품 수정", "Edit Product");
        dictionary.put("상품 수정 완료!", "Edit Product");
        dictionary.put("상품 삭제 완료!", "Delete Product");
    }
}
