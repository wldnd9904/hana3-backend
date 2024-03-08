public class ex09 {
    public static void main(String[] args) {
        int i = 10, j = 3;

//        System.out.println(i+j);
//        System.out.println(i-j);
//        System.out.println(i*j);
//        System.out.println(i/j);
//        System.out.println(i%j);

        //나머지 연산자 %
        int k = 123;
        //연습문제 - 나머지연산자를 이용하여
        //1. 일의자리수 3을 출력하시오.
        System.out.println(k%10);
        //2. 십의자리수 2를 출력하시오.
        System.out.println(k/10%10);
        //3. 백의자리수 1을 출력하시오
        System.out.println(k/100%10);

        double d = 3.567;
        //4. 소숫점 첫째자리를 출력하시오.
        System.out.println((int)(d*10)%10);
        //5. 소숫점 첫째자리에서 반올림하여 출력하시오.
        System.out.println(Math.round(d));
        // 0.5 더하고 소수점 날려도 됨
        System.out.println((int)(d+0.5));
        //6. 소숫점 둘째자리에서 반올림하여 출력하시오.
        System.out.println((double)Math.round(d*10)/10);
    }
}
















