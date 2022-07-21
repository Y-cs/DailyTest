package m6;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/1 14:39
 * @Description:
 **/
public class M6 {

    /**
     * abcdefghijkl
     * a   e   i
     * b d f h j
     * c   g   k
     * aei bdfhjl cgh
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        char[] result = new char[chars.length];
        result[0] = chars[0];
        int ng = numRows * 2 - 2;
        int unitNum = length / ng;
        int surplus = length % ng;
        int[] rows = new int[numRows];
        rows[0] = unitNum;
        rows[numRows - 1] = unitNum;
        if (surplus > 0) {
            for (int i = 1; i <= surplus; ) {
                rows[i-1]+=1;
                if (i <= numRows) {
                    i++;
                } else {
                    i--;
                }
            }
        }
        for (int i = 0; i < rows.length; i++) {
//            rows.
        }
        for (int i = 1; i < length; i++) {
            int tempRow = i % ng;
            tempRow = tempRow > numRows ? numRows * 2 - tempRow : tempRow;

        }
        return "";
    }

}
