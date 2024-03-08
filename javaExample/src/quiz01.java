import java.util.Arrays;
import java.util.Scanner;

public class quiz01 {
    public static void main(String[] args) {
        //1번문제 - 알바천국
        //알바생 홍길동은 월, 수, 금, 일 아르바이트를 간다.
        //다음은 요일의 순서이다. 월요일 (1) 화요일 (2) ... 일요일 (7)
        //요일의 번호가 입력으로 주어지면 그 날이 아르바이트 가는 날이면 "oh my god"를 가는 날이 아니면 "enjoy"를 출력하시오.
        //입력
        //Scanner 콘솔 입력으로 요일의 번호가 하나 주어진다.(정수)
        //        출력
        //아르바이트 가는 날이면 "oh my god~"를 가는 날이 아니면 "enjoy!"를 출력하시오.
        //입력 예시
        //1
        //출력 예시
        //oh my god~
        //        입력 예시
        //2
        //출력 예시
        //enjoy!
        int[] workDays = new int[]{1, 3, 5, 7};
        Scanner sc = new Scanner(System.in);
        int inputDay = sc.nextInt();
        boolean isBreakDay = true;
        for(int i:workDays){
            if(i==inputDay) {
                isBreakDay = false;
                break;
            }
        }
        System.out.println(isBreakDay ? "enjoy!" : "oh my god~" );
    }
}
