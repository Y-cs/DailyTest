package e1380;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/2/15 9:43
 * @Description:
 **/
public class Solution {

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>(matrix.length);
        for (int[] hang : matrix) {
            int min = hang[0], minIndex = 0;
            for (int j = 1; j < hang.length; j++) {
                int lie = hang[j];
                if (min > lie) {
                    min = lie;
                    minIndex = j;
                }
            }
            int repeatIndex = list.indexOf(minIndex);
            list.add(minIndex);
            if (repeatIndex != -1) {
                if (matrix[repeatIndex][minIndex] >= hang[minIndex]) {
                    list.set(list.size()-1,-1);
                } else {
                    list.set(repeatIndex, -1);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            Integer temp = list.get(i);
            if (temp != -1) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[j][temp] > matrix[i][temp]) {
                        temp = -1;
                        break;
                    }
                }
                if (temp!=-1) {
                    result.add(matrix[i][temp]);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.luckyNumbers(new int[][]{{3,7,8},{9,11,13},{15,16,17}});
    }

}
