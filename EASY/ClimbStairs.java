package top.nzhz;

public class ClimbStairs {

    //自作聪明方法
    public int climbStairsBadMethodSpace(int n) {
        int ans = 0;

        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        for (int i = 0; i <= n / 2; i++) {
            ans = ans + (int) (factorial[n - i] / factorial[n - 2 * i] / factorial[i]);
        }
        return ans;
    }

    //加查表的递归
    int[] ans = new int[1000];

    public int climbStairsBadMethodTime(int n) {
        if (ans[n] == 0) {
            if (n >= 3) {
                ans[n] = climbStairsBadMethodTime(n - 1) + climbStairsBadMethodTime(n - 2);
            } else if (n <= 2) {
                ans[n] = n;
            }
        }
        return ans[n];
    }

    //典型动态规划
    public int climbStairsD(int n) {
        int ans1 = 0, ans2 = 1, ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = ans1 + ans2;
            ans1 = ans2;
            ans2 = ans;
        }
        return ans;
    }

    //好方法计算矩阵快速幂
    public int climbStairs(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

}
