public class ex53 {
    public static void main(String[] args) {
        //래퍼 클래스
        //1. 기본자료형 8개 감싸서 클래스로 만든 것
        //2. 클래스로만들면 다형성이용가능
        //int, long, short, byte, char, boolean, float, double
        //Integer, Long, Short, Byte, Character, Boolean, Float, Double
        //숫자: Number <= int long short byte float double..
        Integer intValue1 = new Integer(10);
        Integer intValue2 = 10;
        System.out.println(intValue2);
        System.out.println(intValue2.byteValue());
        System.out.println(intValue2.doubleValue());
    }
}
