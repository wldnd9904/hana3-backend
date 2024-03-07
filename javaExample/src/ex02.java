public class ex02 {
    public static void main(String[] args) {
        // 한줄 주석문
        /*
        여러줄
        주석문
         */

        // 출력문
        // + 연산자는 문자열이 있으면 문자열 연결 연산자로 동작,
        // 둘 다 숫자면 산술연산
        System.out.println("화면출력");
        System.out.println("화면"+"출력");
        System.out.println("화면"+10+20);
        // 우선순위가 헷갈리면 소괄호
        System.out.println(10+(20+"화면"));
        System.out.println(1);
        // println: 문자열 한 줄 출력 후 줄바꿈
        // print: 줄바꿈 없음
        // printf: 형식화된 출력문
        System.out.printf("sd %d %d %d",1,3,4);
    }
}
