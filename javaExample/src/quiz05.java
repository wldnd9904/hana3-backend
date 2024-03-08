import java.util.Scanner;

public class quiz05 {
    public static void main(String[] args) {
        //### 4번 문제 - 컴퓨터와 함께 369게임하기
        //컴퓨터와 현빈이가 369게임을 하게 되었다.
        //컴퓨터가 먼저 숫자를 출력하되, 3이나 6이나 9가 들어 있으면, 박수 X 글자로 대신한다.
        //현빈이는 직접 Scanner 콘솔에 입력한다.
        //1부터 40까지 게임을 해서 누가 승리했는지 또는 무승부인지를 출력해보자.
        //중간에 현빈(인간)이 숫자를 잘못 입력하면, 컴퓨터 승! 이라고 출력하고 게임종료 된다.
        //출력예)
        //컴퓨터 : 1
        //나 : 2 입력후 엔터
        //컴퓨터 : X
        //나 : X 입력후 엔터
        //컴퓨터 승!
        //게임종료
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 40; i++) {
            if ((i & 1) == 1) {
                String output = String.format("컴퓨터: %d\n", i)
                        .replaceAll("[369]", "X");
                System.out.print(output);
                continue;
            }
            System.out.print("나: ");
            String input = scanner.next();
            scanner.nextLine();

            String predict = (String.valueOf(i))
                    .replaceAll("[369]", "X");
            if (!input.equals(predict)) {
                System.out.println("컴퓨터 승!\n게임 종료");
                return;
            }
        }
        System.out.println("무승부!\n게임 종료");
    }
}
