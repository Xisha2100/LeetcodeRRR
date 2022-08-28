package top.nzhz;


//import java.util.LinkedList;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        int K = in.nextInt();
//        int[] nums = new int[N];
//        for (int i = 0; i < N; i++) {
//            nums[i] = in.nextInt();
//        }
//
//        LinkedList<Integer> list = new LinkedList<>();
//        list.offerLast(nums[0]);
//        int sum = nums[0];
//        for (int i = 1; i < K + 1; i++) {
//            if (nums[i] < list.peekLast()) {
//                while (!list.isEmpty() && nums[i] < list.peekLast()) {
//                    list.pollLast();
//                }
//            }
//            sum += nums[i];
//            list.offerLast(nums[i]);
//        }
//        int max = sum - list.peekFirst();
//        for (int i = 0; i < N - K - 1; i++) {
//            if (nums[i] == list.peekFirst()) {
//                list.pollFirst();
//            }
//            if (nums[i + K + 1] < list.peekLast()) {
//                while (!list.isEmpty() && nums[i + K + 1] < list.peekLast()) {
//                    list.pollLast();
//                }
//            }
//            list.offerLast(nums[i + K + 1]);
//            sum -= nums[i];
//            sum += nums[i + K + 1];
//            max = Math.max(sum - list.peekFirst(), max);
//        }
//        System.out.println(max);
//    }
//}


//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = in.nextInt();
//        }
//        int[] leftmax = new int[n + 1];
//        int[] right = new int[n + 1];
//        int sum = 0;
//        if (nums[0] > 0) {
//            leftmax[1] = nums[0];
//            sum = nums[0];
//        }
//        if (nums[n - 1] > 0) {
//            right[n - 1] = nums[n - 1];
//        }
//        for (int i = 1; i < n; i++) {
//            int left = sum + nums[i];
//            if (left > 0) {
//                sum = left;
//            } else {
//                sum = 0;
//            }
//            if (left > leftmax[i]) {
//                leftmax[i + 1] = left;
//            } else {
//                leftmax[i + 1] = leftmax[i];
//            }
//            if (right[n - i] + nums[n - i - 1] > 0) {
//                right[n - i - 1] = right[n - i] + nums[n - i - 1];
//            } else {
//                right[n - i - 1] = 0;
//            }
//        }
//
//        int max = 0;
//        for (int i = 0; i < n + 1; i++) {
//            max = Math.max(max, leftmax[i] + right[i]);
//        }
//        System.out.println(max);
//    }
//}

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        in.nextLine();
//        String[] nodes = in.nextLine().split(" ");
//        HashMap<String, List<String>> map = new HashMap<>();
//
//        for (int i = 0; i < n - 1; i++) {
//            String[] temp = in.nextLine().split(" ");
//            ArrayList<String> strings = new ArrayList<>();
//            for (int j = 0; j < temp.length - 1; j++) {
//                strings.add(temp[j + 1]);
//            }
//            map.put(temp[0], strings);
//        }
//
//        for (int i = 0; i < nodes.length; i++) {
//            if (dfs(map, nodes[i], new HashMap<>())) {
//                System.out.print("1");
//            } else {
//                System.out.print("0");
//            }
//            if (i == nodes.length - 1) {
//                System.out.println();
//            } else {
//                System.out.print(" ");
//            }
//        }
//    }
//
//    private static boolean dfs(HashMap<String, List<String>> map, String node, HashMap<String, Boolean> states) {
//        if (map.get(node) == null || map.get(node).isEmpty()) {
//            states.put(node, Boolean.FALSE);
//            return true;
//        }
//        states.put(node,Boolean.TRUE);
//        for (String child : map.get(node)) {
//            if (states.get(child) == null) {
//                if (!dfs(map, child, states)) {
//                    return false;
//                }
//            } else if (states.get(child)) {
//                return false;
//            }
//        }
//        states.put(node,Boolean.FALSE);
//        return true;
//    }
//}


import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] res = new int[2];
            int x = 0, y = 0;
            HashMap<Integer, Integer> map = new HashMap() {{
                int key = 1;
                for (int j = 0; j < 11; j++) {
                    put(key, j);
                    key *= 2;
                }
            }};
            int cur = 0;
            int max = -1;
            for (int j = 0; j < n; j++) {
                int num = in.nextInt();
                if (num == 0) {
                    if (cur > max) {
                        res[0] = x + 1;
                        res[1] = y + 1;
                        max = cur;
                    }
                    x = j + 1;
                    y = j + 1;
                    cur = 0;
                } else if (num > 1) {
                    cur += map.get(num);
                    y = j;
                }
            }
            if (cur > max) {
                res[0] = x + 1;
                res[1] = y + 1;
            }
            System.out.println(res[0] + " " + res[1]);
        }
    }
}

