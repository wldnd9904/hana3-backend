public class ex54 {
    public static void main(String[] args) {
        String name = null;
        System.out.println(name);

        try {
            System.out.println(name.toLowerCase());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
