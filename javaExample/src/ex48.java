class ClassM {
    int price = 10;
}

interface Vehicle {
    void drive();

    default void run() {
        System.out.println("run.");
    }
}

class Tesla implements Vehicle {
    @Override
    public void drive() {
        System.out.println("drive");
    }
}

public class ex48 {
    public static void main(String[] args) {

    }
}
