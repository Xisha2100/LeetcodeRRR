package top.nzhz;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int len = s.length();
        long res = len;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        char[] cnts = new char[26];
        cnts[s.charAt(0) - 'a']++;
        for (int i = 1; i < len; i++) {
            int alp = s.charAt(i) - 'a';
            if (cnts[alp] == 0) {
                cnts[alp] = 1;
                dp[0][i] = dp[0][i - 1] + 1;
            } else {
                cnts[alp] = 0;
                dp[0][i] = dp[0][i - 1] - 1;
            }
            if (dp[0][i] == 1) res++;
        }
        for (int i = 1; i < len; i++) {
            int old = s.charAt(i - 1) - 'a';
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(j) - 'a' == old) {
                    dp[i][j]=dp[i][j-1]-dp[i-1][j]+dp[i-1][j-1];
                }else {
                    dp[i][j]=dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1];
                }
                if (dp[i][j] == 1) res++;
            }
        }
        System.out.println(res);
    }
}

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] nums = new int[n];
//        HashMap<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < n - 1; i++) {
//            int a = in.nextInt() - 1;
//            int b = in.nextInt() - 1;
//            if (a > b) {
//                int temp = a;
//                a = b;
//                b = temp;
//            }
//            if (!map.containsKey(a)) {
//                map.put(a, new ArrayList<Integer>());
//            }
//            map.get(a).add(b);
//        }
//        for (int i = n - 1; i >= 0; i--) {
//            List<Integer> list = map.get(i);
//            if (list == null) {
//                continue;
//            }
//            ArrayList<Integer> newList = new ArrayList<>(list);
//            for (int num : list) {
//                if (num < i) {
//                    System.out.println(-1);
//                    return;
//                }
//                if (map.containsKey(num)) {
//                    newList.addAll(map.get(num));
//                }
//            }
//            map.put(i, newList);
//        }
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            if (i != nums[i]) {
//                int dis = i - nums[i];
//                res += dis;
//                List<Integer> list = map.get(i);
//                if (list == null) {
//                    continue;
//                }
//                for (int num : list) {
//                    nums[num] += dis;
//                }
//            }
//        }
//        System.out.println(res);
//    }
//}

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int x = in.nextInt();
//        StringBuilder res = new StringBuilder();
//        for (int i = 0; i < 26; i++) {
//            if (x == 0) {
//                break;
//            }
//            if (x % 2 == 1) {
//                res.append((char) ('a' + i));
//            }
//            x /= 2;
//        }
//        System.out.println(res);
//    }
//}