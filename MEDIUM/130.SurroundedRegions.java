//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 771 👎 0

  
  package top.nzhz.leetcode.editor.cn;
  public class SurroundedRegions{
      public static void main(String[] args) {
           Solution solution = new SurroundedRegions().new Solution();
           solution.solve(new char[][]{{'O'}});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {
        int len=board.length,wid=board[0].length;
        boolean[][] isChecked = new boolean[len][wid];
        for (int i = 0; i < len; i++) {
            if(!isChecked[i][0]&&board[i][0]=='O')
                dfs(board,isChecked,i,0);
            if(!isChecked[i][wid-1]&&board[i][wid-1]=='O')
                dfs(board,isChecked,i,wid-1);
        }
        for (int i = 0; i < wid; i++) {
            if(!isChecked[0][i]&&board[0][i]=='O')
                dfs(board,isChecked,0,i);
            if(!isChecked[len-1][i]&&board[len-1][i]=='O')
                dfs(board,isChecked,len-1,i);
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < wid; j++) {
                if(!isChecked[i][j]) board[i][j]='X';
            }
        }
    }

    private void dfs(char[][] board,boolean[][] isChecked,int x,int y){
        isChecked[x][y]=true;
        if(x>0&&!isChecked[x-1][y]&&board[x-1][y]=='O') dfs(board,isChecked,x-1,y);
        if(x<board.length-1&&!isChecked[x+1][y]&&board[x+1][y]=='O') dfs(board,isChecked,x+1,y);
        if(y>0&&!isChecked[x][y-1]&&board[x][y-1]=='O') dfs(board,isChecked,x,y-1);
        if(y<board[0].length-1&&!isChecked[x][y+1]&&board[x][y+1]=='O') dfs(board,isChecked,x,y+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }