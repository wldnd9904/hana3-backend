public class ex03 {
    public static void main(String[] args) {
        // 데이터 타입(자료형)
        // 기본자료형 8개
        // 정수형: int(4) long(8) short(2) byte(1)
        // 실수형: float(4) double(8)
        // 논리형: boolean(1)
        // 문자형: char(2)
        int myInt = 10;
        System.out.println(myInt);
        long myLong = 20L; // L long 리터럴로 초기화
        System.out.println(myLong);
        short myShort = 30;
        System.out.println(myShort);
        byte myByte = 40;
        System.out.println(myByte);
        float myFloat = 6.14f; // f float 리터럴로 초기화
        System.out.println(myFloat);
        double myDouble = 3.14d; // d double 리터럴로 초기화 (기본값)
        System.out.println(myDouble);
        boolean myBoolean = true;
        System.out.println(myBoolean);
        char myChar1 = 'A';
        char myChar2 = '가';
        System.out.println(myChar1);
        System.out.println(myChar2);
        System.out.println((int)myChar1);
        System.out.println((char)(myChar1+myChar2));

        // 참조타입
        // 문자열
        String myString = "문자열ABC";
        String myString2 = new String("문자열2");
        System.out.println(myString+myString2);
    }
}
