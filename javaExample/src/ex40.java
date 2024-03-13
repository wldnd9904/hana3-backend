//오버라이드
//부모의 메서드를 자식이 재정의
class Machine {
    void work() {
        System.out.println("일한다.");
    }
}

class CoffeeMachine extends Machine {
    String name = "커피머신";

    // 오버라이드 메서드 : 반환타입, 함수이름, 매개변수 동일
    //어노테이션 : @로 시작하는 컴파일 지시어
    //개발자나 컴파일러에게 해당 속성 알려줌
    @Override
    void work() {
        System.out.println("커피머신이 일한다.");
    }
}

public class ex40 {
    public static void main(String[] args) {

        Machine machine = new Machine();
        CoffeeMachine coffeemachine = new CoffeeMachine();
        machine.work();
        coffeemachine.work();
    }
}
