public class ex10 {
    public static void main(String[] args) {
        int k = 233;
        String binaryString = String.format("%32s", Integer.toBinaryString(k)).replace(" ","0");
        System.out.println(binaryString);
        //MSB 0이면 양수, 1이면 음수
        //2의 보수 = 1의보수 +1
        //1의보수 = 뒤집기
        int i = 1;
        // << : 왼쪽으로 비트이동(*2), LSB 는 0으로 채워짐
        System.out.println(1<<1);
        System.out.println(1<<2);
        System.out.println(-1<<1);
        System.out.println(-1<<2);
        // >> : 오른쪽으로 비트이동(/2), MSB 는 음수면 1로 채워짐 (-1은 -1로 됨)
        System.out.println(4>>1);
        System.out.println(4>>2);
        System.out.println(-4>>1);
        System.out.println(-4>>2);
        // >>> : 오른쪽으로 비트이동(/2) 하고 MSB 0채워짐
        System.out.println(4>>>1);
        System.out.println(4>>>2);
        System.out.println(-4>>>1);
        System.out.println(-4>>>2);
    }
}
