//给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 👍 992 👎 0


package top.nzhz.leetcode.editor.cn;

public class ReorderList {
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
        solution.reorderList(new ListNode(1, new ListNode(2)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public void reorderList(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
                if (fast.next != null) {
                    fast = fast.next;
                } else {
                    break;
                }
            }
            if (slow == fast) return;
            ListNode cur = slow.next;
            ListNode pre = null;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            slow.next = null;
            ListNode A = head;
            ListNode B = fast;
            while (A != null && B != null) {
                ListNode tempB = B.next;
                B.next=A.next;
                A.next=B;
                A = B.next;
                B = tempB;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}