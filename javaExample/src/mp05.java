import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mp05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Program program = new Program(scanner);
        program.run();
    }
}

class Student {
    String name;
    int kor;
    int eng;
    int math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = Math.max(0, Math.min(kor, 100));
        this.eng = Math.max(0, Math.min(eng, 100));
        this.math = Math.max(0, Math.min(math, 100));
    }

    public void print() {
        final int sum = this.kor + this.eng + this.math;
        final double avg = (double) sum / 3;
        System.out.printf("이름: %s 국어: %d 영어: %d 수학: %d 총점: %d 평균: %.1f\n", name, kor, eng, math, sum, avg);
    }
}

class Program {
    private final List<Student> list = new ArrayList<Student>();
    static final String[] subjects = {"", "국어", "영어", "수학"};
    private Scanner sc;

    public Program(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        boolean running = true;
        while (running) {
            prompt();
            int input = sc.nextInt();
            sc.nextLine();
            switch (input) {
                case 1:
                    add();
                    break;
                case 2:
                    print();
                    break;
                case 3:
                    find();
                    break;
                case 4:
                    edit();
                    break;
                case 5:
                    delete();
                    break;
                case 6:
                    running = false;
                    System.out.println("종료!!");
                    break;
            }
        }
    }

    private void prompt() {
        System.out.println("-----------성적 관리 프로그램-------------");
        System.out.print("1.입력 2.전체출력 3.검색 4.수정 5.삭제 6.종료 : ");
    }

    private void add() {
        System.out.print("이름 입력: ");
        String name = sc.nextLine().trim();
        System.out.print("국어점수 입력: ");
        int kor = sc.nextInt();
        sc.nextLine();
        System.out.print("영어점수 입력: ");
        int eng = sc.nextInt();
        sc.nextLine();
        System.out.print("수학점수 입력: ");
        int math = sc.nextInt();
        sc.nextLine();
        list.add(new Student(name, kor, eng, math));
    }

    private void print() {
        for (Student student : list) {
            student.print();
        }
    }

    private void find() {
        System.out.print("검색할 사람의 이름: ");
        String name = sc.nextLine().trim();
        int cnt = 0;
        for (Student student : list) {
            if (student.name.equals(name)) {
                student.print();
                cnt++;
            }
        }
        if (cnt == 0) System.out.println("찾은 사람이 없습니다.");
    }

    private void edit() {
        System.out.print("수정할 사람의 이름: ");
        String name = sc.nextLine().trim();
        List<Student> tobeEdited = new ArrayList<Student>();

        for (Student student : list) {
            if (student.name.equals(name)) {
                tobeEdited.add(student);
            }
        }
        if (tobeEdited.isEmpty()) {
            System.out.println("수정할 사람이 없습니다.");
            return;
        }
        System.out.print("수정할 내용은? 1.국어 2.영어 3.수학: ");
        int input = sc.nextInt();
        sc.nextLine();
        if (input < 1 || input > 3) {
            System.out.println("입력이 잘못되었습니다.");
            return;
        }
        System.out.printf("%s점수 수정: ", subjects[input]);
        int score = Math.max(0, Math.min(sc.nextInt(), 100));
        sc.nextLine();
        for (Student student : tobeEdited) {
            switch (input) {
                case 1:
                    student.kor = score;
                    break;
                case 2:
                    student.eng = score;
                    break;
                case 3:
                    student.math = score;
                    break;
                default:
                    break;
            }
        }
    }

    private void delete() {
        if (list.isEmpty()) {
            System.out.println("삭제할 사람이 없습니다.");
            return;
        }
        System.out.print("삭제할 사람의 이름: ");
        String name = sc.nextLine().trim();
        List<Student> tobeRemoved = new ArrayList<Student>();
        for (Student student : list) {
            if (student.name.equals(name)) {
                tobeRemoved.add(student);
            }
        }
        if (tobeRemoved.isEmpty()) {
            System.out.println("삭제할 사람이 없습니다.");
            return;
        }
        list.removeAll(tobeRemoved);
        System.out.printf("%d명 삭제되었습니다.\n", tobeRemoved.size());
    }
}