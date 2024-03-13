class Energy {
    int price = 1000;

    //생성자 자동생성 (우클릭-생성-생성자)
    public Energy(int price) {
        this.price = price;
        System.out.println("Energy(int)");
    }

    public Energy() {
        System.out.println("Energy()");
    }
}

class WindEnergy extends Energy {
    int price = 2000;

    public WindEnergy() {
        System.out.println("Wind()");
    }

    public WindEnergy(int price) {
        this.price = price;
        System.out.println("Wind(int)");
    }
}

public class ex39 {
    public static void main(String[] args) {
        WindEnergy we1 = new WindEnergy();
        WindEnergy we2 = new WindEnergy(30000);
    }
}
