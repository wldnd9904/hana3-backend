class MyClass {
    void func1() {
        System.out.println("func1");
    }

    void func2(int x, int y) {
        System.out.println("func2");
        System.out.println(x + " " + y);
    }

    int func3() {
        System.out.println("func3");
        return 10;
    }

    int func4(int x, int y) {
        System.out.println("func4");
        return x + y;
    }
}

public class ex28 {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.func1();
        myClass.func2(1, 2);
        System.out.println(myClass.func3());
        System.out.println(myClass.func4(1, 2));
    }
}
