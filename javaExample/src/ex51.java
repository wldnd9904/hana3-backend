//API : Application Programming Interface, 함수/클래스 호출의 접점.
//SDK : Software Development Kit, 소프트웨어 개발 툴 모음
//라이브러리 : Library 도서관. 함수나 클래스들의 모임.
//프레임워크 : Framework 뼈대. 어떤 소프트웨어를 만드는데 사용하는 근간. 모듈.
//콜렉션 : Collection. SW 모음.
//JDK : Java Development Kit. Java + SDK
//DLL : 동적 링크 라이브러리(dynamic-link library). 함수 및 클래스모임.
//JAR : Java Archive, 자바 아카이브. .class파일과 리소스(이미지,텍스트), 메타파일을 모아둔 것. 실행가능한 압축파일. 타임리프/스프링부트
//WAR: JAR과 유사한 자바 압축파일, Web관련 환경설정 추가된 것, JSP/스프링 레거시
//프레임워크 > 라이브러리 > 콜렉션 > SDK > API

//자바의 최상위 클래스 : Object
//코틀린/스위프트는 AnyObject, 타입스크립트는 any

public class ex51 {
    public static void main(String[] args) {

        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println(obj1);
        System.out.println(obj1.hashCode());
        System.out.println(obj2);
        System.out.println(obj2.hashCode());

        System.out.println(obj1.equals(obj2));

        System.out.println(obj1.toString());
    }
}
