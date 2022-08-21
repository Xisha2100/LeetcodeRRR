package top.nzhz;


import java.util.*;

import java.util.Scanner;

//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = in.nextInt();
//        }
//        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            if (!map.containsKey(nums[i])) {
//                map.put(nums[i], new ArrayList<>());
//            }
//            map.get(nums[i]).add(i);
//        }
//        int[] keys = new int[map.size()];
//        int temploc = 0;
//        for (int key : map.keySet()) {
//            keys[temploc++] = key;
//        }
//        Arrays.sort(keys);
//        int res = 0;
//        for (int i = 0; i < keys.length - 1; i++) {
//            for (int loc : map.get(keys[i])) {
//                for (int j = i + 1; j < keys.length; j++) {
//                    ArrayList<Integer> list = map.get(keys[j]);
//                    if(list.size()<2) break;
//                    for (int k = 0; k < list.size(); k++) {
//                        if (loc < list.get(k)) {
//                            res += k * (list.size() - k);
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(res);
//    }
//}
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int a = in.nextInt();
//        int b = in.nextInt();
//        if (a < b) {
//            int temp = a;
//            a = b;
//            b = temp;
//        }
//        if (a % b == 0) {
//            System.out.println(0);
//            return;
//        }
//        String aS = String.valueOf(a);
//        String bS = String.valueOf(b);
//        int cnt = 0;
//        HashMap<Integer, HashSet<Integer>> mapA = new HashMap<>();
//        HashSet<Integer> set = new HashSet<>();
//        set.add(a);
//        mapA.put(0, set);
//        cnt++;
//        while (cnt < aS.length()) {
//            set = new HashSet<>();
//            for (int num : mapA.get(cnt - 1)) {
//                int div=10;
//                for (int i = 0; i < aS.length()-cnt+1; i++) {
//                    int child=(num/div)*(div/10)+num%(div/10);
//                    div*=10;
//                    set.add(child);
//                }
//            }
//            mapA.put(cnt,set);
//            cnt++;
//        }
//        HashMap<Integer, HashSet<Integer>> mapB = new HashMap<>();
//        set = new HashSet<>();
//        set.add(b);
//        mapB.put(0, set);
//        cnt=1;
//        while (cnt < bS.length()) {
//            set = new HashSet<>();
//            for (int num : mapB.get(cnt - 1)) {
//                int div=10;
//                for (int i = 0; i < aS.length()-cnt+1; i++) {
//                    int child=(num/div)*(div/10)+num%(div/10);
//                    div*=10;
//                    set.add(child);
//                }
//            }
//            mapB.put(cnt,set);
//            cnt++;
//        }
//        for (int i = 1; i < aS.length()+bS.length()-1; i++) {
//            for (int j = 0; j <= i; j++) {
//                if(!mapA.containsKey(j)){
//                    break;
//                }
//                for(int numA:mapA.get(j)){
//                    if(!mapB.containsKey(i-j)){
//                        break;
//                    }
//                    for(int numB:mapB.get(i-j)){
//                        if(numA%numB==0||numB%numA==0){
//                            System.out.println(i);
//                            return;
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(-1);
//    }
//
//}
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] nums = new int[n];
//        int maxSingle = 0;
//        int maxDouble = 0;
//        for (int i = 0; i < n; i++) {
//            nums[i] = in.nextInt();
//            if (i % 2 == 0) {
//                maxDouble = Math.max(maxDouble, nums[i]);
//            } else {
//                maxSingle = Math.max(maxSingle, nums[i]);
//            }
//        }
//        long res = 0;
//
//        for (int i = 0; i < n; i += 2) {
//            res += maxDouble - nums[i];
//        }
//        for (int i = 1; i < n; i += 2) {
//            res += maxSingle - nums[i];
//        }
//        if (maxDouble == maxSingle) {
//            res += n / 2;
//        }
//        System.out.println(res);
//    }
//}
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int len = s.length();
        if (len < 3) {
            System.out.println(0);
            return;
        }

        if (len % 2 == 1) {
            int res = getCnt(s);
            System.out.println(res);
        } else {
            int res = Math.min(getCnt(s.substring(0, s.length() - 1)), getCnt(s.substring(1)));
            for (int i = 3; i < len - 2; i += 2) {
                res = Math.min(res, getCnt(s.substring(0, i)) + getCnt(s.substring(i)));
            }
            System.out.println(res);
        }

    }

    private static int getCnt(String s) {
        int len = s.length();
        int eCnt = 0;
        int rCnt = 0;
        int dCnt = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 1 && s.charAt(i) != 'e') {
                eCnt++;
            } else if (i / 2 % 2 == 0 && s.charAt(i) == 'r') {
                rCnt++;
            } else if (i / 2 % 2 == 1 && s.charAt(i) == 'd') {
                rCnt++;
            } else if (i / 2 % 2 == 0 && s.charAt(i) == 'd') {
                dCnt++;
            } else if (i / 2 % 2 == 1 && s.charAt(i) == 'r') {
                dCnt++;
            }
        }

        return Math.min(rCnt, dCnt) + eCnt;
    }

}

