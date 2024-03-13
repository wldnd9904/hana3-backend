class StaticClass {
    int a;
    static int b;

    static {
        b = 5;
        System.out.println("static block");
    }

    StaticClass() {
        a = 3;
        b = 10;
    }
}

public class ex35 {
    public static void main(String[] args) {
        System.out.println(StaticClass.b);
        StaticClass sc = new StaticClass();
        System.out.println(sc.a);
    }
}
