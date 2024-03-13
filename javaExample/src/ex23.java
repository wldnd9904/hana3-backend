import java.util.Arrays;
import java.util.Collections;

public class ex23 {
    public static void main(String[] args) {
        //배열 Array
        //1. 같은 타입의 데이터를 연속적 공간에 나열한 자료구조
        //2. 생성 시 크기가 지정되고 이후 변경 불가
        //3. 인덱스는 0부터
        int[] arrNum1 = new int[3];
        arrNum1[0] = 10;
        arrNum1[1] = 20;
        arrNum1[2] = 30;
        System.out.println((Arrays.toString(arrNum1)));

        int[] arrNum2 = new int[]{10, 20, 30,};
        int[] arrNnum3 = {10, 20, 30,};
        //int[] wrongArr;
        //wrongArr={1,2,3};

        //반목문을 통한 데이터 접근
        //1. 일반반복문: for while
        for (int i = 0; i < arrNum1.length; i++)
            System.out.print(arrNum1[i]);
        //2. for-each(향상된 for문)
        for (int num : arrNum1)
            System.out.print(num);


        //연습문제
        int[] nums = {10, 30, 20, 50, 40};
        //1. 배열의 모든 요소값를 출력하시오.
        System.out.println(Arrays.toString(nums));
        //2. 배열의 값 갯수를 출력하시오.
        System.out.println(nums.length);
        //3. 배열의 모든 값의 합계를 출력하시오.
        System.out.println(Arrays.stream(nums).sum());
        //4. 배열에서 20은 몇번째에 위치하는지 출력하시오.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 20) {
                System.out.printf("nums[%d]\n", i);
                break;
            }
        }
        //배열의 정렬 - 오름차순
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        Integer[] nums2 = {10, 30, 20, 50, 40};
        //내림차순
        Arrays.sort(nums2, Collections.reverseOrder());
        System.out.println(Arrays.toString(nums2));
    }
}
