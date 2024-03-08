public class ex12 {
    public static void main(String[] args) {
        //삼항: ? :
        int i = 10<20?10:20;
        System.out.println(i);

        //중복x
        int j = (10<20) ? (20<30)?20:30:40;
        System.out.println(j);
    }
}
