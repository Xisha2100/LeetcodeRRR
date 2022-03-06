package top.nzhz;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] cut = new int[m];
        int[] loc = new int[m];
        for (int i = 0; i < m; i++) {
            cut[i] = in.next().charAt(0)-'x';
        }
        for (int i = 0; i < m; i++) {
            loc[i]=in.nextInt();
        }
        int maxX=n,maxY=n,maxZ=n;
        int[] locX = new int[m+2];
        int[] locY = new int[m+2];
        int[] locZ = new int[m+2];
        locX[0]=0;
        locX[1]=n;
        locY[0]=0;
        locY[1]=n;
        locZ[0]=0;
        locZ[1]=n;
        int Xs=2,Ys=2,Zs=2;
        for (int i = 0; i < m; i++) {
            int temp=0;
            int max=0;
            if(cut[i]==0){
                while (loc[i]>locX[temp]){
                    temp++;
                }
                for (int j = Xs; j >temp ; j--) {
                    locX[j]=locX[j-1];
                }
                locX[temp]=loc[i];
                Xs++;
                for (int j = 1; j < Xs; j++) {
                    max=Math.max(locX[j]-locX[j-1],max);
                }
                maxX=max;
            }else if(cut[i]==1){
                while (loc[i]>locY[temp]){
                    temp++;
                }
                for (int j = Ys; j >temp ; j--) {
                    locY[j]=locY[j-1];
                }
                locY[temp]=loc[i];
                Ys++;
                for (int j = 1; j < Ys; j++) {
                    max=Math.max(locY[j]-locY[j-1],max);
                }
                maxY=max;
            }else{
                while (loc[i]>locZ[temp]){
                    temp++;
                }
                for (int j = Zs; j >temp ; j--) {
                    locZ[j]=locZ[j-1];
                }
                locZ[temp]=loc[i];
                Zs++;
                for (int j = 1; j < Zs; j++) {
                    max=Math.max(locZ[j]-locZ[j-1],max);
                }
                maxZ=max;
            }
            System.out.println(maxX*maxY*maxZ);
        }

    }
}
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = in.nextInt();
//        }
//        int[] dpL=new int[n];
//        int[] dpR=new int[n];
//        dpL[0]=nums[0];
//        dpR[n-1]=nums[n-1];
//        for (int i = 1; i < n; i++) {
//            dpL[i]=Math.max(nums[i],nums[i]+dpL[i-1]);
//            dpR[i]=Math.max(nums[n-1-i],nums[n-1-i]+dpR[n-i]);
//        }
//        dpL[0]=Math.max(0,nums[0]);
//        dpR[n-1]=Math.max(0,nums[n-1]);
//        for (int i = 1; i < n; i++) {
//            dpL[i]=Math.max(0,nums[i]+dpL[i-1]);
////            System.out.println(dpL[i]);
//            dpR[n-1-i]=Math.max(0,nums[n-1-i]+dpR[n-i]);
////            System.out.println(dpR[i]);
//        }
//        int tempLMax=dpL[0],tempRMax=dpR[n-1];
//        for (int i = 1; i < n; i++) {
//            dpL[i]=Math.max(dpL[i],tempLMax);
//            dpR[n-1-i]=Math.max(dpR[n-1-i],tempRMax);
//            tempLMax=Math.max(dpL[i],tempLMax);
//            tempRMax=Math.max(dpR[n-1-i],tempRMax);
//        }
//        int res=Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            res=Math.max(res,dpL[i]+dpR[i]);
//        }
//        System.out.println(res);
//
//    }
//}
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int[] count = new int[n];
//        int[] curPlus = new int[n];
//        int[] nums = new int[n];
//        int plus = 0;
//        for (int i = 0; i < n; i++) {
//            nums[i] = in.nextInt();
//        }
//
//        for (int i = 0; i < m; i++) {
//            if (in.nextInt() == 1) {
//
//                int start = in.nextInt();
//                int end = in.nextInt();
//                for (int j = start - 1; j < end; j++) {
//                    count[j]++;
//                    plus += curPlus[j];
//                }
//            } else {
//                int start = in.nextInt();
//                int end = in.nextInt();
//                int temp = in.nextInt();
//                for (int j = start - 1; j < end; j++) {
//                    curPlus[j] += temp;
//                }
//            }
//        }
//        Arrays.sort(nums);
//        Arrays.sort(count);
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            res += count[i] * nums[i];
//        }
//        res += plus;
//        System.out.println(res);
//
//    }
//}
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n=in.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i]=in.nextInt();
//        }
////        int n=6;
////        int[] nums = new int[]{1,2,3,5,6,7};
//        Arrays.sort(nums);
//        int[] size = new int[n];
//        int curSize=1,loc=0;
//        for (int i = 1; i < n; i++) {
//            if(nums[i]==nums[i-1]+1){
//                curSize++;
//            }else if(nums[i]==nums[i-1]){
//                continue;
//            }else {
//                size[loc]=curSize;
//                curSize=1;
//                loc++;
//            }
//        }
//        size[loc]=curSize;
//        int res=0;
//        for (int i = 0; i < n; i++) {
//            if(size[i]==0) break;
//            System.out.println(size[i]);
//            res+=(size[i]+1)/2;
//        }
//        System.out.println(res);
//
//    }
//}
