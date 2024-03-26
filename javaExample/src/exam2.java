import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Book {
    private String name;
    private String publisher;
    private int price;
    private LocalDate pubDate;

    public String getName() {
        return this.name;
    }

    public LocalDate getPubDate() {
        return this.pubDate;
    }

    public Book(String name, String publisher, int price, LocalDate pubDate) {
        this.name = name;
        this.publisher = publisher;
        this.price = price;
        this.pubDate = pubDate;
    }

    public String toString() {
        int year = pubDate.getYear();
        int month = pubDate.getMonthValue();
        int day = pubDate.getDayOfMonth();
        String priceString = String.valueOf(price);
        return String.format("%s/%s/%d년%d월%d일/%s", name, publisher, year, month, day, priceString);
    }

}

class BookManager {
    ArrayList<Book> list;
    Scanner scanner;

    public BookManager(Scanner scanner) {
        this.list = new ArrayList<>();
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            switch (prompt()) {
                case 1:
                    add();
                    break;
                case 2:
                    printAll();
                    break;
                case 3:
                    sort();
                    break;
                case 4:
                    edit();
                    break;
                default:
                    continue;
            }
        }
    }

    private int prompt() {
        System.out.println("--------- 도서 재고 관리 프로그램 ---------");
        System.out.print("1.입력 2.전체출력 3.검색 4.수정: ");
        int ret;
        while (true) {
            try {
                ret = scanner.nextInt();
                scanner.nextLine();
                if (ret < 1 || ret > 4) throw new Exception();
            } catch (Exception e) {
                System.out.print("다시 입력해주세요: ");
                scanner.nextLine();
                return 0;
            }
            break;
        }
        return ret;
    }

    private void add() {
        try {
            System.out.print("책이름 입력: ");
            String name = scanner.next().trim();
            scanner.nextLine();
            System.out.print("출판사 입력: ");
            String publisher = scanner.next().trim();
            scanner.nextLine();
            System.out.print("출판일 입력: ");
            LocalDate date = LocalDate.parse(scanner.next().trim());
            System.out.print("가격 입력: ");
            int price = scanner.nextInt();
            scanner.nextLine();
            list.add(new Book(name, publisher, price, date));
            System.out.println("도서가 입고되었습니다.");
            System.out.printf("총 도서의 수는 %d권 입니다.\n", list.size());
        } catch (Exception e) {
            System.out.println("입력 중 오류가 발생했습니다.");
        }
    }

    private void printAll() {
        for (Book book : list) {
            System.out.println(book);
        }
        System.out.printf("총 도서의 수는 %d권 입니다.\n", list.size());
    }

    private void sort() {
        ArrayList<Book> sorted = new ArrayList<>();
        for (Book book : list)
            sorted.add(book);

        System.out.println("책이름 가나다순(1) 출판일 최근순(2)");
        try {
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 1:
                    sorted.sort(Comparator.comparing(Book::getName));
                    break;
                case 2:
                    sorted.sort(Comparator.comparing(Book::getPubDate));
                    break;
                default:
                    throw new Exception();
            }
            for (int i = 0; i < sorted.size(); i++) {
                System.out.println(i + 1 + ": " + sorted.get(i));
            }
        } catch (Exception e) {
            System.out.println("입력 중 오류가 발생했습니다.");
        }
    }

    private void edit() {
        try {
            System.out.print("수정할 책이름 입력: ");
            String name = scanner.next().trim();
            scanner.nextLine();
            System.out.print("출판사 입력: ");
            String publisher = scanner.next().trim();
            scanner.nextLine();
            System.out.print("출판일 입력: ");
            LocalDate date = LocalDate.parse(scanner.next().trim());
            System.out.print("가격 입력: ");
            int price = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().equals(name)) {
                    list.set(i, new Book(name, publisher, price, date));
                    System.out.println("도서정보가 수정되었습니다.");
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("입력 중 오류가 발생했습니다.");
        }
    }
}


public class exam2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager program = new BookManager(scanner);
        program.run();
    }
}
