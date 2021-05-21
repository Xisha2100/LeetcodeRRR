package top.nzhz;

//Definition for singly-linked list.
//public class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        if (head == null)
            return head;

        while (temp.next != null) {
            if (temp.val == temp.next.val)
                temp.next = temp.next.next;
            else
                temp = temp.next;

        }
        return head;
    }
}

