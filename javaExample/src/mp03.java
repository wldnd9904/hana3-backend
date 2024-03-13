import java.util.ArrayList;
import java.util.Scanner;

//### **미니프로젝트 3. 오델로 게임**
//        **문제 설명**
//바둑판(10 * 10)에 오델로 게임을 알파고와 해서 이기는 게임을 만듭니다.
//게임룰은 이미 돌이 놓은 위치에는 돌을 올려놓을 수가 없습니다.
//사람은 검은 돌(X문자), 알파고는 흰돌(O 문자)를 사용합니다.
//흰색 돌이 놓이면, 상화좌우 대각선 위치의 흰색돌 사이의 검은돌이 흰색돌로 바뀝니다.
//반대로 검은 돌이 놓이면, 상화좌우 대각선 위치의 검은돌과 검은돌 사이의
//흰돌이 검은 돌로 바뀝니다.
//더 이상 놓을 자리가 없으면, 자동으로 게임이 종료됩니다.
public class mp03 {
    public static void main(String[] args) {
        Othello othello = new Othello();
        othello.run();
    }
}

class Othello {
    private int[][] map;
    private boolean[][] settable;
    private final int SIZE = 8;
    static final char[] signs = {' ', '●', '◯', '•'};
    static final int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static final int[] dy = {1, 0, -1, -1, -1, 0, 1, 1};

    public Othello() {
        map = new int[SIZE + 1][SIZE + 1]; // 0으로 자동초기화
        map[SIZE / 2][SIZE / 2] = 1;
        map[SIZE / 2 + 1][SIZE / 2 + 1] = 1;
        map[SIZE / 2 + 1][SIZE / 2] = 2;
        map[SIZE / 2][SIZE / 2 + 1] = 2;
        updateSettable(1);
    }

    public void run() {
        printMap();
        Scanner sc = new Scanner(System.in);
        while (!isGameEnded()) {
            int y, x;
            System.out.print("가로 좌표를 입력하세요:");
            x = sc.nextInt();
            sc.nextLine();
            System.out.print("세로 좌표를 입력하세요:");
            y = sc.nextInt();
            sc.nextLine();
            if (!put(x, y, 1)) {
                System.out.println("잘못된 위치입니다.");
                continue;
            }
            printMap();
            System.out.print("컴퓨터의 차례입니다...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            autoPut();
            printMap();
        }
        System.out.print("게임 종료\n 최종 결과: ");
        int score = printScore();
        if (score > 0) {
            System.out.println("승리!");
        } else if (score == 0) {
            System.out.println("무승부!");
        } else {
            System.out.println("패배!");
        }
    }

    private boolean isGameEnded() {
        //모든 칸에 대해
        for (int y = 1; y <= SIZE; y++)
            for (int x = 1; x <= SIZE; x++)
                //놓을 곳 있으면 안끝난것
                if (settable[y][x]) return false;
        return true;
    }

    private boolean check(int y, int x) {
        if (x < 1 || y < 1 || x > SIZE || y > SIZE) return false;
        return true;
    }

    private void updateSettable(int my) {
        final int opponent = 3 - my;
        settable = new boolean[SIZE + 1][SIZE + 1];
        //모든 칸에 대해
        for (int y = 1; y <= SIZE; y++) {
            for (int x = 1; x <= SIZE; x++) {
                if (map[y][x] != 0) continue;
                //8방향에 대해
                for (int dir = 0; dir < 8; dir++) {
                    //일단 한 칸이 다른색일 때
                    if (check(y + dy[dir], x + dx[dir]) && map[y + dy[dir]][x + dx[dir]] == opponent) {
                        //끝까지 가면서 내 색 있는지 확인
                        int dist = 2;
                        while (check(y + dy[dir] * dist, x + dx[dir] * dist) && map[y + dy[dir] * dist][x + dx[dir] * dist] == opponent)
                            dist++;
                        if (check(y + dy[dir] * dist, x + dx[dir] * dist) && map[y + dy[dir] * dist][x + dx[dir] * dist] == my) {
                            settable[y][x] = true;
                            break; //다음좌표로
                        }
                    }
                }
            }
        }
    }

    private void autoPut() {
        ArrayList<Integer> xCand = new ArrayList<Integer>();
        ArrayList<Integer> yCand = new ArrayList<Integer>();
        //모든 칸에 대해
        for (int y = 1; y <= SIZE; y++) {
            for (int x = 1; x <= SIZE; x++) {
                if (settable[y][x]) {
                    xCand.add(x);
                    yCand.add(y);
                }
            }
        }
        //랜덤으로 하나 뽑기
        if (xCand.isEmpty()) {
            System.out.println("놓을 자리가 없습니다.");
            return;
        }
        int idx = (int) (Math.random() * xCand.size());
        System.out.printf("(%d, %d)\n", xCand.get(idx), yCand.get(idx));
        put(xCand.get(idx), yCand.get(idx), 2);
    }

    private boolean put(int x, int y, int my) {
        if (!settable[y][x])
            return false;
        map[y][x] = my;
        final int opponent = 3 - my;
        //8방향에 대해
        for (int dir = 0; dir < 8; dir++) {
            //일단 한 칸이 다른색일 때
            if (check(y + dy[dir], x + dx[dir]) && map[y + dy[dir]][x + dx[dir]] == opponent) {
                //끝까지 가면서 내 색 있는지 확인
                int dist = 2;
                while (check(y + dy[dir] * dist, x + dx[dir] * dist) && map[y + dy[dir] * dist][x + dx[dir] * dist] == opponent)
                    dist++;
                if (check(y + dy[dir] * dist, x + dx[dir] * dist) && map[y + dy[dir] * dist][x + dx[dir] * dist] == my) {
                    //내 돌 만나면 그 사이 전부 내걸로 채움
                    for (int i = 1; i < dist; i++) {
                        map[y + dy[dir] * i][x + dx[dir] * i] = my;
                    }
                }
            }
        }
        updateSettable(opponent);
        return true;
    }

    private void printMap() {
        System.out.print("| X ");
        for (int y = 1; y <= SIZE; y++) {
            System.out.printf("| %d ", y);
        }
        System.out.println('|');
        printHLine(SIZE * 4 + 5);
        for (int y = 1; y <= SIZE; y++) {
            System.out.printf("| %d ", y);
            for (int x = 1; x <= SIZE; x++) {
                System.out.printf("| %c ", settable[y][x] ? signs[3] : signs[map[y][x]]);
            }
            System.out.println('|');
            printHLine(SIZE * 4 + 5);
        }
        printScore();
    }

    private int printScore() {
        int my = 0, opp = 0;
        //모든 칸에 대해
        for (int y = 1; y <= SIZE; y++) {
            for (int x = 1; x <= SIZE; x++) {
                if (map[y][x] == 2) opp++;
                else if (map[y][x] == 1) my++;
            }
        }
        System.out.printf("플레이어(●):%d 컴퓨터(◯):%d\n", my, opp);
        return my - opp;
    }

    private void printHLine(int length) {
        for (int y = 0; y < length; y++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
