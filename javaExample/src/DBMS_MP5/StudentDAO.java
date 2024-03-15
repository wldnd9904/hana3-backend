package DBMS_MP5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    //데이터베이스 접속 객체
    Connection conn = null;
    //SQL 쿼리를 구현하는 객체
    Statement stmt = null;
    //쿼리에 대한 응답인 ResultSet을 가져오는 객체
    ResultSet rs = null;

    public StudentDAO() {
        try {
            //MySQL 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            //데이터베이스 접속
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", //Host
                    "root", //사용자
                    "-------" //암호
            );
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.close();
            } catch (Exception ex) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            System.out.println("데이터베이스 접속 성공!!");
        }
    }

    public int insert(StudentVO vo) {
        int result = 0;
        try {
            String sql = String.format("INSERT INTO student(name, kor, eng, math) VALUES (%s)", vo);
            stmt = conn.createStatement();
            //정상수행되면 1을 리턴함.
            result = stmt.executeUpdate(sql); //쿼리 수행!
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ;
        }
        return result;
    }

    public StudentVO selectOne(String studentName) {
        StudentVO vo = null;

        try {
            String sql = String.format("SELECT * FROM student WHERE name='%s'", studentName);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                final int id = rs.getInt("id");
                final String name = rs.getString("name");
                final int kor = rs.getInt("kor");
                final int eng = rs.getInt("eng");
                final int math = rs.getInt("math");
                vo = new StudentVO(id, name, kor, eng, math);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }

    public int update(String name, String field, int value) {
        int result = 0;
        try {
            String sql = String.format("UPDATE student SET %s=%d WHERE name='%s'", field, value, name);
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(String name) {
        int result = 0;
        try {
            String sql = String.format("DELETE FROM student WHERE name='%s'", name);
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<StudentVO> list() {
        List<StudentVO> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM student";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                final int id = rs.getInt("id");
                final String name = rs.getString("name");
                final int kor = rs.getInt("kor");
                final int eng = rs.getInt("eng");
                final int math = rs.getInt("math");
                StudentVO vo = new StudentVO(id, name, kor, eng, math);
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}