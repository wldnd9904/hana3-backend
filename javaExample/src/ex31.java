import java.util.Arrays;

public class ex31 {
    static void echo() {
        System.out.println("ㅎㅇ");
    }

    static void echo(int x) {
        System.out.println("ㅎㅇ" + x);
    }

    static void echo(String s) {
        System.out.println("ㅎㅇ" + s);
    }

    //연습문제 - 오버로딩 연습
    // 메소드(함수) 이름 : calc
    // 반환형은 없음.
    //1. 매개변수 정수형 1개일때는 그냥 변수값만 출력
    //2. 매개변수 정수형 2개일때는 두 변수의 합계를 출력
    //3. 매개변수 정수형 3개일때는 세 변수중에서
    //   최대값을 출력하시오.
    static void calc(int x) {
        System.out.println(x);
    }

    static void calc(int x, int y) {
        System.out.println(x + y);
    }

    static void calc(int x, int y, int z) {
        System.out.println(Math.max(x, Math.max(y, z)));
    }

    public static void main(String[] args) {
        //메서드 오버로딩: 리턴이 같은 여러 시그니처의 함수 만들기
        //메서드 오버라이딩: 자식클래스가 부모클래스 재정의
        echo();
        echo(2);
        echo("?");

        calc(1);
        calc(123, 456);
        calc(5, 6, 7);

    }
}
