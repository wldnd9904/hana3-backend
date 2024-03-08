import java.util.Scanner;

public class mp02 {
    static int[] bias = {-1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width, height, mineCount;

        //입력
        System.out.print("width: ");
        width = sc.nextInt();
        System.out.print("height: ");
        height = sc.nextInt();
        System.out.print("mine count: ");
        mineCount = sc.nextInt();
        if (mineCount < 0 || mineCount > width * height) return;

        int[][] map = new int[height][width];

        //지뢰 설치
        while (mineCount > 0) {
            int y = (int) (Math.random() * height);
            int x = (int) (Math.random() * width);
            if (map[y][x] == -1) continue;
            map[y][x] = -1;
            --mineCount;
            for (int yBias : bias)
                for (int xBias : bias)
                    checkAndPlus(map, y + yBias, x + xBias);
        }

        printMap(map, false);
        printMap(map, true);
    }

    static void printMap(int[][] map, boolean printNumber) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] == -1) System.out.print("*");
                else System.out.print(printNumber ? map[y][x] : "-");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void checkAndPlus(int[][] map, int y, int x) {
        if (y >= 0 && y < map.length && x >= 0 && x < map[0].length) {
            if (map[y][x] != -1)
                map[y][x] += 1;
        }
    }
}