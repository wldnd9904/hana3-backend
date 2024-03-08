import java.util.Scanner;

public class quiz04 {
    public static void main(String[] args) {
        //### 3번 문제 - 369 게임 달인
        //3 6 9 게임을 하던 현빈이는 3 6 9 게임에서 잦은 실수로 계속해서 벌칙을 받게 되었다.
        //3 6 9 게임의 왕이 되기 위한 마스터 프로그램을 작성해 보자.
        //입력
        //Scanner 콘솔입력으로 1부터 10사이의 정수 한 개가 입력된다.
        //        출력
        //1 부터 그 수까지 순서대로 공백을 두고 수를 출력하는데,
        //3 또는 6 또는 9가 들어간 경우 그 수 대신 영문 대문자 X를 출력한다.
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String output = "";

        for (int i = 1; i <= num; i++)
            output += i + " ";

        String replaced = output.replaceAll("[369]", "X");
        System.out.print(replaced);
        // > 10
        // 1 2 X 4 5 X 7 8 X 10
    }
}
