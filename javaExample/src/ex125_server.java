import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

class TicTacToeServer {
    ServerSocket serverSocket = null;
    PlayerSocket player1 = null;
    PlayerSocket player2 = null;

    static final char[] chars = {'-', 'O', 'X'};
    int[][] map = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    int turn = 1;

    private String printMap() {
        StringBuilder ret = new StringBuilder("\n");
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                ret.append(chars[map[y][x]]).append(" ");
            }
            ret.append('\n');
        }
        return ret.toString();
    }

    private void set(int x, int y, int player) {
        map[y][x] = player;
        turn = 3 - player;
    }

    TicTacToeServer() {
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(
                    new InetSocketAddress("172.16.20.91", 5001));
        } catch (IOException e) {
            System.out.println("서버 초기화 실패");
        }
    }

    public void run() {
        player1 = new PlayerSocket("1P", 1);
        player2 = new PlayerSocket("2P", 2);
        Thread player1Thread = new Thread(player1);
        Thread player2Thread = new Thread(player2);
        player1Thread.start();
        player2Thread.start();
    }

    class PlayerSocket extends Thread {
        String name;
        int id;

        public PlayerSocket(String name, int id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + "연결 대기중...");
                Socket socket = serverSocket.accept(); //Blocking..대기중..
                InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println(name + ") 연결됨:" + isa.getHostName());
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                os.write(("당신은" + name + "입니다." + (turn != id ? "\n차례 대기 중..." : "")).getBytes(StandardCharsets.UTF_8));
                os.flush();
                while (turn != id) {
                    Thread.sleep(100);
                }
                while (true) {
                    Thread.sleep(1000);
                    os.write(("당신의 차례입니다." + printMap()).getBytes(StandardCharsets.UTF_8));
                    os.flush();
                    //클라이언트 데이타를 수신한다.
                    byte[] bytes = null;
                    String message = null;
                    bytes = new byte[1024]; //1024바이트만큼 버퍼메모리 생성
                    System.out.println(name + ") 입력 대기중...");
                    int readByteCount = is.read(bytes);
                    System.out.println("~");
                    message = new String(bytes, 0, readByteCount, StandardCharsets.UTF_8);
                    System.out.println(name + ") 데이터 받음: " + message);
                    if (message.equals("exit")) { //"exit"문자열이면 서버 종료!
                        break;
                    }
                    // 클라이언트로부터 전송된 메시지를 x와 y 좌표로 파싱
                    String[] coordinates = message.split(","); // 콤마로 구분하여 파싱
                    int x = Integer.parseInt(coordinates[0]);
                    int y = Integer.parseInt(coordinates[1]);
                    set(x, y, id);
                    //서버에서 클라로 데이타 보내기
                    message = printMap();
                    bytes = message.getBytes(StandardCharsets.UTF_8);
                    os.write(bytes);
                    os.flush(); //버퍼에 있는 데이타 밀어내기
                    System.out.println(name + ") 착수 완료, 상대방 기다리는 중...");
                    os.write(("차례 대기 중...").getBytes(StandardCharsets.UTF_8));
                    os.flush();
                    while (turn != id) {
                        Thread.sleep(100);
                    }
                }
                System.out.println(name + ") 연결 해제됨");
                is.close();
                os.close();
                socket.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                System.out.println(name + ") 접속이 끊겼습니다.");
            }
        }
    }
}


public class ex125_server {
    public static void main(String[] args) {
        TicTacToeServer server = new TicTacToeServer();
        server.run();
    }
}
