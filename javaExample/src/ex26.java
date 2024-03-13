class Cafe {
    int coffeeCount = 10;

    void sale() {
        System.out.println("커피를 판다");
        this.coffeeCount--;
    }
}

class Farm {
    int carrot = 0;

    void plant() {
        this.carrot++;
        System.out.println("당근을 1개 생산했습니다.");
    }
}

public class ex26 {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        cafe.sale();
        cafe.sale();
        cafe.sale();
        System.out.println(cafe.coffeeCount);
        Farm farm = new Farm();
        farm.plant();
        farm.plant();
        farm.plant();
        farm.plant();
        farm.plant();
        System.out.println(farm.carrot);
    }
}
