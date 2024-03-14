//중첩클래스: 클래스 안에 클래스 넣기
class Outer {
    String name = "outer";

    static class Inner {
        String name = "inner";
    }
}

public class ex50 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println(outer.name);
        Outer.Inner inner = new Outer.Inner();
        System.out.println(inner.name);
    }
}
