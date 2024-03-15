package DBMS_MP5;

public class StudentVO {
    private int id;
    private final String name;
    private final int kor;
    private final int eng;
    private final int math;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMath() {
        return math;
    }

    public StudentVO(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = Math.max(0, Math.min(kor, 100));
        this.eng = Math.max(0, Math.min(eng, 100));
        this.math = Math.max(0, Math.min(math, 100));
    }

    public StudentVO(Integer id, String name, int kor, int eng, int math) {
        this.id = id;
        this.name = name;
        this.kor = Math.max(0, Math.min(kor, 100));
        this.eng = Math.max(0, Math.min(eng, 100));
        this.math = Math.max(0, Math.min(math, 100));
    }

    public String toDetailString() {
        final int sum = this.kor + this.eng + this.math;
        final double avg = (double) sum / 3;
        return String.format("ID: %d, 이름: %s, 국어: %d, 영어: %d, 수학: %d, 총점: %d, 평균: %.1f", id, name, kor, eng, math, sum, avg);
    }

    public String toString() {
        return String.format("'%s', %d, %d, %d", name, kor, eng, math);
    }
}
