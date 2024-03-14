public class ex55 {
    public static void main(String[] args) {
        try {
//            int[] nums = {10, 20, 30};
//            System.out.println(nums[3]);
//            System.out.println(10 / 0);
            String str = null;
            str.toLowerCase();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("index error");
        } catch (ArithmeticException e) {
            System.out.println("divided by 0");
        } catch (Exception e) {
            System.out.println("other");
        }

    }
}
