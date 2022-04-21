package top.nzhz;

import java.util.*;

public class Main {
    private boolean[] isAccessed;
    private int res;
    private int cur;
    private boolean isR=false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        HashMap<Integer, List<int[]>> inEdge = new HashMap<>();
        HashMap<Integer, List<int[]>> outEdge = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inEdge.put(i,new ArrayList<>());
            outEdge.put(i,new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a= sc.nextInt()-1;
            int b=sc.nextInt()-1;
            int z=sc.nextInt();
            inEdge.get(a).add(new int[]{b,z});
            outEdge.get(b).add(new int[]{a,z});
        }
        Main main = new Main();
        main.res=Integer.MAX_VALUE;
        main.cur=0;
        main.isAccessed=new boolean[n];
        main.isAccessed[0]=true;
        main.dfs(inEdge,outEdge,0,n-1);
        if(main.res==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(main.res);
    }

    private void dfs(HashMap<Integer, List<int[]>> inEdge,HashMap<Integer, List<int[]>> outEdge,int node,int target){
        if(node==target){
            res=Math.min(res,cur);
            return;
        }
        List<int[]> edges=inEdge.get(node);
        for (int[] edge : edges) {
            if(isAccessed[edge[0]]) continue;
            isAccessed[edge[0]]=true;
            cur+=edge[1];
            dfs(inEdge,outEdge,edge[0],target);
            cur-=edge[1];
            isAccessed[edge[0]]=false;
        }
        if(!isR){
            isR=true;
            edges=outEdge.get(node);
            for (int[] edge : edges) {
                if(isAccessed[edge[0]]) continue;
                isAccessed[edge[0]]=true;
                cur+=edge[1];
                dfs(inEdge,outEdge,edge[0],target);
                cur-=edge[1];
                isAccessed[edge[0]]=false;
            }
            isR=false;
        }
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        long p = sc.nextInt();
//        long x = sc.nextInt();
//        long[] nums = new long[n];
//        long sumNum = 0;
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//            sumNum += nums[i];
//        }
//        int res = 0;
//
//
//        for (int i = 0; i < n; i++) {
//            long leftNum = (sumNum - nums[i]) % x;
//            int mul = 0;
//            if(leftNum==0) mul++;
//            while (leftNum + x * mul <= p) {
//                if (leftNum + x * mul != nums[i]) res++;
//                mul++;
//            }
//        }
//        System.out.println(res);
//
//    }
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        System.out.print('*');
//        for (int i = 0; i < n-2; i++) {
//            System.out.print(' ');
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.print('*');
//        }
//        System.out.println();
//        for (int i = 0; i < n-2; i++) {
//            System.out.print('*');
//            for (int j = 0; j < i; j++) {
//                System.out.print(' ');
//            }
//            System.out.print('*');
//            for (int j = 0; j < n-3-i; j++) {
//                System.out.print(' ');
//            }
//            System.out.print('*');
//            for (int j = 0; j < n-3-i; j++) {
//                System.out.print(' ');
//            }
//            System.out.print('*');
//            for (int j = 0; j < i+1; j++) {
//                System.out.print(' ');
//            }
//            System.out.println();
//        }
//
//        for (int i = 0; i < 2*n-1; i++) {
//            System.out.print('*');
//        }
//        System.out.println();
//
//        for (int i = n-3; i >=0; i--) {
//            for (int j = 0; j < i+1; j++) {
//                System.out.print(' ');
//            }
//            System.out.print('*');
//            for (int j = 0; j < n-3-i; j++) {
//                System.out.print(' ');
//            }
//            System.out.print('*');
//            for (int j = 0; j < n-3-i; j++) {
//                System.out.print(' ');
//            }
//            System.out.print('*');
//            for (int j = 0; j < i; j++) {
//                System.out.print(' ');
//            }
//            System.out.print('*');
//            System.out.println();
//        }
//
//        for (int i = 0; i < n; i++) {
//            System.out.print('*');
//        }
//        for (int i = 0; i < n-2; i++) {
//            System.out.print(' ');
//        }
//        System.out.print('*');
//    }
}