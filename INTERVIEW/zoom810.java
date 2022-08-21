package top.nzhz;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        UnionFind unionFind = new Main().new UnionFind();
        int n = in.nextInt();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (in.nextInt() == 1) {
                String name = in.next();
                int size = in.nextInt();
                ArrayList<String> companys = new ArrayList<>();
                String company1 = in.next();
                companys.add(company1);
                unionFind.insert(company1);
                for (int j = 1; j < size; j++) {
                    String company = in.next();
                    companys.add(company);
                    unionFind.insert(company);
                    unionFind.union(company1, company);
                }
                map.put(name, companys);
            } else {
                String name = in.next();
                if (map.containsKey(name)) {
                    System.out.println(unionFind.getCnt(map.get(name).get(0))-map.get(name).size());
                } else {
                    System.out.println("error");
                }
            }
        }
    }

    class UnionFind {
        HashMap<String, String> parent;
        HashMap<String, Integer> cnt;

        public UnionFind() {
            this.parent = new HashMap<>();
            this.cnt = new HashMap<>();
        }

        public void insert(String s) {
            if(!parent.containsKey(s)) {
                parent.put(s, s);
                cnt.put(s, 1);
            }
        }

        public String find(String s) {
            if (s == parent.get(s)) {
                return s;
            } else {
                String sP = find(parent.get(s));
                parent.put(s, sP);
                cnt.put(s, cnt.get(sP));
                return sP;
            }
        }

        public void union(String s1, String s2) {
            String s1P = find(s1);
            String s2P = find(s2);
            if (s1P == s2P) {
                return;
            } else {
                parent.put(s2P, s1P);
                cnt.put(s1P, cnt.get(s1P) + cnt.get(s2P));
            }
        }

        public int getCnt(String s){
            find(s);
            return cnt.get(s);
        }
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        in.nextLine();
//        String color = in.nextLine();
//        ArrayList<Integer>[] lists = new ArrayList[n];
//        for (int i = 0; i < n; i++) {
//            lists[i] = new ArrayList<>();
//        }
//        for (int i = 0; i < n - 1; i++) {
//            int a = in.nextInt() - 1;
//            int b = in.nextInt() - 1;
//            lists[a].add(b);
//            lists[b].add(a);
//        }
//        int[] score = new int[n];
//        int[] father = new int[n];
//        boolean[] handled = new boolean[n];
//        int res = 1;
//        LinkedList<Integer> queue = new LinkedList<>();
//        if (color.charAt(0) == 'R') {
//            score[0] = 1;
//        } else {
//            score[0] = -1;
//        }
//        handled[0] = true;
//        for (int child : lists[0]) {
//            queue.offer(child);
//            father[child] = 0;
//        }
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                int cur = queue.poll();
//                if (color.charAt(cur) == 'R') {
//                    score[cur] = score[father[cur]] + 1;
//                } else {
//                    score[cur] = score[father[cur]] - 1;
//                }
//                res += Math.abs(score[cur]);
//                handled[cur] = true;
//                for (int child : lists[cur]) {
//                    if(!handled[child]) {
//                        queue.offer(child);
//                        father[child] = cur;
//                    }
//                }
//            }
//        }
//        System.out.println(res);
//    }


}
