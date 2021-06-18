package top.nzhz;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = null, ansTemp = null;
        int carry = 0, temp;

        temp = l1.val + l2.val;
        ans = new ListNode(temp%10);
        carry=temp/10;

        ansTemp = ans;
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0; //此处的三目运算符使用的很好。
            int n2 = l2 != null ? l2.val : 0;
            temp = n1 + n2 + carry;
            ansTemp.next = new ListNode(temp % 10);
            ansTemp = ansTemp.next;
            carry=temp/10;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }
        if(carry==1)
            ansTemp.next=new ListNode(1);
        return ans;
    }
}
