//람다식 JDK 1.8
// 함수형 지원
// 코드를 변수처럼 전달
// 자바: 객체, 람다식 - 선언되는 시점과 실행되는 시점이 다름
// 3세대 언어: 함수형언어 JS, Swift, Kotlin, ..
@FunctionalInterface
interface MyFunc1 {
    int calc(int x, int y);
}

public class ex64 {
    public static void main(String[] args) {
        MyFunc1 f1 = (x, y) -> x + y;
        System.out.println(f1.calc(10, 20));
        execFunc(f1);
    }

    static void execFunc(MyFunc1 f1) {
        System.out.println(f1.calc(10, 20));
    }

}
