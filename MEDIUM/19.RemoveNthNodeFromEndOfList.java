//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 1645 👎 0


package top.nzhz.leetcode.editor.cn;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {

        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
    }


    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode first = head, second = head;
            first = head;
            for (int i = 0; i < n; i++) {
                first = first.next;
            }
            if(first==null){
                return head.next;
            }
            else{
                first = first.next;
            }
            while (first != null) {
                first = first.next;
                second = second.next;
            }
            if (n == 1) {
                second.next = null;
            } else {
                second.next = second.next.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}