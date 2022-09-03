package top.nzhz;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int r = in.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            in.nextInt();
            scores[i] = in.nextInt();
        }
        Arrays.sort(scores);
        for (int i = 0; i < scores.length / 2; i++) {
            int temp = scores[i];
            scores[i] = scores[scores.length - i - 1];
            scores[scores.length - i - 1] = temp;
        }
        int times = n / c;
        int oth = n % c;
        int loc = (r-1) / c;
        if (oth == 0) {
            double sum = 0;
            for (int i = 0; i < times; i++) {
                double tempSum = 0;
                if (i == loc) {
                    sum += scores[r - 1];
                    continue;
                }
                for (int j = 0; j < c; j++) {
                    tempSum += scores[i * c + j];
                }
                sum += tempSum / c;
            }
            System.out.printf("%.2f\n", sum / times);
        } else {
            double sum = 0;
            for (int i = 0; i < times; i++) {
                if (i == loc) {
                    sum += scores[r - 1];
                    continue;
                }
                double tempSum = 0;
                for (int j = 0; j < c; j++) {
                    tempSum += scores[i * c + j];
                }
                sum += tempSum / c;
            }
            if (loc == times) {
                sum += scores[r - 1];
            } else {
                double tempSum = 0;
                for (int i = 0; i < oth; i++) {
                    tempSum += scores[times * c + i];
                }
                for (int i = oth; i < c; i++) {
                    tempSum += sum / times;
                }
                sum+=tempSum/c;
            }
            System.out.printf("%.2f\n", sum / (times+1));
        }

    }
}


//import java.util.Scanner;

//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String S = in.next();
//        String T = in.next();
//        StringBuilder res = new StringBuilder();
//        if (T.length() > S.length()) {
//            for (int i = 0; i < S.length(); i++) {
//                if (S.charAt(i) == '#') {
//                    res.append('z');
//                } else {
//                    res.append(S.charAt(i));
//                }
//            }
//            System.out.println(res);
//            return;
//        }
//        int[] sCnt = new int[27];
//        int[] tCnt = new int[26];
//        for (int i = 0; i < S.length(); i++) {
//            if (S.charAt(i) == '#') {
//                sCnt[26]++;
//            } else {
//                sCnt[S.charAt(i) - 'a']++;
//            }
//        }
//        for (int i = 0; i < T.length(); i++) {
//            tCnt[T.charAt(i) - 'a']++;
//        }
//        int[] diff = new int[26];
//        boolean flag = true;
//        while (flag) {
//            int[] tempAdd = new int[26];
//            int temp = 0;
//            for (int i = 0; i < 26; i++) {
//                if (sCnt[i] >= tCnt[i]) {
//                    sCnt[i] -= tCnt[i];
//                } else if (sCnt[26] >  tCnt[i] -sCnt[i] + temp) {
//                    tempAdd[i] += tCnt[i] - sCnt[i];
//                    temp += tempAdd[i];
//                    sCnt[i] = 0;
//                } else {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                sCnt[26] -= temp;
//                for (int i = 0; i < 26; i++) {
//                    diff[i] += tempAdd[i];
//                }
//            }
//        }
//        for (int i = 0; i < S.length(); i++) {
//            if (S.charAt(i) == '#') {
//                if (sCnt[26] > 0) {
//                    sCnt[26]--;
//                    res.append('z');
//                }else {
//                    for (int j = 25; j >=0 ; j--) {
//                        if(diff[j]>0){
//                            diff[j]--;
//                            res.append((char)('a'+j));
//                            break;
//                        }
//                    }
//                }
//            } else {
//                res.append(S.charAt(i));
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
//        int T = in.nextInt();
//        Solution solution = new Main().new Solution();
//        for (int i = 0; i < T; i++) {
//            int n = in.nextInt();
//            int[] dirs = new int[n];
//            int[] nums = new int[n];
//            for (int j = 0; j < n; j++) {
//                if (in.next().equals("L")) {
//                    dirs[j] = 1;
//                } else {
//                    dirs[j] = 2;
//                }
//                nums[j] = in.nextInt();
//            }
//            solution.func(dirs,nums);
//        }
//    }
//
//
//    class Solution {
//        private boolean[] isAccessed;
//        private int[] steps;
//
//        public void func(int[] dirs, int[] nums) {
//            int n = dirs.length;
//            isAccessed = new boolean[n];
//            steps = new int[n];
//            for (int i = 0; i < n; i++) {
//                dfs(dirs, nums, i);
//            }
//            for (int i = 0; i < n-1; i++) {
//                System.out.print(steps[i]+" ");
//            }
//            System.out.println(steps[n-1]);
//        }
//
//        private int dfs(int[] dirs, int[] nums, int loc) {
//            if (isAccessed[loc]) {
//                if (steps[loc] == 0) {
//                    steps[loc] = -1;
//                    return -1;
//                } else {
//                    return steps[loc];
//                }
//            }
//            isAccessed[loc] = true;
//            if (dirs[loc] == 1) {
//                if (loc - nums[loc] < 0) {
//                    steps[loc] = 1;
//                } else {
//                    int temp = dfs(dirs, nums, loc - nums[loc]);
//                    if (temp == -1) {
//                        steps[loc] = -1;
//                    } else {
//                        steps[loc] = temp + 1;
//                    }
//                }
//            }else {
//                if(loc+nums[loc]>= nums.length){
//                    steps[loc] = 1;
//                }else {
//                    int temp = dfs(dirs, nums, loc + nums[loc]);
//                    if (temp == -1) {
//                        steps[loc] = -1;
//                    } else {
//                        steps[loc] = temp + 1;
//                    }
//                }
//            }
//            return steps[loc];
//        }
//    }
//}

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = in.nextInt();
//            int k = in.nextInt();
//            String s = in.next();
//            int[] cnts = new int[n];
//            int maxPre = 0;
//            int up = -1;
//            int floor = 0;
//            for (int j = 0; j < n; j++) {
//                int temp = s.charAt(j) - 'a';
//                if (up < 0) {
//                    if (temp <= k) {
//                        cnts[j] = 0;
//                        maxPre = Math.max(temp, maxPre);
//                    } else {
//                        up = temp;
//                        cnts[j] = temp - k + maxPre;
//                        floor = cnts[j];
//                    }
//                } else {
//                    if (temp <= maxPre) {
//                        cnts[j] = 0;
//                    } else if (temp < floor || temp > up) {
//                        cnts[j] = temp;
//                    } else {
//                        cnts[j] = floor;
//                    }
//                }
//            }
//            StringBuilder res = new StringBuilder();
//            for (int j = 0; j < n; j++) {
//                res.append((char)('a'+cnts[j]));
//            }
//            System.out.println(res);
//        }
//    }
//}