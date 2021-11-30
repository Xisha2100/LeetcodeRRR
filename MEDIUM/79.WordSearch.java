//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
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
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1097 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.HashSet;

public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        char[][] board = new char[][]{
                {'a', 'a', 'b', 'a', 'a', 'b'},
                {'a', 'a', 'b', 'b', 'b', 'a'},
                {'a', 'a', 'a', 'a', 'b', 'a'},
                {'b', 'a', 'b', 'b', 'a', 'b'},
                {'a', 'b', 'b', 'a', 'b', 'a'},
                {'b', 'a', 'a', 'a', 'a', 'b'}
        };
        solution.exist(board, "bbbaabbbbbab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[][] board;
        boolean[][] visited;

        public boolean exist(char[][] board, String word) {
            this.board = board;
            this.visited = new boolean[board.length][board[0].length];

            if (word.length() > board.length * board[0].length) return false;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        visited[i][j] = true;
                        if (itrExit(word, 1, i, j)) return true;
                        visited[i][j] = false;
                    }
                }
            }
            return false;
        }

        private boolean itrExit(String word, int order, int x, int y) {
            if (order == word.length()) return true;

            if (x < board.length - 1 && !visited[x + 1][y] && word.charAt(order) == board[x + 1][y]) {
                visited[x + 1][y] = true;
                if (itrExit(word, order + 1, x + 1, y)) return true;
                visited[x + 1][y] = false;
            }

            if (x > 0 && !visited[x - 1][y] && word.charAt(order) == board[x - 1][y]) {
                visited[x - 1][y] = true;
                if (itrExit(word, order + 1, x - 1, y)) return true;
                visited[x - 1][y] = false;
            }

            if (y < board[0].length - 1 && !visited[x][y + 1] && word.charAt(order) == board[x][y + 1]) {
                visited[x][y + 1] = true;
                if (itrExit(word, order + 1, x, y + 1)) return true;
                visited[x][y + 1] = false;
            }

            if (y > 0 && !visited[x][y - 1] && word.charAt(order) == board[x][y - 1]) {
                visited[x][y - 1] = true;
                if (itrExit(word, order + 1, x, y - 1)) return true;
                visited[x][y - 1] = false;
            }

            return false;
        }

//        暴力求解回溯
//        private HashSet<Integer> set = new HashSet<>();
//
//        public boolean exist(char[][] board, String word) {
//            if (word.length() > board.length * board[0].length) return false;
//
//            for (int i = 0; i < board.length; i++) {
//                for (int j = 0; j < board[0].length; j++) {
//                    if (board[i][j] == word.charAt(0)) {
//                        set.add(i * 11 + j);
//                        if (itrExit(board, word, 1, i, j)) return true;
//                        set.remove(i * 11 + j);
//                    }
//                }
//            }
//            return false;
//        }
//
//        private boolean itrExit(char[][] board, String word, int order, int x, int y) {
//            if (order == word.length()) return true;
//
//            if (x < board.length - 1 && !set.contains((x + 1) * 11 + y) && word.charAt(order) == board[x + 1][y]) {
//                set.add((x + 1) * 11 + y);
//                if (itrExit(board, word, order + 1, x + 1, y)) return true;
//                set.remove((x + 1) * 11 + y);
//            }
//
//            if (x > 0 && !set.contains((x - 1) * 11 + y) && word.charAt(order) == board[x - 1][y]) {
//                set.add((x - 1) * 11 + y);
//                if (itrExit(board, word, order + 1, x - 1, y)) return true;
//                set.remove((x - 1) * 11 + y);
//            }
//
//            if (y < board[0].length - 1 && !set.contains(x * 11 + y + 1) && word.charAt(order) == board[x][y + 1]) {
//                set.add(x * 11 + y + 1);
//                if (itrExit(board, word, order + 1, x, y + 1)) return true;
//                set.remove(x * 11 + y + 1);
//            }
//
//            if (y > 0 && !set.contains(x * 11 + y - 1) && word.charAt(order) == board[x][y - 1]) {
//                set.add(x * 11 + y - 1);
//                if (itrExit(board, word, order + 1, x, y - 1)) return true;
//                set.remove(x * 11 + y - 1);
//            }
//
//            return false;
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}