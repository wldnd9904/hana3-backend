import java.util.Arrays;

public class ex06 {
    public static void main(String[] args) {
//        String str1 = "Hello Java!";
//        String str2 = "안녕하세요! 반갑습니다.";
//        System.out.println(str1.length()); // 11
//        System.out.println(str2.length()); // 13, char 이 2byte 라서 한글이든 영어든 한 글자로 취급
//        // 문자 한 글자만 가져오기
//        for(int i=0;i<str1.length();i++)
//            System.out.println(str1.charAt(i));
//        // 문자열 인덱스 가져오기
//        System.out.println(str1.indexOf("a"));
//        System.out.println(str1.lastIndexOf("a"));
//
//        System.out.println(String.valueOf(31434.34));
//
//        // 대/소문자 변환 (문자열 검색 시 사용)
//        String str3 = "Java Study!";
//        System.out.println(str3.toUpperCase());
//        System.out.println(str3.toLowerCase());
//
//        // 문자열 치환하기
//        System.out.println(str3.replace('a', 'o')); // 싹다바뀜
//        System.out.println(str3.substring(0,4));
//        // 조개기
//        String[] strArray = "abc/def-ghi jkl".split("[/\\- ]");
//        System.out.println(Arrays.toString(strArray));
//        // 앞뒤공백 자르기
//        System.out.println("   ab c   ".trim());
//        // 대체
//        System.out.println(" a b c ".replace(" ", ""));
//        System.out.println(" a b c ".replaceAll(" ", ""));
//        // 포함여부
//        System.out.println("abc123".contains("12"));

        // 비교
//        String str4 = "java";
//        String str5 = "hava";
//        System.out.println(str4.equals(str5));

        //연습문제 DM 제출
        String str5 = "java";
        String str6 = "Web Programming is funny~";
        String str7 = "  Test Trim String  ";
        //1. "funny"의 시작 인덱스를 출력하시오.
        System.out.println(str6.indexOf("funny"));
        //2. str6를 모두 대문자로 출력하시오.
        System.out.println(str6.toUpperCase());
        //3. str6를 모두 소문자로 ~
        System.out.println(str6.toLowerCase());
        //4. str5와 str6을 concat 함수로 연결하여 출력하시오.
        System.out.println(str5.concat(str6));
        //5. str7의 시작과 끝 공백만 제거하여 출력하시오.
        System.out.println(str7.trim());
        //6. str7의 모든 공백을 *로 치환하여 출력하시오.
        System.out.println(str7.replaceAll(" ", "*"));
        //7. str6은 "web"문자열을 포함하고 있는지? (대소문자 안가림)
        //   true/false 로 출력하시오.
        System.out.println(str6.toLowerCase().contains("web"));
        //8. str6을 문자열 배열로 만들고, "Web"와 "funny~"만 출력하시오.
        String[] str6Array = str6.split(" ");
        System.out.println(str6Array[0]);
        System.out.println(str6Array[3]);


    }
}
