//싱글톤
//프로그램 안의 유일한 객체
class FishBun {
    int bunNo = 10;
}

class UniqueFishBun {
    int bunNo = 30;
    private static UniqueFishBun singleton;

    static UniqueFishBun getInstance() {
        if (singleton == null) singleton = new UniqueFishBun();
        return singleton;
    }
}

public class ex32 {
    public static void main(String[] args) {

        UniqueFishBun bun1 = UniqueFishBun.getInstance();
        UniqueFishBun bun2 = UniqueFishBun.getInstance();
        System.out.println(bun1);
        bun1.bunNo = 20;
        System.out.println(bun2);
    }
}
