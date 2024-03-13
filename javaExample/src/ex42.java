//클래스 배열 만들기
class Snack {
    String name = "새우깡";
    int price = 1000;

    public Snack(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

public class ex42 {
    public static void main(String[] args) {
        Snack[] snacks = new Snack[5];
        snacks[0] = new Snack("짱구", 2000);
        snacks[1] = new Snack("포카칩", 3000);
        snacks[2] = new Snack("허니버터칩", 1200);
        snacks[3] = new Snack("프링글스", 3800);
        snacks[4] = new Snack("맹", 9);
        for (Snack snack : snacks) {
            System.out.println(snack.name + ": " + snack.price + "원");
        }
    }
}
