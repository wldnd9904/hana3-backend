//abstract class VS interface


//클래스: 다중상속 불가능, 다단계는 가능
class A {

}

class B extends A {

}

class C extends B {
}

//인터페이스: 다중상속 가능
interface IA {

}

interface IB extends IA {
}

interface IC {
    int A = 10;
}

class E implements IA, IB {
}

class SupermanClass extends C implements IA, IC {
}

public class ex47 {
    public static void main(String[] args) {
        SupermanClass s = new SupermanClass();
        System.out.println(s.A);
    }
}
