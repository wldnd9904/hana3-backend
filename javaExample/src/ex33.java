//연습문제 - 싱글톤 만들기
//클래스 이름 : HanaAccount
//  필드 : 계좌번호(1234), 고객이름(홍길동), 잔액(1000), 이자율(년3%)
//  메소드 : 입금(+100), 출금(-100), 이자계산(1년후 잔액), 잔액조회
class HanaAccount {
    private int 계좌번호 = 1234;
    private String 고객이름 = "홍길동";
    private int 잔액 = 1000;
    private double 이자율 = 1.03;
    private static HanaAccount singleton;

    static HanaAccount getInstance() {
        if (singleton == null) singleton = new HanaAccount();
        return singleton;
    }

    public void 입금(int x) {
        System.out.println(x + "원 입금");
        this.잔액 += x;
    }

    public void 출금(int x) {
        System.out.println(x + "원 출금");
        this.잔액 -= x;
    }

    public void 이자계산(int x) {
        System.out.println(x + "년 경과");
        double base = this.잔액;
        for (int i = 0; i < x; i++) {
            base *= this.이자율;
        }
        this.잔액 = (int) base;
    }

    public int 잔액조회() {
        return this.잔액;
    }

    public String get고객이름() {
        return this.고객이름;
    }

    public int get계좌번호() {
        return this.계좌번호;
    }

    public double get이자율() {
        return this.이자율;
    }
}


public class ex33 {
    public static void main(String[] args) {
        //싱글톤을 호출후
        HanaAccount account = HanaAccount.getInstance();
        System.out.println("계좌번호: " + account.get계좌번호());
        System.out.println("고객이름: " + account.get고객이름());
        System.out.println("잔액: " + account.잔액조회());
        //1. 입금 메소드 호출
        account.입금(100);
        System.out.println("입금 후 잔액: " + account.잔액조회());
        //2. 출금 메소드 호출
        account.출금(100);
        System.out.println("출금 후 잔액: " + account.잔액조회());
        //3. 이자계산은 이자율을 읽어서 참조한다.
        System.out.println("이자율: " + account.get이자율() + "%");
        account.이자계산(1);
        //   이자계산후 잔액 증가한다.
        //4. 최종 잔액을 출력한다.
        System.out.println("1년 후 잔액: " + account.잔액조회());
    }
}