//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 👍 495 👎 0


package top.nzhz.leetcode.editor.cn;

public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean[][] flag;

        public boolean exist(char[][] board, String word) {
            this.flag = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board,i, j, word, 0)) return true;
                }
            }
            return false;
        }

        private boolean dfs(char[][] board,int x, int y, String word, int loc) {
            if(loc==word.length()) return true;
            if(x<0||x>=flag.length||y<0||y>=flag[0].length||flag[x][y]) return false;
            if(board[x][y]==word.charAt(loc)) {
                flag[x][y]=true;
                boolean res=dfs(board,x+1,y,word,loc+1)||dfs(board,x-1,y,word,loc+1)||dfs(board,x,y+1,word,loc+1)||dfs(board,x,y-1,word,loc+1);
                flag[x][y]=false;
                return res;
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}