import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class ex65 {
    public static void main(String[] args) {
        //날짜관련 클래스
        //Date => LocalDate, LocalTime, LocalDateTime
        //JDK 1.8이상
        //LocalDate : 날짜
        //LocalTime: 시간
        //LocalDateTime : 날짜 시간
        LocalDate now = LocalDate.now();
        LocalDate birthDay = LocalDate.of(1999, 4, 28);
        LocalDate xMas = LocalDate.parse("2024-02-25");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate childrenDay = LocalDate.parse("2024/05/05", df);
        System.out.println(now);
        System.out.println(birthDay);
        System.out.println(xMas);
        System.out.println(childrenDay);


        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalTime parisTime = LocalTime.now(ZoneId.of("Europe/Paris"));
        LocalTime seoulTime = LocalTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(seoulTime);
        System.out.println(parisTime);

        LocalTime sleepTime = LocalTime.of(23, 30, 0);
        LocalTime getupTime = sleepTime.plusHours(8).minusMinutes(5);
        System.out.println(sleepTime + " ~ " + getupTime);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        System.out.println(dateTime.getYear());
        System.out.println(dateTime.getDayOfWeek());
        System.out.println(dateTime.getDayOfYear());
        System.out.println(dateTime.getMonthValue()); // 1부터 시작

        //클래스 필드      MySQL(MariaDB)  Oracle
        //String        varchar         varchar2
        //int long      INT             number
        //float double  DATE            date
        //Date          DATE            date
        //LocalDate     DATE            date
        //LocalDateTime DATETIME        date

        //연습문제
        LocalDate today = LocalDate.now();
        LocalDate xmas = LocalDate.parse("2024-12-25");

        System.out.println("크리스마스: " + xmas);
        System.out.println("현재 날짜: " + today);
        System.out.printf("크리스마스까지 D%d 입니다.\n", today.toEpochDay() - xmas.toEpochDay());

    }
}
