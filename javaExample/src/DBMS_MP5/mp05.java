package DBMS_MP5;

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


class Program {
    static final String[] subjects = {"", "국어", "영어", "수학"};
    static final String[] engSubjects = {"", "kor", "eng", "math"};
    private Scanner sc;
    private StudentDAO dao;

    public Program(Scanner sc) {
        this.dao = new StudentDAO();
        this.sc = sc;
    }

    public void run() {
        loop:
        while (true) {
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
                    System.out.println("종료!!");
                    break loop;
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
        int result = dao.insert(new StudentVO(name, kor, eng, math));
        if (result > 0) {
            System.out.println("성공적으로 입력되었습니다.");
        } else {
            System.out.println("데이터베이스 오류로 입력에 실패했습니다.");
        }
    }

    private void print() {
        List<StudentVO> list = dao.list();
        for (StudentVO student : list) {
            System.out.println(student.toDetailString());
        }
    }

    private void find() {
        System.out.print("검색할 사람의 이름: ");
        String name = sc.nextLine().trim();
        StudentVO vo = dao.selectOne(name);
        if (vo == null) System.out.println("찾은 사람이 없습니다.");
        else System.out.println(vo.toDetailString());
    }

    private void edit() {
        System.out.print("수정할 사람의 이름: ");
        String name = sc.nextLine().trim();

        System.out.print("수정할 내용은? 1.국어 2.영어 3.수학: ");
        int input = sc.nextInt();
        sc.nextLine();
        if (input < 1 || input > 3) {
            System.out.println("입력이 잘못되었습니다.");
            return;
        }
        System.out.printf("%s점수 수정: ", subjects[input]);
        int score = Math.max(0, Math.min(sc.nextInt(), 100));
        int result = dao.update(name, engSubjects[input], score);
        if (result > 0) {
            System.out.println("성공적으로 수정되었습니다.");
        } else {
            System.out.println("데이터베이스 오류로 수정에 실패했습니다.");
        }
    }

    private void delete() {
        System.out.print("삭제할 사람의 이름: ");
        String name = sc.nextLine().trim();
        int result = dao.delete(name);
        if (result > 0) {
            System.out.printf("%d명 삭제되었습니다.\n", result);
        } else {
            System.out.println("삭제할 사람이 없습니다.");
        }
    }
}
