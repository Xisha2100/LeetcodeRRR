//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
// Related Topics 栈 设计 👍 270 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.LinkedList;

public class BaoHanMinhanShuDeZhanLcof {
    public static void main(String[] args) {
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        /**
         * initialize your data structure here.
         */
        private LinkedList<Integer> stack1;
        private LinkedList<Integer> stack2;

        public MinStack() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void push(int x) {
            if (stack1.isEmpty() || x <= stack2.peek()) stack2.push(x);
            stack1.push(x);
        }

        public void pop() {
            if (stack1.peek().equals(stack2.peek())) stack2.pop();
            stack1.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            return stack2.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}