package top.nzhz;

import static java.lang.Math.abs;

public class Reverse {
    public static void main(String[] args) {
        Reverse rs = new Reverse();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(rs.reverse(123));
    }

    public int reverse(int x) {
        int out = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (out > Integer.MAX_VALUE / 10 || (out == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10))
                return 0;
            if (out < Integer.MIN_VALUE / 10 || (out == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10))
                return 0;
            out = out * 10 + pop;
        }
        return out;
    }
}
