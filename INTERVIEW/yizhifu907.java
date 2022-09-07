package top.nzhz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            long a = in.nextInt();
            long b = in.nextInt();
            func(n,a,b);
        }
    }

    private static void func(int n, long a, long b) {
        double perA = a / 2.0;
        double perB = b / 3.0;
        long num1 = n / 6;
        int num2 = n % 6;
        long res = 0;
        if (perA < perB) {
            res+=num1*3*a;
        }else {
            res+=num1*2*b;
        }
        switch (num2){
            case 0:
                System.out.println(res);
                return;
            case 1:
                if(n>7){
                    System.out.println(res+Math.min(Math.min(a,b),2*a+b+(perA<perB?-3*a:-2*b)));
                    return;
                }
                System.out.println(res+Math.min(a,b));
                return;
            case 2:
                System.out.println(res+Math.min(a,b));
                return;
            case 3:
                System.out.println(res+Math.min(2*a,b));
                return;
            case 4:
                System.out.println(res+Math.min(2*a,2*b));
                return;
            case 5:
                System.out.println(res+Math.min(3*a,Math.min(a+b,2*b)));
                return;
        }
    }
}
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        long a = in.nextInt();
//        long h = in.nextInt();
//        long b = in.nextInt();
//        long k = in.nextInt();
//        long aT = k / a;
//        long bT = h / b;
//        if (k % a != 0) {
//            aT++;
//        }
//        if (h % b != 0) {
//            bT++;
//        }
//        if (aT > bT) {
//            System.out.println(bT * (a + b) + b * 10);
//        } else if (aT < bT) {
//            System.out.println(aT * (a + b) + a * 10);
//        } else {
//            System.out.println(aT * (a + b));
//        }
//    }
//}