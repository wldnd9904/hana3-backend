public class ex04 {
    public static void main(String[] args) {
        // 자동 형변환: 대입(산술)연산자를 통해 자동으로 형변환
        // 수동 형변환: 형변환 연산자(타입)을 통해 형변환

        // 자동 예)
        // 1. 같은 타입끼리 연산될 때
        //  int * int => int
        //  long * long => long
        int i=10;
        int j=20;
        int k=i*j;
        // 2. 다른 타입끼리 연산될 때 => 더 큰 타입으로
        //  int * long => long
        // 3. 작은 타입에서 큰 타입으로 대입될 때 => 큰 타입으로
        long a = 10;
        // 4. 큰 타입에서 작은 타입으로 대입될 때 => 자동 안 됨
//        int b = 20L;

        // 수동(강제) 형변환
        // 형변환 연산자 사용
        // 주의) 표현범위 벗어나면 값 잘리고 쓰레기값됨
        // 작은타입 = (작은타입)큰타입;
        int c = (int)20L;

        //연습문제 3 - DM 으로 제출
        //1. short 형 변수 num1을 선언하고 10값을 넣어서 초기화 한다.
        //   int 형 변수 num2를 선언하고 20값을 넣어서 초기화 한다.
        //   num1을 float 형 변수 num3에 넣어서(대입) 자동형변환 시키자.
        short num1 = 10;
        int num2 = 20;
        float num3 = num1;
        //2. num2를 num1에 대입해서 강제 형변환 시킨 후 그 값을 출력하자.
        num1 = (short)num2;
        System.out.println(num1);
        //3. num3와 num2값을 곱하기 연산(*)한 후 자동 형변환 한 값을 출력하자.
        System.out.println(num3*num2);
    }
}
