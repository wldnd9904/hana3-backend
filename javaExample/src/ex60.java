//연습문제 
// 혼자서 온도를 조절하는 보일러(Boiler)를 스레드로 설계해보자.
// Thread 클래스를 상속하여 만드시오.
// 실제 온도 변수 : int realTemp = 23;  초기값
// 설정 온도 변수 : int setTemp = 20; 초기값
//              설정 함수 : setSetTemp(int setTemp)
// 무한루프를 돌면서 : 실제 온도와 설정 온도를 출력하시오.
//                 : 1초마다 내부 온도를 설정온도에 +/- 1도씩 바꿀수있다.
// 출력값 : 실제온도:23, 설정온도:20
//         실제온도:22, 설정온도:20
//         실제온도:21, 설정온도:20
//         실제온도:20, 설정온도:20 빙고!
//  setSetTemp( 22 );
//         실제온도:21, 설정온도:22
//         실제온도:22, 설정온도:22 빙고!

import java.util.Scanner;

class Boiler implements Runnable {
    private int realTemp = 23;
    private int setTemp = 20;

    public void setSetTemp(int setTemp) {
        this.setTemp = setTemp;
        this.run();
    }

    @Override
    public void run() {
        while (realTemp != setTemp) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (realTemp > setTemp) realTemp--;
            else if (realTemp < setTemp) realTemp++;
            printTemp();
        }
    }

    private void printTemp() {
        System.out.printf("실제온도:%d, 설정온도:%d ", realTemp, setTemp);
        if (realTemp == setTemp) System.out.println("빙고!");
        else System.out.println();
    }
}

public class ex60 {
    public static void main(String[] args) {
        Boiler boiler = new Boiler();
        boiler.run();
        Scanner sc = new Scanner(System.in);
        int setTemp;
        while (true) {
            setTemp = sc.nextInt();
            if (setTemp == -273) break;
            boiler.setSetTemp(setTemp);
        }
        System.out.println("종료");
    }
}