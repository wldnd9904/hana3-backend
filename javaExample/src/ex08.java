public class ex08 {
    public static void main(String[] args) {
        // 단항
        int i = 10;
        i++; // i = i + 1;
        System.out.println(i);
        i--; // i = i - 1;
        System.out.println(i);

        boolean b  =true;
        System.out.println(!b);
        System.out.println(!!b);

        int j=32768;
        short s = (short)j;
        System.out.println(s);

        int k=10;
        int m = ~k;
        System.out.println(Integer.toBinaryString(m));

    }
}
