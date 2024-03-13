
//static: 정적 변수나 함수 지정
//프로그램 구동 시 고정된 메모리 번지에 들어감. 종료시까지 변경되지 않음
//사용이유:
// 1. 시작점(entry point) 지정
// 2. 중요한 데이터 안정적으로 출력
// 3. 자주 사용하는 유틸성 클래스에 지정 -> new 없이 사용 가능
class BallFactory {
    int ballCount = 100;

    void make() {
        this.ballCount++;
        System.out.println("ball + 1");
    }
}

class FoodFactory {
    static int foodCount = 100;

    static void make() {
        foodCount++;
        System.out.println("food + 1");
    }
}


public class ex27 {
    public static BallFactory myBallFactory;

    public static void main(String[] args) {
        BallFactory ballFactory = new BallFactory();
        System.out.println(ballFactory.ballCount);
        ballFactory.make();
        System.out.println(ballFactory.ballCount);

        System.out.println(FoodFactory.foodCount);
        FoodFactory.make();
        System.out.println(FoodFactory.foodCount);

    }
}
