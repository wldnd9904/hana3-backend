import java.io.FileWriter;
import java.io.IOException;

public class ex58 {
    public static void main(String[] args) {
        try (FileWriter file = new FileWriter("data.txt")) {
            file.write("gd");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
