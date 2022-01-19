# LeetcodeRRR
Leetcode recording. Rush Rush Rush

|      内容       |                             题号                             |
| :-------------: | :----------------------------------------------------------: |
|      哈希       |                        1、17、49、139                        |
|     双指针      |   26、27、11、15、19、31、42、75、141、142、160、287、438    |
|   KMP SUNDAY    |                              28                              |
|    动态规划     | 70、10、21、32、42、55、64、72、96、139、152、198、221、279、300、309、312、322、337、416、494 |
|  回溯（递归）   |    17、21、39、 78、79、94、104、105、124、234、301、437     |
| 深度优先搜索dfs |          21、46、94、 101、200、207、236、337、437           |
|   广度优先bfs   |                           207、297                           |
|      分治       |                           23、148                            |
|       栈        |                32、42、84、85、101、155、394                 |
|      二分       |                         33、34、O11                          |
|      数学       |                    62、96、300、338、448                     |
|    滑动窗口     |                           76、438                            |
|    中序遍历     |                       94、98、105、538                       |
|    层序遍历     |                           102、104                           |
|    后序遍历     |                             114                              |
|       树        |              94、 98、 101、102、104、105、 114              |
|     并查集      |                           128、399                           |
|       LRU       |                             146                              |
|      链表       |                             148                              |
|      快排       |                             215                              |
|      建堆       |                           215、347                           |
|     前缀和      |                             238                              |
|      排序       |                             406                              |

## HOT100

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

- 39：回溯递归， 深度优先搜索，注意 **在JAVA编程思想中，不建议使用Stack，用LinkedList或者ArrayDeque替代更好**。

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
  
- 102：层序遍历经典

- 104：简单树遍历

- 105：观察前序和中序的规律，不断递归

- 114：对树变形的操作和后续遍历都很好用，前序遍历比较差

- 121：过于简单

- 124：递归题，找到规律

- 128：HashSet常规解法，还用了**并查集**新概念

- 136：过于简单

- 139：动态规划  

- 141：快慢指针
  
- 142：同上

- 146：**LRU非常重要**
  
- 148：链表排序，分治思想
  
- 152：动态规划，两个数组
  
- 155：实现了个栈
  
- 160：数学方法太牛了，通过双指针判断链表是否相交
  
- 169：**投票法**让人耳目一新，判断超过半数的元素
  
- 198：典型动态规划，无新意
  
- 200：岛屿问题典型，深度或广度，也可用并查集
  
- 206：反转链表两种方式

- 207：深度广度优先搜索的图论题

- 208：写了个前缀树
  
- 215：**快排、建堆** 非常重要
```java
//快排 
private void QSRand(int[] nums, int left, int right) {
    if(left>=right) return;
    int rand = (int) (Math.random() * (right - left) + left);
    swap(nums,left,rand);
    int x=nums[left];
    int i=left,j=right;
    while (i<j){
        while (nums[j]<=x&&i<j){
            j--;
        }
        swap(nums,i,j);
        while (nums[i]>=x&&i<j){
            i++;
        }
        swap(nums,i,j);
    }

    QSRand(nums,left,i-1);
    QSRand(nums,i+1,right);
}
```
- 221：找规律动态规划
- 226：简单题
- 234：虽然是简单题，但递归的解法比较妙
- 236：深度优先搜索的题，重点在于发现规律
- 238：前缀和
- 239：**单调队列**
- 240：二维查找，注意判断的切入点
- 279：动态规划，其中的四数定理非常神奇，但是用处不大。
- 283：简单题
- 287：快慢指针、桶查找
- 297：广度优先搜索
- 300：动态规划，和数学优化，
- 301：典型回溯题、注意多做几遍
- 309：动态规划，**股票问题**
- 312：戳气球，从底向上反向思考
- 322：动态规划
- 337：小偷题，分析具体动态规划递推关系
- 338：数学问题找规律
- 347：用堆排序
- 394：字符串题，栈的思想很好解决
- 399：带权并查集 **非常经典**
- 406：排序问题，找到插入逻辑
- 416：动态规划，背包问题
- 437：一个dfs 和递归问题
- 438：滑动窗口双指针
- 448：简单题
- 461：简单题
- 494：**典型0-1背包问题**，需要转换思路
- 538：反中序遍历
- 543：简单的树，求高度





## 剑指OFFER2

- O09：两个栈实现队列，简单而经典

- O10：注意不要死递归即可

- O03：桶排，可以用快慢指针

- O04：和240一样

- O10：斐波那契数列

- O11：二分查找

  


focus on 100hot

