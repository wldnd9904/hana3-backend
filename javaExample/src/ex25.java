//OOP
//모든 사물을 객체로 추상화
//속성(필드)과 행동(메서드)으로 구분

//클래스 선언부
class Car {
    //속성 = 변수(필드) = 멤버변수
    int price = 1000;

    //행동(똥작) = 함수(메서드) = 멤버함수
    void run() {
        System.out.println("run.");
    }
}

public class ex25 {
    public static void main(String[] args) {
        //클래스의 객체 생성 및 호출부
        Car car = new Car();
        car.run();
    }
}
