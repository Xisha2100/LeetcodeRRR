//树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
//
// 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中
// edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。 
//
// 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度
//树 。 
//
// 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。 
//树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, edges = [[1,0],[1,2],[1,3]]
//输出：[1]
//解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。 
//
// 示例 2： 
//
// 
//输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
//输出：[3,4]
// 
//
// 
//
// 
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 10⁴ 
// edges.length == n - 1 
// 0 <= ai, bi < n 
// ai != bi 
// 所有 (ai, bi) 互不相同 
// 给定的输入 保证 是一棵树，并且 不会有重复的边 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 682 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Stream;

public class MinimumHeightTrees {
    public static void main(String[] args) {
        Solution solution = new MinimumHeightTrees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //拓扑排序，很好用
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if (n == 1) {
                return new ArrayList<>() {{
                    add(0);
                }};
            }
            if (n == 2) {
                return new ArrayList<>() {{
                    add(0);
                    add(1);
                }};
            }
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            int[] degree = new int[n];
            for (int[] edge : edges) {
                List<Integer> tempSet = map.getOrDefault(edge[0], new ArrayList<>());
                tempSet.add(edge[1]);
                map.put(edge[0], tempSet);
                tempSet = map.getOrDefault(edge[1], new ArrayList<>());
                tempSet.add(edge[0]);
                map.put(edge[1], tempSet);
                degree[edge[0]]++;
                degree[edge[1]]++;
            }
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (degree[i] == 1) {
                    queue.offer(i);
                }
            }
            while (n > 2) {
                int queueSize = queue.size();
                n -= queueSize;
                for (int i = 0; i < queueSize; i++) {
                    int cur = queue.poll();
                    for (int node : map.get(cur)) {
                        degree[node]--;
                        if (degree[node] == 1) {
                            queue.offer(node);
                        }
                    }
                }
            }
            return new ArrayList<>(queue);
        }

        //DFS方法
//        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//            if(n==1){
//                return new ArrayList<>(){{
//                    add(0);
//                }};
//            }
//            List<Integer>[] adj = new List[n];
//            for (int i = 0; i < n; i++) {
//                adj[i]=new ArrayList<>();
//            }
//            for (int[] edge : edges) {
//                adj[edge[0]].add(edge[1]);
//                adj[edge[1]].add(edge[0]);
//            }
//            int[] parent = new int[n];
//            Arrays.fill(parent,-1);
//            int x = findLongestNode(0, parent, adj);
//            int y = findLongestNode(x, parent, adj);
//            List<Integer> path = new ArrayList<>();
//            parent[x] = -1;
//            while (y != -1) {
//                path.add(y);
//                y = parent[y];
//            }
//            List<Integer> res = new ArrayList<>();
//            int m = path.size();
//            if (m % 2 == 0) {
//                res.add(path.get(m/2-1));
//            }
//            res.add(path.get(m/2));
//            return res;
//        }
//
//        private int findLongestNode(int u, int[] parent, List<Integer>[] adj) {
//            int n = adj.length;
//            int[] dist = new int[n];
//            Arrays.fill(dist, -1);
//            dist[u] = 0;
//            dfs(u, dist, parent, adj);
//            int maxDist = 0;
//            int node = -1;
//            for (int i = 0; i < n; i++) {
//                if (dist[i] > maxDist) {
//                    maxDist = dist[i];
//                    node = i;
//                }
//            }
//            return node;
//        }
//
//        private void dfs(int u, int[] dist, int[] parent, List<Integer>[] adj) {
//            for (int v : adj[u]) {
//                if (dist[v] < 0) {
//                    dist[v] = dist[u] + 1;
//                    parent[v] = u;
//                    dfs(v, dist, parent, adj);
//                }
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}