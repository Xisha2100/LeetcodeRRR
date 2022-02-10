//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数
//值排序之后中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例 1： 
//
// 输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
// 
//
// 示例 2： 
//
// 输入：
//["MedianFinder","addNum","findMedian","addNum","findMedian"]
//[[],[2],[],[3],[]]
//输出：[null,null,2.00000,null,2.50000] 
//
// 
//
// 限制： 
//
// 
// 最多会对 addNum、findMedian 进行 50000 次调用。 
// 
//
// 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-
//stream/ 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 242 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ShuJuLiuZhongDeZhongWeiShuLcof {
    public static void main(String[] args) {
        Solution solution = new ShuJuLiuZhongDeZhongWeiShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

        /**
         * initialize your data structure here.
         */

        PriorityQueue<Integer> bigQueue;
        PriorityQueue<Integer> smallQueue;
        int count;
        public MedianFinder() {
            bigQueue = new PriorityQueue<>(Comparator.naturalOrder());
            smallQueue = new PriorityQueue<>(Comparator.reverseOrder());
            count=0;
        }

        public void addNum(int num) {
            if(count==0){
                bigQueue.add(num);
            }
            else {
                if(count%2==1){
                    if(num>=bigQueue.peek()) {
                        int temp=bigQueue.poll();
                        bigQueue.add(num);
                        smallQueue.add(temp);
                    }else {
                        smallQueue.add(num);
                    }
                }else {
                    if (num>=bigQueue.peek()){
                        bigQueue.add(num);
                    }else {
                        smallQueue.add(num);
                        int temp=smallQueue.poll();
                        bigQueue.add(temp);
                    }
                }
            }
            count++;
        }

        public double findMedian() {
            if(count%2==1) return (double)bigQueue.peek();
            else return (bigQueue.peek()+smallQueue.peek())/2.0;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}