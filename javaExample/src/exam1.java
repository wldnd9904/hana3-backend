import java.util.Arrays;

public class exam1 {
    public static void main(String[] args) {
        int[] arrayIndex1 = {2, 0, 1, 3, 4};
        int[] arrayIndex2 = {1, 2, 0, 4, 3};
        int[][] arrayNum = {
                {22, 92, 32, 42, 52},
                {23, 93, 33, 43, 53},
                {24, 94, 34, 44, 54},
                {25, 95, 35, 45, 55},
                {26, 96, 36, 46, 56},
        };
        
        //수 뽑기
        int cnt = Math.min(arrayIndex1.length, arrayIndex2.length);
        int[] selected = new int[cnt];
        for (int i = 0; i < cnt; i++)
            selected[i] = arrayNum[arrayIndex1[i]][arrayIndex2[i]];

        //뽑은 수 정렬 및 출력
        Arrays.sort(selected);
        System.out.print("뽑힌 수들의 배열: [");
        for (int i = 0; i < cnt - 1; i++)
            System.out.printf("%d, ", selected[i]);
        System.out.printf("%d]\n", selected[cnt - 1]);

        //최소값, 최대값 찾기
        //이미 정렬되었으므로 selected[0] 이 최소값, selected[cnt-1] 이 최대값이긴 함
        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
        for (int i : selected) {
            minValue = Math.min(minValue, i);
            maxValue = Math.max(maxValue, i);
        }
        System.out.println("최소값: " + minValue);
        System.out.println("최대값: " + maxValue);

        //순서 구하기
        int minRank = 1;
        int maxRank = 1;
        for (int r = 0; r < arrayNum.length; r++) {
            for (int i : arrayNum[r]) {
                if (i < minValue) minRank++;
                if (i > maxValue) maxRank++;
            }
        }
        System.out.printf("최소값 %d는 전체 수에서 %d번째로 작은 수이다.\n", minValue, minRank);
        System.out.printf("최대값 %d는 전체 수에서 %d번째로 큰 수이다.\n", maxValue, maxRank);

    }
}
