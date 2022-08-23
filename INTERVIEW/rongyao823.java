package top.nzhz;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String command = in.next();
        RedisSolution redisSolution = new Main().new RedisSolution();
        System.out.println(redisSolution.cmdHandler(command));
    }

    class RedisSolution {
        private HashMap<String, Integer> aliveMap;
        private String[] servers = new String[40];
        private HashMap<String, Integer> allRelation;


        public int cmdHandler(String cmd) {
            init();
            String[] cmds;
            int cmdSwitch = cmd.charAt(0) - '0';
            switch (cmdSwitch) {
                case 1:
                    return aliveMap.get(cmd.substring(2));
                case 2:
                    return findRedisServer(getTokenHash(cmd.substring(2)));
                case 3:
                    cmds = cmd.substring(2).split(";");
                    brokeServer(cmds[0]);
                    return findRedisServer(getTokenHash(cmds[1]));
                case 4:
                    return allRelation.get(cmd.substring(2));
                case 5:
                    cmds = cmd.substring(2).split(";");
                    addServer(cmds[0]);
                    return findRedisServer(getTokenHash(cmds[1]));
            }
            return 0;
        }

        private void init() {
            aliveMap = new HashMap<>();
            allRelation = new HashMap<>();
            String pre = "redis_0";
            for (int i = 1; i < 10; i++) {
                aliveMap.put(pre + i, (i - 1) * 50);
                allRelation.put(pre + i, (i - 1) * 50);
                servers[(i - 1) * 2] = pre + i;
            }
            pre = "redis_";
            for (int i = 10; i <= 20; i++) {
                aliveMap.put(pre + i, (i - 1) * 50);
                allRelation.put(pre + i, (i - 1) * 50);
                servers[(i - 1) * 2] = pre + i;
            }
            String preAdd = "add_redis_";
            for (int i = 1; i < 20; i += 2) {
                if (i < 10) {
                    allRelation.put(preAdd + '0' + i, (i / 2) * 50 + 25);
                    servers[i] = preAdd + '0' + i;
                } else {
                    allRelation.put(preAdd + i, (i / 2) * 50 + 25);
                    servers[i] = preAdd + i;
                }
            }
            for (int i = 2; i <= 20; i += 2) {
                if (i < 10) {
                    allRelation.put(preAdd + '0' + i, (i / 2) * 50 + 475);
                    servers[i + 19] = preAdd + '0' + i;
                } else {
                    allRelation.put(preAdd + i, (i / 2) * 50 + 475);
                    servers[i + 19] = preAdd + i;
                }
            }
        }

        private int getTokenHash(String token) {
            int sum = 0;
            for (int i = 0; i < token.length(); i++) {
                sum += token.charAt(i);
            }
            return sum % 999;
        }

        private int findRedisServer(int hash) {
            if (hash % 25 == 0) {
                if (aliveMap.containsKey(servers[hash / 25])) {
                    return hash;
                }
            }
            int num = hash / 25 * 25;
            hash = num + 25;
            while (hash != num) {
                if (aliveMap.containsKey(servers[hash / 25])) {
                    return hash;
                }
                hash += 25;
                if (hash >= 1000) {
                    hash = 0;
                }
            }
            return 0;
        }

        private void brokeServer(String list) {
            String[] servers = list.split(",");
            for (String server : servers) {
                aliveMap.remove(server);
            }
        }

        private void addServer(String server) {
            int num = Integer.parseInt(server.substring(server.length() - 2));
            String preAdd = "add_redis_";
            for (int i = 1; i <= num; i++) {
                if (i < 10) {
                    aliveMap.put(preAdd + "0" + i, allRelation.get(preAdd + "0" + i));
                } else {
                    aliveMap.put(preAdd + i, allRelation.get(preAdd + i));
                }
            }
        }
    }

}
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        long num = in.nextLong();
//        boolean flag = true;
//        for (int i = 2; i <= 16; i++) {
//            if (isHui(num, i)) {
//                System.out.println(i);
//                flag = false;
//            }
//        }
//        if (flag) {
//            System.out.println(-1);
//        }
//    }
//
//    private static boolean isHui(long num, int div) {
//        ArrayList<Long> list = new ArrayList<>();
//        while (num / div != 0) {
//            list.add(num % div);
//            num /= div;
//        }
//        list.add(num);
//        for (int i = 0; i < list.size() / 2; i++) {
//            if (!list.get(i).equals(list.get(list.size() - i - 1))) {
//                return false;
//            }
//        }
//        return true;
//    }
//}

//import java.util.HashMap;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.next();
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == ',' || (str.charAt(i) <= 'Z' && str.charAt(i) >= 'A') || (str.charAt(i) <= 'z' && str.charAt(i) >= 'a')) {
//                continue;
//            } else {
//                System.out.println("error.0001");
//                return;
//            }
//        }
//        String[] names = str.split(",");
//        HashMap<String, Integer> map = new HashMap<>();
//        int max = 0;
//        String res = names[0];
//        for (String name : names) {
//            int cnt = map.getOrDefault(name, 0) + 1;
//            if (max < cnt) {
//                max = cnt;
//                res = name;
//            }
//            map.put(name, cnt);
//        }
//
//        for (String name : map.keySet()) {
//            if (!islegal(name)) {
//                System.out.println("error.0001");
//                return;
//            }
//            if (map.get(name) == max) {
//                res = compare(res, name);
//            }
//        }
//        System.out.println(res);
//    }
//
//    private static String compare(String A, String B) {
//        int aLen = A.length();
//        int bLen = B.length();
//        int len = Math.min(aLen, bLen);
//        for (int i = 0; i < len; i++) {
//            if (A.charAt(i) != B.charAt(i)) {
//                if (A.charAt(i) > B.charAt(i)) {
//                    return B;
//                } else {
//                    return A;
//                }
//            }
//        }
//        if (aLen > bLen) {
//            return B;
//        } else {
//            return A;
//        }
//    }
//
//    private static boolean islegal(String s) {
//        int len = s.length();
//        if (s.charAt(0) > 'Z' || s.charAt(0) < 'A') {
//            return false;
//        }
//        for (int i = 1; i < len; i++) {
//            if (s.charAt(i) > 'z' || s.charAt(i) < 'a') {
//                return false;
//            }
//        }
//        return true;
//    }
//}

