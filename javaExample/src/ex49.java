// 익명 객체(이름없는 객체 - anonymous obj
// 일회성 메서드 재정의시 사용
// 한번쓰고 버릴거
interface NormalCar {
    void run();
}

class SuperCar implements NormalCar {
    @Override
    public void run() {
        System.out.println("supercar runs");
    }
}

public class ex49 {
    public static void main(String[] args) {
        SuperCar superCar = new SuperCar();
        superCar.run();

        NormalCar normalCar = new NormalCar() {
            @Override
            public void run() {
                System.out.println("normalCar runs");
            }
        };
        normalCar.run();

    }
}
