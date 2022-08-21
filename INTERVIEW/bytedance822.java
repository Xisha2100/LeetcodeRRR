package top.nzhz;


import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        String[] keys = init(str);
        for (int i = 0; i < n; i++) {
            String temp = in.next();
            if (isLegal(temp, keys)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }

    private static String[] init(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str.charAt(0) == '{') {
            list.add("*");
        }
        int pre = 0;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{') {
                start = i;
                while (str.charAt(i) != '}') {
                    i++;
                }
                if (start != 0) {
                    list.add(str.substring(pre, start));
                }
                pre = i + 1;
            }
        }
        if (pre == str.length()) {
            list.add("*");
        } else {
            list.add(str.substring(pre));
        }
        return list.toArray(new String[0]);
    }

    private static boolean isLegal(String s, String[] keys) {
        if (!keys[0].equals("*")) {
            if (!s.startsWith(keys[0])) {
                return false;
            } else {
                s = s.substring(keys[0].length());
            }
        }
        if (!keys[keys.length - 1].equals("*")) {
            if (!s.endsWith(keys[keys.length - 1])) {
                return false;
            } else {
                s = s.substring(0, s.length() - keys[keys.length - 1].length());
            }
        }
        int cnt = 0;
        for (int i = 1; i < keys.length - 1; i++) {
            while (cnt + keys[i].length() < s.length() && s.substring(cnt, cnt + keys[i].length()) != keys[i]) {
                cnt++;
            }
        }

        return true;
    }
}
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int[] A = new int[n];
//        int[] B = new int[m];
//        for (int i = 0; i < n; i++) {
//            A[i] = in.nextInt();
//        }
//        for (int i = 0; i < m; i++) {
//            B[i] = in.nextInt();
//        }
//        Solution solution = new Main().new Solution();
//        System.out.printf("%.3f\n", solution.solution(A, B));
//    }
//
//    class Solution {
//
//
//        public double solution(int[] A, int[] B) {
//            int sum = 0;
//            double p = 1;
//            for (int i = 0; i < A.length; i++) {
//                sum += A[i];
//                p /= A[i];
//            }
//            double[] Pa = new double[sum + 1];
//            dfs(A, 0, 0, p, Pa);
//            sum = 0;
//            p = 1;
//            for (int i = 0; i < B.length; i++) {
//                sum += B[i];
//                p /= B[i];
//            }
//            double[] Pb = new double[sum + 1];
//            double res = 0;
//            dfs(B, 0, 0, p, Pb);
//            for (int i = 1; i < Pb.length; i++) {
//                Pb[i] += Pb[i - 1];
//            }
//            for (int i = 2; i < Pa.length; i++) {
//                res += Pa[i] * Pb[Math.min(i - 1, Pb.length - 1)];
//            }
//            return res;
//        }
//
//        private void dfs(int[] num, int loc, int dep, double p, double[] P) {
//            if (dep == num.length) {
//                P[loc] += p;
//                return;
//            }
//            for (int i = 1; i <= num[dep]; i++) {
//                dfs(num, loc + i, dep + 1, p, P);
//            }
//        }
//    }
//}
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        char[][] map = new char[n][];
//        for (int i = 0; i < n; i++) {
//            String s = in.next();
//            map[i] = s.toCharArray();
//        }
//        Solution solution = new Main().new Solution();
//
//        System.out.println(solution.solution(map));
//    }
//
//    class Solution {
//        private int cnt = 0;
//        private boolean[][] isAccessed;
//
//        public int solution(char[][] map) {
//            int n = map.length;
//            int m = map[0].length;
//            isAccessed = new boolean[n][m];
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if (map[i][j] == 'O') {
//                        dfs(map, i, j);
//                        return m * n - cnt;
//                    }
//                }
//            }
//            return 0;
//        }
//
//        private void dfs(char[][] map, int x, int y) {
//            cnt++;
//            isAccessed[x][y] = true;
//            if (x > 0 && !isAccessed[x - 1][y] && (map[x - 1][y] == '.' || map[x - 1][y] == 'D')) {
//                dfs(map, x - 1, y);
//            }
//            if (y > 0 && !isAccessed[x][y - 1] && (map[x][y - 1] == '.' || map[x][y - 1] == 'R')) {
//                dfs(map, x, y - 1);
//            }
//            if (x < map.length - 1 && !isAccessed[x + 1][y] && (map[x + 1][y] == '.' || map[x + 1][y] == 'U')) {
//                dfs(map, x + 1, y);
//            }
//            if (y < map[0].length -1 && !isAccessed[x][y + 1] && (map[x][y + 1] == '.' || map[x][y + 1] == 'L')) {
//                dfs(map, x, y + 1);
//            }
//        }
//    }
//
//
//}

//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = in.nextInt();
//            int k = in.nextInt();
//            String s = in.next();
//            int num1 = 0;
//            for (int j = 0; j < n; j++) {
//                if (s.charAt(j) == '1') {
//                    num1++;
//                }
//            }
//            if (n - num1 == 0) {
//                System.out.println((num1 - 1) * 11);
//            } else if (n - num1 == 1) {
//                if (k == 0) {
//                    if (s.charAt(0) == '0') {
//                        System.out.println(num1 * 11 - 10);
//                    } else if (s.charAt(n - 1) == '0') {
//                        System.out.println(num1 * 11 - 1);
//                    } else {
//                        System.out.println((num1 - 1) * 11);
//                    }
//                } else {
//                    System.out.println(num1 * 11 - 11);
//                }
//            } else {
//                if (k == 0) {
//                    if (s.charAt(0) == '0' && s.charAt(n - 1) == '0') {
//                        System.out.println(num1 * 11);
//                    } else if (s.charAt(n - 1) == '0') {
//                        System.out.println(num1 * 11 - 1);
//                    } else if (s.charAt(0) == '0') {
//                        System.out.println(num1 * 11 - 10);
//                    } else {
//                        System.out.println((num1 - 1) * 11);
//                    }
//                } else if (k == 1) {
//                    if (s.charAt(0) != '0' && s.charAt(n - 1) != '0') {
//                        System.out.println(num1 * 11 - 10);
//                    } else {
//                        System.out.println(num1 * 11 - 11);
//                    }
//                } else {
//                    System.out.println(num1 * 11 - 11);
//                }
//            }
//        }
//    }
//}

