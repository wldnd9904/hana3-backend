//추상클래스 abstract class
//일반함수 + 가상함수(추상화 메서드)
//가상함수 : 함수 선언만있고 본체는 없는것
//하위에서 재정의해서 사용

//사용하는이유:
//1. 설계와 구현의 관점에서 생각
//
abstract class Picture {
    abstract void draw();

    void sale() {
        System.out.println("panda");
    }

}

class Picasso extends Picture {
    @Override
    void draw() {
        System.out.println("Picasso draws a picture.");
    }
}

public class ex45 {
    public static void main(String[] args) {
        Picture picasso = new Picasso();
        picasso.draw();
        picasso.sale();
    }
}
