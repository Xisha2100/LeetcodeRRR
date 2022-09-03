package top.nzhz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] A = new int[6];
        for (int i = 0; i < 6; i++) {
            A[i] = in.nextInt();
        }
        int[] condition = new int[9];
//        init(A, condition);
        int K = in.nextInt();
        int[] res = new int[6];
        int max = 0;
        for (int i = 0; i < K; i++) {
            int[] temp = new int[6];
            for (int j = 0; j < 6; j++) {
                temp[j] = in.nextInt();
            }
            init(temp,condition);
            if (isInside(A, condition)) {
                int size = getSize(temp);
                if (size >= max) {
                    max = size;
                    res = temp;
                }
            }
        }
        if (max == 0) {
            System.out.println("fail");
        } else {
            for (int i = 0; i < 5; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println(res[5]);
        }
    }

    private static void init(int[] A, int[] condition) {
        int a = A[0] - A[2];
        int b = A[1] - A[3];
        int c = a * A[0] - b * A[1];
        if (a * A[4] - b * A[5] - c > 0) {
            condition[0] = a;
            condition[1] = -b;
            condition[2] = -c;
        } else {
            condition[0] = -a;
            condition[1] = b;
            condition[2] = c;
        }

        a = A[0] - A[4];
        b = A[1] - A[5];
        c = a * A[0] - b * A[1];
        if (a * A[2] - b * A[3] - c > 0) {
            condition[3] = a;
            condition[4] = -b;
            condition[5] = -c;
        } else {
            condition[3] = -a;
            condition[4] = b;
            condition[5] = c;
        }

        a = A[2] - A[4];
        b = A[3] - A[5];
        c = a * A[2] - b * A[3];
        if (a * A[0] - b * A[1] - c > 0) {
            condition[6] = a;
            condition[7] = -b;
            condition[8] = -c;
        } else {
            condition[6] = -a;
            condition[7] = b;
            condition[8] = c;
        }
    }

    private static boolean isInside(int[] B, int[] condition) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (B[i * 2] * condition[j * 3] + B[i * 2 + 1] * condition[j * 3 + 1] + condition[j * 3 + 2] > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int getSize(int[] B) {
        return B[0] * B[3] + B[2] * B[5] + B[4] * B[1] - B[0] * B[5] - B[2] * B[1] - B[4] * B[3];
    }
}

//import java.util.HashMap;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int L = in.nextInt();
//        int N = in.nextInt();
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < N; i++) {
//            int a = in.nextInt();
//            int b = in.nextInt();
//            int temp = map.getOrDefault(a, 0);
//            if (b > temp) {
//                map.put(a, b);
//            }
//        }
//        if (!map.containsKey(1)) {
//            System.out.println("fail");
//            return;
//        }
//        int res = 1;
//        int loc = 1;
//        int end = map.get(1) + 1;
//        int start = 2;
//        while (end <= L) {
//            int max = 0;
//            for (int i = start; i <= end; i++) {
//                if (map.containsKey(i)) {
//                    max = Math.max(map.get(i), max);
//                }
//            }
//            if (max < end) {
//                System.out.println("fail");
//                return;
//            }
//            start = end + 1;
//            end = max + 1;
//            res++;
//
//        }
//        System.out.println(res);
//    }
//}
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] x = new int[n];
//        long[] res = new long[n];
//        long max = 0;
////        long zero = 0;
//        boolean flag = false;
//        for (int i = 0; i < n; i++) {
//            x[i] = in.nextInt();
//        }
//
//        for (int i = 0; i < n; i++) {
//            long sum = 0;
//            for (int j = 0; j <= n - i - 1; j++) {
//                sum += x[j] * x[j + i];
//            }
//            for (int j = n - i; j <= n - 1; j++) {
//                sum += x[j] * x[j + i - n];
//            }
//            System.out.print(sum);
//            res[i] = sum;
//            if (i < n - 1) {
//                System.out.print(" ");
//            } else {
//                System.out.println();
//            }
////            if (i == 0) {
////                zero = sum;
////                continue;
////            }
////            if (Math.abs(sum) > Math.abs(max) && Math.abs(sum) > Math.abs(zero)) {
////                max = sum;
////                flag = true;
////            }
//        }
//        for (int i = 1; i < n - 1; i++) {
//            if (res[i] < res[i - 1] && res[i] < res[i + 1]) {
//                if (Math.abs(res[i]) > Math.abs(max)) {
//                    max = res[i];
//                    flag = true;
//                }
//            }else if(res[i] > res[i - 1] && res[i] > res[i + 1]){
//                if (Math.abs(res[i]) > Math.abs(max)) {
//                    max = res[i];
//                    flag = true;
//                }
//            }
//        }
//        if (res[n-1] < res[n - 2] && res[n-1] < res[0]) {
//            if (Math.abs(res[n-1]) > Math.abs(max)) {
//                max = res[n-1];
//                flag = true;
//            }
//        }else if(res[n-1] > res[n - 2] && res[n-1] > res[0]){
//            if (Math.abs(res[n-1]) > Math.abs(max)) {
//                max = res[n-1];
//                flag = true;
//            }
//        }
//
//        if (flag) {
//            System.out.println(max);
//        } else {
//            System.out.println("NO");
//        }
//    }
//}