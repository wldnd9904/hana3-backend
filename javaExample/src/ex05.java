public class ex05 {
    public static void main(String[] args) {
        String str1 = new String("안녕");
        String str2 = "안녕";
        String str3 = "안녕";
        String str4 = new String("안녕");

        System.out.println(str1 == str2);
        System.out.println(str2 == str3); // 같은 리터럴 선언하면 주소 같음
        System.out.println(str3 == str4);
        System.out.println(str4 == str1); // new 로 생성하면 주소 다름

        // 문자열 연결 연산자 +
        // 산술 연산자 +
        System.out.println("한글"+"만세");
        System.out.println("한글"+10);
        System.out.println("한글"+10);
        System.out.println(10+20);

        System.out.println("한글"+10+20);// 연산자 우선순위 좌 -> 우
        System.out.println(10+20+"한글");
        // 기본자료형 => 문자열 형변환
        String str = String.valueOf(10);
        System.out.println(str);
        // 문자열 => 정수
        int num = Integer.parseInt("010");
        System.out.println(num);
    }
}
