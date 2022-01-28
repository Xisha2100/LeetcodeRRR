//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 231 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.List;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int[] reversePrint(ListNode head) {
            int len=0;
            ListNode cur =head;
            while (cur!=null){
                len++;
                cur=cur.next;
            }
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                res[len-1-i]= head.val;
                head=head.next;
            }
            return res;
        }
//    public int[] reversePrint(ListNode head)
//   {
//        if(head==null) return new int[0];
//        int len=0;
//        ListNode pre = null;
//        while (head.next!=null){
//            ListNode temp=head;
//            head=head.next;
//            temp.next=pre;
//            pre=temp;
//            len++;
//        }
//        head.next=pre;
//        int[] res = new int[len+1];
//        for (int i = 0; i < len+1; i++) {
//            res[i]=head.val;
//            head=head.next;
//        }
//        return res;
//    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}