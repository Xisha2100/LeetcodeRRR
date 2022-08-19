package top.nzhz;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Main().new Solution();
        solution.solution(new int[]{0, 1, 1}, new int[]{1, 2, 3});
        System.out.println();
    }
//
//    class Solution {
//        public int solution(int[] X, int[] Y, int W) {
//            // write your code in Java 8 (Java SE 8)
//            Arrays.sort(X);
//            int cnt=1;
//            int pre=X[0]+W;
//            for (int i = 1; i < X.length; i++) {
//                if(X[i]>pre){
//                    cnt++;
//                    pre=X[i]+W;
//                }
//            }
//            return cnt;
//        }
//    }

    //    class Solution {
//        public String solution(String S) {
//            // write your code in Java 8 (Java SE 8)
//            int[] cnts = new int[10];
//            for (int i = 0; i < S.length(); i++) {
//                cnts[S.charAt(i) - '0']++;
//            }
//            StringBuilder res = new StringBuilder();
//            int loc = 0;
//            int mid = 0;
//            for (int i = 9; i >= 1; i--) {
//                int cnt = cnts[i] / 2;
//                for (int j = 0; j < cnt; j++) {
//                    res.insert(loc, i);
//                    res.insert(loc, i);
//                    loc++;
//                }
//                if (mid == 0 && cnts[i] % 2 == 1) {
//                    mid = i;
//                }
//            }
//            if (loc == 0) {
//                res.append(mid);
//            } else {
//                int cnt = cnts[0] / 2;
//                for (int j = 0; j < cnt; j++) {
//                    res.insert(loc, 0);
//                    res.insert(loc, 0);
//                    loc++;
//                }
//                if(mid!=0){
//                    res.insert(loc,mid);
//                } else if (cnts[0] % 2 == 1) {
//                    res.insert(loc,0);
//                }
//            }
//            return res.toString();
//        }
//    }
    class Solution {
        private boolean isAccessed[];
        private HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        private int cost = 0;


        public int solution(int[] A, int[] B) {
            // write your code in Java 8 (Java SE 8)
            for (int i = 0; i < A.length; i++) {
                if (!map.containsKey(A[i])) {
                    map.put(A[i], new ArrayList<>());
                }
                map.get(A[i]).add(B[i]);
                if (!map.containsKey(B[i])) {
                    map.put(B[i], new ArrayList<>());
                }
                map.get(B[i]).add(A[i]);
            }
            isAccessed = new boolean[map.size()];
            dfs(0);
            return cost;
        }

        private int dfs(int node) {
            isAccessed[node] = true;
            int sum = 1;
            for (int child : map.get(node)) {
                if (!isAccessed[child]) {
                    int num = dfs(child);
                    cost += (num - 1) / 5 + 1;
                    sum += num;
                }
            }
            return sum;
        }
    }
}

