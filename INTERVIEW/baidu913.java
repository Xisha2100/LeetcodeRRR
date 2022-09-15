package top.nzhz;

//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] A = new int[n];
//        long res = 0;
//        for (int i = 0; i < n; i++) {
//            A[i] = in.nextInt();
//            res += A[i];
//        }
//        for (int i = n - 1; i >= 2; i--) {
//            int min = Math.min(A[i] / 3, Math.min(A[i - 1] / 2, A[i - 2]));
//            if (min > 0) {
//                res -= min;
//                A[i - 1] -= 2 * min;
//                A[i - 2] -= min;
//            }
//        }
//        System.out.println(res);
//    }
//}


import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res = 0;
        int cur = 0;
        LinkedList<String> stack = new LinkedList<>();
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String temp = in.nextLine().trim();
//            for (int i = 0; i < temp.length(); i++) {
//                temp=temp.substring(i);
//                if (temp.startsWith("for")) {
//                    stack.push("for");
//                    cur++;
//                    res = Math.max(res, cur);
//                } else if (temp.startsWith("if")) {
//                    stack.push("if");
//                } else if (temp.startsWith("}")) {
//                    if (!stack.isEmpty()) {
//                        if (stack.pop() == "for") {
//                            cur--;
//                        }
//                    }
//                }
//            }
            if (temp.startsWith("for")) {
                stack.push("for");
                cur++;
                res = Math.max(res, cur);
            } else if (temp.startsWith("if")) {
                stack.push("if");
            }
            if (temp.contains("}")) {
                if (!stack.isEmpty()) {
                    if (stack.pop() == "for") {
                        cur--;
                    }
                }
            }
        }
        System.out.println(res);
    }
}


//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.next();
//        if (str.length() < 5) {
//            System.out.println(0);
//            return;
//        }
//        int[] cnts = new int[26];
//        int aNum = 0;
//        int dNum = 0;
//        int res = 0;
//        int status = 0;
//        for (int i = 0; i < str.length(); i++) {
//            char temp = str.charAt(i);
//            boolean flag = temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u';
//            if (i >= 5) {
//                char pre = str.charAt(i - 5);
//                if (cnts[pre - 'a'] == 1) {
//                    dNum--;
//                    if (pre == 'a' || pre == 'e' || pre == 'i' || pre == 'o' || pre == 'u') {
//                        aNum--;
//                    }
//                }
//                cnts[pre - 'a']--;
//            }
//            if (cnts[temp - 'a'] == 0) {
//                dNum++;
//                if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
//                    aNum++;
//                }
//            }
//            cnts[temp - 'a']++;
//            if (status == 0) {
//                if (!flag) {
//                    status = 1;
//                }
//            } else if (status == 1) {
//                if (flag) {
//                    status = 2;
//                }
//            } else if (status == 2) {
//                if (flag) {
//                    status = 3;
//                } else {
//                    status = 1;
//                }
//            } else if (status == 3) {
//                if (flag) {
//                    status = 0;
//                } else {
//                    status = 4;
//                }
//            } else if (status == 4) {
//                if (flag) {
//                    if (dNum == 5 && aNum == 3) {
//                        res++;
//                    }
//                    status = 2;
//                } else {
//                    status = 1;
//                }
//            }
//        }
//        System.out.println(res);
//    }
//}