public class ex56 {
    public static void main(String[] args) {
        try {
            myFunc();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void myFunc() throws ArithmeticException {
        System.out.println("myFunc");
        System.out.println(10 / 0);
    }
}
