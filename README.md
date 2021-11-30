# LeetcodeRRR
Leetcode recording. Rush Rush Rush

|      内容       |            题号            |
| :-------------: | :------------------------: |
|      哈希       |         1、17、49          |
|     双指针      | 26、27、11、15、19、31、42、75 |
|   KMP SUNDAY    |             28             |
|    动态规划     | 70、10、21、32、42、55、64、72 |
|      回溯       |         17、21、39、 78         |
| 深度优先搜索dfs |           21、46           |
|      分治       |             23             |
|       栈        |           32、42           |
|      二分       |           33、34           |
|      数学       |             62             |
|     滑动窗口     |    76  |

- 11：有趣的双指针，装水问题

- 15：注意先双指针还是先循环

- 17：一道有趣的回溯题，注释里有一种取余方法 很有意思

- 19：简单的双指针，带链表

- 21：回溯、动态规划、深度优先搜索

- 23：分治、优先队列，注释里的木桶法很有意思

- 31：不是很严谨的双指针解法，观察规律总结

- 32：栈的解法很巧妙，动态规划的解法比较常规，但是要理清也需要花功夫

- 33：边界条件考虑清楚即可

- 34：**二分模板**

  ```java
  //[l,mid][mid+1,l]
  while (l < r) {
      mid = (l + r) >> 1;
      if (check(mid)) {
          r = mid;
      } else {
          l = mid + 1;
      }
  }
  
  //[l,mid-1][mid,r]
  while (l < r) {
      mid = (l + r + 1) >> 1;
      if (check(mid)) {
          l = mid;
      } else {
          r = mid-1;
      }
  }
  
  ```

- 39：回溯递归， 深度优先搜索，注意 **在JAVA编程思想中，不建议使用Stack，用LinkedList替代更好**。

- 42：使用栈、动态规划、双指针

- 46：典型深度优先搜索

- 48：找规律，简单

- 49：hash表的key怎么生成是关键。

- 55：动态规划，注意效率高的写法

- 56：主要注意先排序

- 62：虽然可以动态规划，但是是典型的组合题

- 64：典型动态规划

- 72：典型动态规划，但有难度，二维的
  
- 75：双指针

- 76：有趣且有难度的滑动窗口
  
- 78：回溯，前向深度遍历

  focus on 100hot

