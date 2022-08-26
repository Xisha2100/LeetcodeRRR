package top.nzhz;


import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Main().new Solution();
        System.out.println(-1 % 2);
//        int res = solution.solution("abcasdfasdfgasfgdafgzxcfasdtkjsahfjklhasdjkfhajklshfjklashjkfhjkshjkasdhjkfbjajmsndbgnm");
//        System.out.println(res);
    }

    class Solution {
        public int solution(int[] A, int[] B) {
            // write your code in Java 8 (Java SE 8)
            int len = A.length;
            boolean[] flag = new boolean[len + 1];

            for (int i = 0; i < A.length; i++) {
                if (A[i] == B[i]) {
                    if (A[i] <= len) {
                        flag[A[i] - 1] = true;
                    }
                }
            }
            for (int i = 0; i < len + 1; i++) {
                if (!flag[i]) {
                    return i + 1;
                }
            }
            return 0;
        }

    }
//    class Solution {
//        public int solution(int[] A, int M) {
//            // write your code in Java 8 (Java SE 8)
//            HashMap<Integer, Integer> map = new HashMap<>();
//            for (int i = 0; i < A.length; i++) {
//                int temp = A[i] % M;
//                if (temp < 0) {
//                    temp += M;
//                }
//                map.put(temp, map.getOrDefault(temp, 0) + 1);
//            }
//            int res=1;
//            for (int num:map.values()){
//                res=Math.max(res,num);
//            }
//
//            return res;
//        }
//    }

//    class Solution {
//        public int solution(String S) {
//            // write your code in Java 8 (Java SE 8)
//            int len = S.length();
//            int[] nums = new int[26];
//            for (int i = 0; i < len; i++) {
//                nums[S.charAt(i) - 'a']++;
//            }
//            int letterNum = 0;
//            for (int i = 0; i < 26; i++) {
//                if (nums[i] > 1) {
//                    letterNum++;
//                }
//            }
//            int res = 0;
//            for (int i = 1; i <= letterNum; i++) {
//                int cnt = 0;
//                int evenCnt = i;
//                int left = 0;
//                int right = 0;
//                int[] tempNums = new int[26];
//                while (right < len) {
//                    while (cnt <= i && right < len) {
//                        if (nums[S.charAt(right) - 'a'] == 1) {
//                            right++;
//                            left = right;
//                            cnt = 0;
//                            evenCnt = i;
//                            break;
//                        }
//                        if (tempNums[S.charAt(right) - 'a'] == 0) {
//                            cnt++;
//                            evenCnt--;
//                        } else if (tempNums[S.charAt(right) - 'a'] % 2 == 0) {
//                            evenCnt--;
//                        } else {
//                            evenCnt++;
//                            if (cnt == i && evenCnt == i) {
//                                res = Math.max(right - left + 1, res);
//                            }
//                        }
//                        tempNums[S.charAt(right) - 'a']++;
//                        if (nums[S.charAt(right) - 'a'] % 2 == 1 && tempNums[S.charAt(right) - 'a'] == nums[S.charAt(right) - 'a']) {
//                            while (S.charAt(left) != S.charAt(right)) {
//                                if (tempNums[S.charAt(left) - 'a'] == 1) {
//                                    cnt--;
//                                    evenCnt++;
//                                } else if (tempNums[S.charAt(left) - 'a'] % 2 == 1) {
//                                    evenCnt++;
//                                } else {
//                                    evenCnt--;
//                                }
//                                tempNums[S.charAt(left) - 'a']--;
//                                left++;
//                            }
//                        }
//                        right++;
//                    }
//                    while (cnt > i && left < right) {
//                        if (tempNums[S.charAt(left) - 'a'] == 1) {
//                            cnt--;
//                            evenCnt++;
//                        } else if (tempNums[S.charAt(left) - 'a'] % 2 == 1) {
//                            evenCnt++;
//                        } else {
//                            evenCnt--;
//                        }
//                        tempNums[S.charAt(left) - 'a']--;
//                        left++;
//                    }
//                }
//            }
//            return res;
//        }
//    }
}

