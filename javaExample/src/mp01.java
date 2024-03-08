import java.io.IOException;
import java.util.Scanner;

import static java.time.InstantSource.system;


public class mp01 {
    // 0:빈칸 1:벽 2:사람 3:골인
    public static void main(String[] args) {
        extractCharacter();
        Scanner sc = new Scanner(System.in);
        while (true) {
            printMap();
            String inputLine = sc.nextLine().trim();
            if (inputLine.isEmpty()) continue;
            char input = inputLine.charAt(0);
            switch (input) {
                case 'a':
                    if (cx > 0 && map[cy][cx - 1] != 1) cx--;
                    break;
                case 'd':
                    if (cx < map[0].length - 2 && map[cy][cx + 1] != 1) cx++;
                    break;
                case 'w':
                    if (cy > 0 && map[cy - 1][cx] != 1) cy--;
                    break;
                case 's':
                    if (cy < map.length - 2 && map[cy + 1][cx] != 1) cy++;
                    break;
                case 'q':
                    return;
                default:
                    break;
            }
            if (map[cy][cx] == 3) {
                printMap();
                System.out.println("골인!");
                return;
            }

        }

    }

    static char[] obj = {' ', '■', '●', '*'};
    //캐릭터 위치
    static int cx = 0, cy = 0;
    static int[][] map = {
            //col 0 1 2
            {1, 1, 1, 1, 1, 1, 1}, //row 0
            {1, 2, 1, 0, 0, 3, 1}, //1
            {1, 0, 1, 0, 1, 1, 1}, //2
            {1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1},
            //{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, //row 0
            //{1,2,0,1,0,0,0,0,0,0,0,0,0,0,1}, //1
            //{1,0,0,1,0,0,1,1,1,1,1,1,0,0,1}, //2
            //{1,0,0,1,0,0,0,0,0,0,0,1,0,0,1},
            //{1,0,0,1,1,1,1,1,1,0,0,1,0,0,1},
            //{1,0,0,1,0,0,0,0,1,0,0,1,0,0,1},
            //{1,0,0,1,0,0,0,0,1,0,0,1,0,0,1},
            //{1,0,0,1,0,0,0,0,1,0,0,1,0,0,1},
            //{1,0,0,1,0,0,0,0,1,0,0,1,0,0,1},
            //{1,0,0,1,0,0,0,0,1,0,0,1,0,0,1},
            //{1,0,0,0,0,0,0,0,1,0,0,1,0,0,1},
            //{1,0,0,1,0,0,0,0,1,0,0,1,0,0,1},
            //{1,0,0,1,0,0,0,0,1,0,0,1,0,0,1},
            //{1,0,0,1,0,0,0,0,0,0,0,1,3,0,1},
            //{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    };

    //맵 프린트
    static void printMap() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (x == cx && y == cy) System.out.print(obj[2] + " ");
                else System.out.print(obj[map[y][x]] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //맵 순회하며 캐릭터 찾아서 위치 뽑고 없애기
    static void extractCharacter() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] == 2) {
                    cx = x;
                    cy = y;
                    map[y][x] = 0;
                    return;
                }
            }
        }
    }
}
