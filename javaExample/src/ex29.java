//접근제한자
//c언어는 접근제한자 없어서 모든곳에서 접근가능 -> 변경감지어려움,유지보수어려움
//public    - 어디서나 접근 가능
//protected - 같은 폴더 + 상속관계에서 접근 가능
//default   - 같은 폴더
//private   - 같은 클래스 내

class Hong {
    String name = "홍길동"; //default: 같은 폴더
    public int age = 30; // public: everywhere
    protected int korScore = 80; // 같은 폴더 + 상속관계

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }

    private int engScore = 90; //자기클래스만.
    //Getter/Setter

    void printEngScore() {
        System.out.println(this.engScore);
    }
}

public class ex29 {
    public static void main(String[] args) {
        Hong hong = new Hong();
        System.out.println(hong.getEngScore());
        hong.setEngScore(29);
        System.out.println(hong.getEngScore());
    }
}
