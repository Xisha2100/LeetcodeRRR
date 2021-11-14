//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 1593 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
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

public class MergeKSortedLists {
    public static void main(String[] args) {

        Solution solution = new MergeKSortedLists().new Solution();

        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));

        //solution.mergeKLists(lists);
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        //优先队列
        public ListNode mergeKListsPriorityQueue(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    if (o1.val < o2.val) {
                        return -1;
                    } else if (o1.val == o2.val) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
            ListNode head = new ListNode(0);
            ListNode temp = head;
            for(ListNode node:lists){
                if(node!=null){
                    queue.add(node);
                }
            }
            while (!queue.isEmpty()){
                temp.next= queue.poll();
                temp=temp.next;
                if(temp.next!=null) queue.add(temp.next);
            }
            return head.next;
        }
//        //方法3，木桶 节省内存
//        public ListNode mergeKListsKit(ListNode[] lists) {
//            ListNode dump = new ListNode();
//            if (lists.length == 0) {
//                return null;
//            }
//            if (lists.length == 1) {
//                return lists[0];
//            }
//            int[] keyArr = new int[2 * 10000 + 1];
//            for (int i = 0; i < lists.length; i++) {
//                ListNode cur = lists[i];
//                while (cur != null) {
//                    keyArr[cur.val + 10000]++;
//                    cur = cur.next;
//                }
//            }
//            ListNode temp = dump;
//            for (int i = 0; i < keyArr.length; i++) {
//                if (keyArr[i] == 0) {
//                    continue;
//                } else {
//                    while (keyArr[i]-- > 0) {
//                        temp.next = new ListNode(i - 10000);
//                        temp = temp.next;
//                    }
//                }
//            }
//            return dump.next;
//        }
//        方法二：分治 时间效果最好
//        public ListNode mergeKListsDivide(ListNode[] lists) {
//            return merge(lists, 0, lists.length - 1);
//        }
//
//        private ListNode merge(ListNode[] lists, int l, int r) {
//            if (l == r) {
//                return lists[l];
//            }
//            if (l > r) {
//                return null;
//            }
//            int mid = (l + r) / 2;
//            return merge2Lists(merge(lists, l, mid), merge(lists, mid + 1, r));
//        }

//        方法1：暴力
//        public ListNode mergeKListsBrute(ListNode[] lists) {
//            ListNode anslist=null;
//            for (int i = 0; i < lists.length; i++) {
//                anslist=merge2Lists(anslist,lists[i]);
//            }
//            return anslist;
//        }


        //        公用方法
        private ListNode merge2Lists(ListNode listA, ListNode listB) {
            ListNode ansList, temp;
            if (listA == null) {
                return listB;
            } else if (listB == null) {
                return listA;
            }
            if (listA.val < listB.val) {
                ansList = listA;
                temp = listA;
                listA = listA.next;
            } else {
                ansList = listB;
                temp = listB;
                listB = listB.next;
            }
            while (listA != null && listB != null) {
                if (listA.val < listB.val) {
                    temp.next = listA;
                    listA = listA.next;
                } else {
                    temp.next = listB;
                    listB = listB.next;
                }
                temp = temp.next;
            }
            if (listA == null) {
                temp.next = listB;
            } else if (listB == null) {
                temp.next = listA;
            }
            return ansList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}