// 생성자함수: 메서드 오버로딩이 가능
// 매개변수와 타입 개수 다르게
class Robot {
    String color = "빨강";

    public Robot() {
        System.out.println("기본 생성자함수");
    }

    public Robot(String color) {
        System.out.println("필드가 있는 생성자함수 ");
        this.color = color;
    }
}

public class ex38 {
    public static void main(String[] args) {
        Robot robot1 = new Robot("팔랑");
        Robot robot2 = new Robot();
    }
}
