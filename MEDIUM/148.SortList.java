  //给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 链表 双指针 分治 排序 归并排序 👍 1399 👎 0

  
  package top.nzhz.leetcode.editor.cn;
  
  public class SortList{
      public static void main(String[] args) {
           Solution solution = new SortList().new Solution();
           solution.sortList(new ListNode(4,new ListNode(2,new ListNode(1,new ListNode(3,new ListNode(5))))));
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

    public ListNode sortList(ListNode head) {
        ListNode dummy=new ListNode(0, head);
        int len=0;
        while (head!=null){
            head=head.next;
            len++;
        }
        //if(len=0)return null;

        for (int i = 1; i < len; i*=2) {
            ListNode a,b;
            ListNode temphead=dummy;
            ListNode cur = dummy.next;
            while (cur!=null){

                a=cur;
                for (int sublen=1;sublen<i&&cur.next!=null;sublen++){
                    cur=cur.next;
                }
                b=cur.next;
                cur.next=null;
                cur=b;

                for (int sublen=1;sublen<i&&cur!=null&&cur.next!=null;sublen++){
                    cur=cur.next;

                }
                ListNode next=null;
                if(cur!=null){
                    next=cur.next;
                    cur.next=null;
                }
                ListNode merged = mergeList(a,b);
                temphead.next=merged;
                while (temphead.next!=null){
                    temphead=temphead.next;
                }
                cur=next;
            }

        }
        return dummy.next;
    }

    private ListNode mergeList(ListNode l1,ListNode l2){
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeList(l1, l2.next);
            return l2;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }