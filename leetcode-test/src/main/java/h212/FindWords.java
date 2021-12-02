package h212;

import java.util.List;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/16 11:03
 * @Description:
 **/
public class FindWords {

    public List<String> findWords(char[][] board, String[] words) {


        return null;
    }

    private boolean doFindWords(char[][] board, String words, int x, int y, int index) {
        if (board.length == y || board[0].length == x) {
            //越界
            return false;
        }
        if (words.length() == index) {
            return true;
        }
//        board[x][y] == words.charAt(index)
        return false;
    }


}
