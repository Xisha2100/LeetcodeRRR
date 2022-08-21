package top.nzhz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] cost = new int[N];
        for (int i = 0; i < N; i++) {
            cost[i]=sc.nextInt();
        }
        HashMap<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            List temp=edges.getOrDefault(a,new ArrayList<>());
            temp.add(b);
            edges.put(a,temp);
            temp=edges.getOrDefault(b,new ArrayList<>());
            temp.add(a);
            edges.put(b,temp);

        }

    }
//    public static void main(String[] args) {
//        int res=0;
////        Scanner sc = new Scanner(System.in);
////        int n = sc.nextInt();
////        int[] nums = new int[n];
////        for (int i = 0; i < n; i++) {
////            nums[i]=sc.nextInt();
////        }
//        System.out.println(Integer.MAX_VALUE);
//        int n=3;
//        int[] nums=new int[]{10,2,5};
//        int[][] pre = new int[n][n];
//        int[][] zeros = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            while (nums[i]%10==0){
//                nums[i]=nums[i]/10;
//                zeros[i][i]++;
//            }
//            pre[i][i]=nums[i];
//            res+=zeros[i][i];
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                long num=pre[i][j-1]*pre[j][j];
//                zeros[i][j]=zeros[i][j-1]+zeros[j][j];
//                while (num%10==0){
//                    num=num/10;
//                    zeros[i][j]++;
//                }
//                pre[i][j]=(int)num;
//                res+=zeros[i][j];
//            }
//        }
//        System.out.println(res);
//    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int x = sc.nextInt();
//
//        if(n>k){
//            System.out.println(-1);
//            return;
//        }
//        if(n*(2*k-n+1)/2<x){
//            System.out.println(-1);
//            return;
//        }
//        int[] res = new int[n];
//        if(k>x) k=x;
////        if(n==1){
////            System.out.println(x);
////            return;
////        }
//        while (n>0){
//            if(x-k<n*(n-1)/2){
//                k--;
//                if(n>k){
//                    System.out.println(-1);
//                    return;
//                }
//                continue;
//            }else if(x-k==n*(n-1)/2){
//                res[n-1]=k;
//                for (int i = 0; i < n-1; i++) {
//                    res[i]=i+1;
//                }
//                break;
//            }else {
//                n--;
//                res[n]=k;
//                x-=k;
//                k--;
//            }
//        }
//        for (int i = 0; i < res.length-1; i++) {
//            System.out.println(res[i]);
//            System.out.println(' ');
//
//        }
//        System.out.println(res[res.length-1]);
//
//    }

//    public void helper(int leftCnt,int max, int curN,int sum, int target){
//        if(leftCnt==0&&target==sum) {
//
//        }
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for(int i=0;i<n;i++){
//            for (int j = 0; j < n-i; j++) {
//                System.out.print('.');
//            }
//            for (int j = 0; j < 2*n+2*i; j++) {
//                System.out.print('*');
//            }
//            for (int j = 0; j < n-i; j++) {
//                System.out.print('.');
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < 2*n ; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print('*');
//            }
//            for (int j = 0; j < 2*n; j++) {
//                System.out.print('.');
//            }
//            for (int j = 0; j < n; j++) {
//                System.out.print('*');
//            }
//            System.out.println();
//        }
//        for(int i=n-1;i>=0;i--){
//            for (int j = 0; j < n-i; j++) {
//                System.out.print('.');
//            }
//            for (int j = 0; j < 2*n+2*i; j++) {
//                System.out.print('*');
//            }
//            for (int j = 0; j < n-i; j++) {
//                System.out.print('.');
//            }
//            System.out.println();
//        }
//
//
//    }
}