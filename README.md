# LeetcodeRRR
Leetcode recording. Rush Rush Rush

|      内容       |            题号            |
| :-------------: | :------------------------: |
|      哈希       |         1、17、49          |
|     双指针      | 26、27、11、15、19、31、42、75 |
|   KMP SUNDAY    |             28             |
|    动态规划     | 70、10、21、32、42、55、64、72、96 |
|      回溯（递归）      |         17、21、39、 78、79、94         |
| 深度优先搜索dfs |           21、46、94、 101           |
|      分治       |             23             |
|       栈        |           32、42、84、85、101           |
|      二分       |           33、34           |
|      数学       |             62、96             |
|     滑动窗口     |    76  |
|   中序遍历    | 94、98    |

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

- 39：回溯递归， 深度优先搜索，注意 **在JAVA编程思想中，不建议使用Stack，用LinkedList或者ArrayDEque替代更好**。

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

- 79：回溯，一开始用HashSet很慢，改成BOOL数组就好了

- 84：单调栈，注意宽度。计算头部的0是为了不用判断栈是否为空, 因为题目中都是非负整数, 所以没有数会比0小, 即0一直会在栈底。尾部的0是为了压出最后已经形成的单调栈的。**在一维数组中对每一个数找到第一个比自己小的元素。这类“在一维数组中找第一个满足某种条件的数”的场景就是典型的单调栈应用场景。**

- 85：太巧妙了，用84的方法

- 94：中序遍历，简单但经典

- 96：动态规划，找规律题

- 98：利用98的颜色标记法，很好理解，但性能较差。
```python
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        WHITE, GRAY = 0, 1
        res = []
        stack = [(WHITE, root)]
        while stack:
            color, node = stack.pop()
            if node is None: continue
            if color == WHITE:
                stack.append((WHITE, node.right))
                stack.append((GRAY, node))
                stack.append((WHITE, node.left))
            else:
                res.append(node.val)
        return res
```
  
- 101：**注意ArrayDeque 不接受空元素null ，如果有空请使用LinkedList**
  
  
  focus on 100hot

