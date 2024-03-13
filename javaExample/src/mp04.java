import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class mp04 {
    public static void main(String[] args) {
        init();
        generateFruit();
        Scanner sc = new Scanner(System.in);
        int dir = -1;
        while (dir == -1 || move(dir)) {
            printMap();
            System.out.print("이동(wasd):");
            char input = sc.next().charAt(0);
            sc.nextLine();
            dir = switch (input) {
                case 'w' -> 3;
                case 'a' -> 0;
                case 's' -> 2;
                case 'd' -> 1;
                default -> -1;
            };
        }
        System.out.println("게임 종료");
    }

    static int[][] map;
    static final int SIZE = 8;
    static final int MAXLENGTH = (SIZE - 1) * (SIZE - 1);
    static final char[] signs = {'.', '^', '@', '~', '#'}; //빈칸, 벽, 머리, 몸(꼬리), 과일
    static final int[] dx = {-1, +1, 0, 0}; // a, d, s, w
    static final int[] dy = {0, 0, +1, -1};
    static Queue<Point> snake;
    static int headX, headY;

    static void push(int x, int y) {
        headX = x;
        headY = y;
        snake.add(new Point(x, y));
    }

    static void init() {
        map = new int[SIZE + 1][SIZE + 1]; // 0으로 자동초기화
        //벽채우기
        for (int i = 0; i <= SIZE; i++) {
            map[0][i] = 1;
            map[SIZE][i] = 1;
            map[i][0] = 1;
            map[i][SIZE] = 1;
        }
        snake = new LinkedList<>();
        int initX = SIZE / 2, initY = SIZE / 2;
        push(initX, initY);
        map[initY][initX] = 2;
    }

    static boolean move(int dir) {
        if (snake.isEmpty()) return false;
        int nextX = headX + dx[dir];
        int nextY = headY + dy[dir];
        switch (map[nextY][nextX]) {
            case 0://없음
                Point remove = snake.remove();
                if (remove == null) break;
                map[headY][headX] = 3;
                map[remove.y][remove.x] = 0;
                push(nextX, nextY);
                map[nextY][nextX] = 2;
                break;
            case 1://벽
            case 3://몸통
                System.out.println("사망");
                return false;
            case 4://과일
                map[headY][headX] = 3;
                push(nextX, nextY);
                map[nextY][nextX] = 2;
                if (snake.size() == (MAXLENGTH)) {
                    System.out.println("클리어!");
                    return false;
                }
                generateFruit();
                break;
            default:
                break;
        }
        return true;
    }

    static void generateFruit() {
        //많이 채웠으면 남은거중 하나
        if (snake.size() > (MAXLENGTH * 0.8)) {
            int idx = (int) (Math.random() * (MAXLENGTH - snake.size()));
            for (int y = 1; y <= SIZE; y++) {
                for (int x = 1; x <= SIZE; x++) {
                    if (map[y][x] == 0) {
                        idx--;
                        if (idx == 0) {
                            map[y][x] = 4;
                            return;
                        }
                    }
                }
            }
        }
        //평소엔 바로 랜덤
        int x, y;
        do {
            x = (int) (Math.random() * (SIZE - 1)) + 1;
            y = (int) (Math.random() * (SIZE - 1)) + 1;
        } while (map[y][x] != 0);
        map[y][x] = 4;
    }

    static void printMap() {
        for (int y = 0; y <= SIZE; y++) {
            for (int x = 0; x <= SIZE; x++) {
                System.out.print(signs[map[y][x]]);
            }
            System.out.println();
        }

    }
}
