package m1706;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/3 17:40
 * @Description:
 **/
public class M1706 {

    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        for (int i = 0; i < grid.length; i++) {
            int[] tempRow = grid[i];
            for (int j = 0; j < result.length; j++) {
                if (result[j] == -1) {
                    continue;
                }
                if (tempRow[result[j]] > 0) {
                    if (result[j] == tempRow.length - 1 || tempRow[result[j] + 1] < 0) {
                        result[j] = -1;
                    } else {
                        result[j] += 1;
                    }
                } else {
                    if (result[j] == 0 || tempRow[result[j] - 1] > 0) {
                        result[j] = -1;
                    } else {
                        result[j] -= 1;
                    }
                }
            }
        }
        return result;
    }

}
