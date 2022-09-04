package top.nzhz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static int res = 0;
    private static HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        double[] A = new double[n];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
            sum += A[i];
        }
        Arrays.sort(A);
        func(A, 0, A.length - 1, sum, k);
        System.out.println(res + 1);
    }

    private static void func(double[] A, int left, int right, double sum, int k) {
        if (right <= left) {
            return;
        }
        if (res >= right - left) {
            return;
        }
//        if (!map.containsKey(left)) {
//            map.put(left, new HashSet<>());
//        }
//        HashSet<Integer> set = map.get(left);
//        if (set.contains(right)) {
//            return;
//        } else {
//            set.add(right);
//        }

        if (sum * k / (right - left + 1) >= A[right]) {
            res = right - left;
            return;
        }
        func(A, left + 1, right, sum - A[left], k);
        func(A, left, right - 1, sum - A[right], k);
    }
}


//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        int[] L = new int[t];
//        int[] R = new int[t];
//        int[] T = new int[t];
//        int max = 0;
//        for (int i = 0; i < t; i++) {
//            L[i] = in.nextInt();
//        }
//        for (int i = 0; i < t; i++) {
//            R[i] = in.nextInt();
//            max = Math.max(max, R[i]);
//        }
//        for (int i = 0; i < t; i++) {
//            T[i] = in.nextInt();
//        }
//
//        int[] num = new int[max + 1];
//        int[][] cnt = new int[16][max + 1];
//        cnt[0][0]++;
//        for (int i = 1; i < 10; i++) {
//            for (int j = 0; j < 16; j++) {
//                cnt[j][i] = cnt[j][i - 1];
//            }
//            num[i] = i;
//            cnt[i][i]++;
//        }
//        for (int i = 10; i <= max; i++) {
//            for (int j = 0; j < 16; j++) {
//                cnt[j][i] = cnt[j][i - 1];
//            }
//            num[i] = num[i / 10] ^ num[i % 10];
//            cnt[num[i]][i]++;
//        }
//        for (int i = 0; i < t; i++) {
//            int res = 0;
////            for (int j = L[i]; j <= R[i]; j++) {
////                if (num[j] == T[i]) {
////                    res++;
////                }
////            }
//            if (T[i] > 15) {
//                res = 0;
//            } else if (L[i] == 0) {
//                res = cnt[T[i]][R[i]];
//            } else {
//                res = cnt[T[i]][R[i]] - cnt[T[i]][L[i] - 1];
//            }
//            System.out.print(res);
//            if (i == t - 1) {
//                System.out.println();
//            } else {
//                System.out.print(" ");
//            }
//        }
//    }
//}