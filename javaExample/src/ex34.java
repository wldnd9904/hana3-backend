//생성자 함수 : 클래스 객체가 생성될 때 자동으로 호출되는 메서드
//용도: 클래스 필드 초기화할 때
class Book1 {
    int price = 1000;

    void read() {
        System.out.println("책을 읽는다.");
    }

    public Book1() {
        this.price = 2000;
        System.out.println("생성자 함수 호출");
    }
}

public class ex34 {
    public static void main(String[] args) {
        Book1 book = new Book1();
    }
}
