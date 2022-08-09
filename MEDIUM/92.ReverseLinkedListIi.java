//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 👍 1364 👎 0


package top.nzhz.leetcode.editor.cn;

public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == right) {
                return head;
            }
            ListNode hair = new ListNode();
            ListNode pre=head;
            hair.next = head;
            ListNode cur = hair;
            int cnt = 0;
            while (cnt < right) {
                if (cnt == left - 1) {
                    pre=cur;
                }
                cur=cur.next;
                cnt++;
            }
            reverse(pre.next,cur);
            pre.next=cur;
            return hair.next;
        }

        private void reverse(ListNode head,ListNode tail){
            ListNode cur=head.next;
            ListNode pre=head;
            while (cur!=tail){
                ListNode temp=cur.next;
                cur.next=pre;
                pre=cur;
                cur=temp;
            }
            head.next=cur.next;
            cur.next=pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}