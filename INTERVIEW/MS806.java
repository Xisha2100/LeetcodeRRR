package top.nzhz;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Main().new Solution();
//        int a=solution.func("*",1);
//        System.out.println(a);
        int a = solution.func2("RWWWRRRWRWWR");
        System.out.println(a);
    }

    class Solution {
        public boolean func3(int[] A, int[] B, int S) {
            int len = A.length;
            if (len > S) {
                return false;
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < A.length; i++) {
                set.add(A[i]);
                set.add(B[i]);
            }
            int size = set.size();
            if (len > size) {
                return false;
            }
            int[][] nums = new int[S][S];
            boolean[] hasUsed = new boolean[S];
            boolean tempFlag = false;
            for (int i = 0; i < A.length; i++) {
                if (A[i] < B[i]) {
                    nums[A[i] - 1][B[i] - 1]++;
                    if (nums[A[i] - 1][B[i] - 1] == 2) {
                        tempFlag = true;
                        if (hasUsed[A[i] - 1] || hasUsed[B[i] - 1]) {
                            return false;
                        }
                        hasUsed[A[i] - 1] = true;
                        hasUsed[B[i] - 1] = true;
                    } else if (nums[A[i] - 1][B[i] - 1] == 3) {
                        return false;
                    }
                } else {
                    nums[B[i] - 1][A[i] - 1]++;
                    if (nums[B[i] - 1][A[i] - 1] == 2) {
                        tempFlag = true;
                        if (hasUsed[A[i] - 1] || hasUsed[B[i] - 1]) {
                            return false;
                        }
                        hasUsed[A[i] - 1] = true;
                        hasUsed[B[i] - 1] = true;
                    } else if (nums[B[i] - 1][A[i] - 1] == 3) {
                        return false;
                    }
                }
            }
            if (tempFlag) {
                return true;
            } else {
                for (int i = 0; i < S - 1; i++) {
                    for (int j = i + 1; j < S; j++) {
                        if (hasUsed[A[i] - 1] && hasUsed[B[i] - 1]) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        public int func2(String S) {
            int left = S.indexOf('R');
            int right = S.lastIndexOf('R');
            if (right - left <= 1) {
                return 0;
            }
            LinkedList<Integer> leftList = new LinkedList<>();
            LinkedList<Integer> rightList = new LinkedList<>();

            for (int i = left + 1; i < right; i++) {
                if (S.charAt(i) == 'W') {
                    leftList.offerLast(i - left);
                    rightList.offerLast(right - i);
                }
            }
            int res = 0, leftCnt = 0, rightCnt = 0;

            while (!leftList.isEmpty() && !rightList.isEmpty()) {
                if ((leftList.peekFirst() - leftCnt) < (rightList.peekLast() - rightCnt)) {
                    res += leftList.pollFirst() - leftCnt;
                    rightList.pollFirst();
                    leftCnt++;
                } else {
                    res += rightList.pollLast() - rightCnt;
                    leftList.pollLast();
                    rightCnt++;
                }
                if (res > 1000000000) return -1;
            }
            return res;
        }

        public int func(String S, int B) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            int cnt = 0;
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == '.') {
                    if (cnt != 0) {
                        queue.offer(cnt);
                    }
                    cnt = 0;
                } else {
                    cnt++;
                }
            }
            if (cnt != 0) {
                queue.offer(cnt);
            }
            int res = 0;
            while (!queue.isEmpty() && B > 0) {
                int temp = queue.poll();
                if (temp >= B) {
                    res += B - 1;
                    break;
                } else {
                    res += temp;
                    B = B - temp - 1;
                }
            }
            return res;
        }
    }

}
