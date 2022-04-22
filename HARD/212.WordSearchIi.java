//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 10⁴ 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 数组 字符串 回溯 矩阵 👍 644 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new WordSearchIi().new Solution();
//        solution.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"});
        solution.findWords(new char[][]{{'a', 'b'}}, new String[]{"ba"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Tire {
            String word;
            boolean isEnd = false;
            Tire[] children;
            int childrenNum = 0;

            public Tire() {
                word = "";
                children = new Tire[26];
            }

            public void insert(String word) {
                Tire cur = this;
                for (int i = 0; i < word.length(); i++) {
                    if (cur.children[word.charAt(i) - 'a'] == null) {
                        cur.children[word.charAt(i) - 'a'] = new Tire();
                        cur.childrenNum++;
                    }
                    cur = cur.children[word.charAt(i) - 'a'];
                }
                cur.isEnd = true;
                cur.word = word;
            }
        }

        private List<String> res;
        private boolean[][] isAccessed;

        public List<String> findWords(char[][] board, String[] words) {
            Tire root = new Tire();
            for (String word : words) {
                root.insert(word);
            }
            res = new ArrayList<>();
            isAccessed = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (root.children[board[i][j] - 'a'] != null)
                        dfs(board, root, i, j);
                }
            }

            return res;
        }

        private void dfs(char[][] board, Tire root, int x, int y) {
            Tire cur = root.children[board[x][y] - 'a'];
            if (cur.isEnd) {
                res.add(cur.word);
                cur.isEnd = false;
                if (cur.childrenNum == 0) {
                    root.children[board[x][y] - 'a'] = null;
                    root.childrenNum--;
                    return;
                }
            } else {
                if (cur.childrenNum == 0) {
                    root.children[board[x][y] - 'a'] = null;
                    root.childrenNum--;
                    return;
                }
            }

            isAccessed[x][y] = true;

            if (x > 0 && !isAccessed[x - 1][y] && cur.children[board[x - 1][y] - 'a'] != null)
                dfs(board, cur, x - 1, y);
            if (y > 0 && !isAccessed[x][y - 1] && cur.children[board[x][y - 1] - 'a'] != null)
                dfs(board, cur, x, y - 1);
            if (x < board.length - 1 && !isAccessed[x + 1][y] && cur.children[board[x + 1][y] - 'a'] != null)
                dfs(board, cur, x + 1, y);
            if (y < board[0].length - 1 && !isAccessed[x][y + 1] && cur.children[board[x][y + 1] - 'a'] != null)
                dfs(board, cur, x, y + 1);

            isAccessed[x][y] = false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}