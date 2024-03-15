import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

//인터넷 통신
//1. TCP/IP(Socket통신) : 게임,채팅에 사용됨.
//      : 속도가 빠르다.
//      : 연결지향(한번 접속하면, 계속 연결이 지속됨.)
//      : 비공개 포트방식(Port : 컴퓨터에서 응용프로그램마다 가지는 통신창구)
//      : 공식포트 80 HTTP, 21 FTP, 443 HTTPS
//2. HTTP통신 : 대부분의 웹앱에서 사용됨.
//      : 공식포트 80이나 443포트만 이용, 내부망에서 8080,8090포트들이 사용됨.
//      : 웹브라우저 서버스 대응 용도에 사용됨.

//클라이언트(서비스를 제공받으면 클라) <--> 서버(서비스를 제공하면 서버)

public class ex125_client_copy {
    static final char[] chars = {'-', 'O', 'X'};
    static int[][] map = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    public static void main(String[] args) {
        Socket socket = null;
        socket = new Socket();
        try {
            socket.connect(
                    //127.0.0.1 : 접속하려는 컴퓨터의 주소를 말함. localhost와 같은 말.
                    new InetSocketAddress("172.16.20.91", 5001)
            );
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();

            System.out.println("서버 접속 성공!");

            //서버에 문자열형으로 데이타를 보내보자.
            byte[] bytes = null;
            String message = null;
            int x = -2;
            int y = -1;
            bytes = new byte[1024];
            int readByteCount = is.read(bytes);
            message = new String(bytes, 0, readByteCount, "UTF-8");
            System.out.println(message);
            while (true) {
                readByteCount = is.read(bytes);
                message = new String(bytes, 0, readByteCount, "UTF-8");
                System.out.println(message);
                Scanner scan = new Scanner(System.in);
                do {
                    System.out.print("x좌표 값을 입력하세요(0~2, -1:종료) : ");
                    x = scan.nextInt();
                } while (x < -1 || x > 2);
                if (x == -1) {
                    message = "exit";
                    bytes = message.getBytes("UTF-8");
                    os.write(bytes);
                    os.flush(); //버퍼에 데이타를 다 내보낸다.
                    os.close();
                    is.close();
                    break;
                }
                do {
                    System.out.print("y좌표 값을 입력하세요(0~2) : ");
                    y = scan.nextInt();
                } while (y < 0 || y > 2);
                message = String.format("%d,%d", x, y);
                bytes = message.getBytes("UTF-8");
                os.write(bytes);
                os.flush(); //버퍼에 데이타를 다 내보낸다.
                System.out.println("데이타보내기 성공!");
                //서버로부터 데이터 받기
                bytes = new byte[1024];
                readByteCount = is.read(bytes);
                message = new String(bytes, 0, readByteCount, "UTF-8");
//                System.out.println(printMap());
                System.out.println("데이타받기 성공:" + message);


                System.out.println("상대방 착수 대기중...");
                bytes = new byte[1024];
                readByteCount = is.read(bytes);
                message = new String(bytes, 0, readByteCount, "UTF-8");
                System.out.println("데이타받기 성공:" + message);
                //                System.out.println(printMap());

                // 누가 이겼는지 확인
                if (isGameOver()) {
                    System.out.println("Player00가 승리했습니다");
                }
            }
//            os.close();
//            is.close();
            //UTF-8 : 문자인코딩(부호화,암호화) 타입
            //문자인코딩타입 : ASCII(영문), EUC-KR(완성형한글), UTF-8(유니코드-전세계문자)
            //             : cp949(ms949) 윈도우즈 한글 인코딩

        } catch (Exception e) {
            System.out.println("서버 접속 오류!");
        }
    }

    static String printMap() {
        StringBuilder ret = new StringBuilder();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                ret.append(chars[map[y][x]] + " ");
            }
            ret.append('\n');
        }
        return ret.toString();
    }

    public static boolean isGameOver() {
        // 행 체크
        for (int i = 0; i < map.length; i++) {
            if (map[i][0] != 0 && map[i][0] == map[i][1] && map[i][0] == map[i][2]) {
                return true; // 같은 기호로 채워진 행이 있으면 게임 종료
            }
        }

        // 열 체크
        for (int j = 0; j < map.length; j++) {
            if (map[0][j] != 0 && map[0][j] == map[1][j] && map[0][j] == map[2][j]) {
                return true; // 같은 기호로 채워진 열이 있으면 게임 종료
            }
        }

        // 대각선 체크
        if (map[0][0] != 0 && map[0][0] == map[1][1] && map[0][0] == map[2][2]) {
            return true; // 왼쪽 위에서 오른쪽 아래로 채워진 대각선이 있으면 게임 종료
        }
        if (map[0][2] != 0 && map[0][2] == map[1][1] && map[0][2] == map[2][0]) {
            return true; // 오른쪽 위에서 왼쪽 아래로 채워진 대각선이 있으면 게임 종료
        }

        // 무승부 확인
        boolean isBoardFull = true;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 0) {
                    isBoardFull = false; // 아직 빈 칸이 있으면 무승부가 아님
                    break;
                }
            }
            if (!isBoardFull) {
                break;
            }
        }
        if (isBoardFull) {
            return true; // 모든 칸이 채워져 있으면 무승부
        }

        // 게임 진행 중
        return false;
    }
}