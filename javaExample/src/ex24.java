public class ex24 {
    public static void main(String[] args) {
        //2차 배열
        //1.
        int[][] arrNum1 = new int[3][3];
        //2.
        int[][] arrNum2 = new int[][]{{10, 20, 30}, {40, 50, 60,}};
        //3.
        int[][] arrNum3 = {
                {10, 20, 30},
                {40, 50, 60}
        };
        //4.
        int[][] arrNum4 = new int[2][];
        arrNum4[0] = new int[3];
        arrNum4[1] = new int[3];

        //행의 길이
        System.out.println(arrNum2.length);
        //열의 길이
        System.out.println(arrNum2[0].length);
        System.out.println(arrNum2[1].length);

        //연습문제
        //1. 2차원 정수배열 nums를 행 3개, 열 3개로 만들고,
        // 모든 행열에 값을 넣되,
        // 랜덤값 정수 1~100 사이의 값을 넣고,
        // 전체를 순환하여 출력하시오.
        int[][] nums = new int[3][3];
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums[i].length; j++)
                nums[i][j] = (int) (Math.random() * 100) + 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.printf("%3d ", nums[i][j]);
            }
            System.out.println();
        }
        //2. 최소값과 최대값을 출력하시오.
        int min = 101, max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                min = Math.min(min, nums[i][j]);
                max = Math.max(max, nums[i][j]);
            }
        }
        System.out.println("max: " + max + ", min: " + min);
        //3.
        // 순돌이네 인쇄소
        // 3x3 2차원 정수배열에 아래와 같은 숫자가 들어있다면,
        // 0 1 0       #  *  #
        // 1 2 0   =>  *  +  #
        // 1 0 0       *  #  #
        // 이렇게 출력이 된다.
        // 0 1 2
        // 1 2 0
        // 2 1 0 이렇게 들어가 있을때 출력결과를 표시하시오.
        int[][] data = {{0, 1, 2},
                {1, 2, 0},
                {2, 1, 0}};
        char[] chars = {'#', '*', '+'};

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%c ", chars[data[i][j]]);
            }
            System.out.println();
        }

    }
}
