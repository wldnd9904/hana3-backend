import java.util.Scanner;
public class ex13 {
    public static void main(String[] args) {
        //Scanner
        //nextLine()
        //next()              // 공백까지만
        //nextInt() nextFloat() nextDouble()

        Scanner scan = new Scanner(System.in);
        System.out.println(scan.nextLine());

        System.out.println(scan.next());


        //java.util.InputMismatchException
        //next()함수에 저장된 버퍼메모리가 정리되지 않아서.
        //=> nextLine()한번 실행하기?
        scan.nextLine();
        System.out.println(scan.nextInt());

        scan.close();
    }
}
