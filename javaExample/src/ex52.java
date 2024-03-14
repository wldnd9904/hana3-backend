public class ex52 {
    public static void main(String[] args) {
        //String 관련 클래스
        //StringBuffer : 문자열을 더 유연하게 해 줌
        //               append, insert, delete
        //StringBuilder : 대량의 문자열 처리
        StringBuffer sb = new StringBuffer("abc");
        System.out.println(sb);

        sb.append("def");
        System.out.println(sb);

        sb.insert(3, "123");
        System.out.println(sb);

        sb.delete(2, 4); // [2,4)
        System.out.println(sb);

        StringBuilder sbui = new StringBuilder(sb);
    }
}
