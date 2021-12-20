//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 1205 👎 0

  
package top.nzhz.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        solution.isPalindrome(new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1)))));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head,slow=head;
        Deque<Integer> stack=new LinkedList<>();
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            stack.push(slow.val);
            slow=slow.next;
        }
        if(fast!=null){
            slow=slow.next;
        }
        while (slow!=null){
            if(stack.pop()!=slow.val)
                return false;
            slow=slow.next;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}