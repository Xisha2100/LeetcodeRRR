  //给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1455 👎 0

  
  package top.nzhz.leetcode.editor.cn;

  import java.util.ArrayDeque;
  import java.util.Deque;
  import java.util.LinkedList;

  public class NumberOfIslands{
      public static void main(String[] args) {
           Solution solution = new NumberOfIslands().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int len=grid.length,wid=grid[0].length,ans=0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wid; j++) {
                if(grid[i][j]=='1'){
//                    dfs(grid,i,j);
                    bfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void bfs(char[][] grid,int i,int j){
        Deque<int[]> list= new LinkedList<>();
        list.add(new int[]{i,j});
        while (!list.isEmpty()){
            int[] cur=list.poll();
            if(cur[0]>=0&&cur[1]>=0&&cur[0]<grid.length&&cur[1]<grid[0].length&&grid[cur[0]][cur[1]]=='1'){
                grid[cur[0]][cur[1]]='0';
                list.add(new int[]{cur[0]-1,cur[1]});
                list.add(new int[]{cur[0]+1,cur[1]});
                list.add(new int[]{cur[0],cur[1]-1});
                list.add(new int[]{cur[0],cur[1]+1});
            }
        }
    }
    private void dfs(char[][] grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0') return;
        grid[i][j]='0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }