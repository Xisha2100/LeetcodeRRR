package top.nzhz;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            a[i] = sc.nextInt();
        }
//        int n = 3;
//        int m = 2;
//        int[] a = new int[]{0, 1, 1, 4};
        int[] dp = new int[n + 1];
        dp[0] = m;


        for (int i = 1; i < n + 1; i++) {
            int[] temp = new int[i + 1];
            for (int j = 1; j < i; j++) {
                if (dp[j] != 0)
                    dp[j] += j * (a[i] - a[i - 1]);
            }

            for (int j = 0; j < i; j++) {
                temp[j] = Math.max(dp[j], temp[j]);
                if (dp[j] - j * a[i] >= a[i]) temp[j + 1] = Math.max(dp[j], temp[j + 1]);
                if (j > 0) temp[j - 1] = Math.max(dp[j], temp[j - 1]);
            }
            for (int j = 0; j < i + 1; j++) {
                dp[j] = temp[j];
            }
        }
        int res = 0;
        for (int i = 0; i < n + 1; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        String s = sc.nextLine();
//        long[] left = new long[n + 1];
//        long[] right = new long[n + 1];
//        for (int i = 1; i < n + 1; i++) {
//            if (s.charAt(i - 1) == '0') left[i] = i;
//            else right[i - 1] = i;
//        }
//        for (int i = 1; i < n + 1; i++) {
//            left[i] = left[i - 1] + left[i];
//            right[n - i] = right[n - i + 1] + right[n - i];
//        }
//        long min = Long.MAX_VALUE;
//        for (int i = 0; i < n + 1; i++) {
//            min = Math.min(min, Math.abs(left[i] - right[i]));
//        }
//        System.out.println(min);
//    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n= in.nextInt();
//        in.nextLine();
//        String[] strs = new String[n];
//        for (int i = 0; i < n; i++) {
//            strs[i]=in.nextLine();
//        }
//        int len=strs[0].length();
//        int[] res = new int[len];
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < n; j++) {
//                res[i]=res[i]*10+strs[j].charAt(i)-'0';
//            }
//        }
//        Arrays.sort(res);
//        for (int i = 0; i < len; i++) {
//            System.out.print(res[i]);
//            System.out.print(' ');
//        }
//
//    }

}

package top.nzhz;

        import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a int整型一维数组
     * @return int整型
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.getNumber(new int[]{1,2,3,4});
    }
    public ListNode solve (ListNode[] a) {
        // write code here
        HashMap<Integer,ListNode> map = new HashMap();
        ListNode root=a[0];
        int min=Integer.MAX_VALUE;
        for(ListNode node:a){
            while (node!=null){
                min=Math.min(node.val,min);
                map.put(node.val,node);
                node=node.next;
            }
        }

        for (ListNode node:a){
            while (node.next!=null){
                ListNode temp=map.get(node.val);
                ListNode tempNext=map.get(node.next.val);
                temp.next=tempNext;
                node=node.next;
            }
        }

        return map.get(min);
    }
    public int getNumber (int[] a) {
        // write code here
        int len=a.length;
        boolean[] isPrime = new boolean[len+1];
        isPrime[1]=true;
        for (int i = 2; i < len+1; i++) {
            if(!isPrime[i]){
                int n=2;
                while (n*i<len+1){
                    isPrime[n*i]=true;
                    n++;
                }
            }
        }
        int[] nums = new int[len+1];
        for (int i = 0; i < len+1; i++) {
            nums[i]=i;
        }
        int leftNum=len;
        while (leftNum>1){
            int cnt=0;
            for (int i = 1; i < len+1; i++) {
                if(isPrime[nums[i]]){
                    nums[i]=0;
                    leftNum--;
                    cnt++;
                }else {
                    if(nums[i]!=0)
                        nums[i]=nums[i]-cnt;
                }
            }
        }
        for (int i = 0; i < len+1; i++) {
            if(nums[i]==1) return a[i-1];
        }
        return 1;
    }
}
