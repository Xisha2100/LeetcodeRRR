package top.nzhz;


import java.util.*;

public class Main {
//    private List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s=in.next();
        String key=in.next();

        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        int cnt=0;
        int start=0;
        for (int i = 0; i < s.length(); i++) {
            if(cnt==0){
                if(s.charAt(i)==key.charAt(cnt)){
                    cnt++;
                    start=i;
                    continue;
                }
            }
            if(s.charAt(i)==key.charAt(cnt)){
                cnt++;
            }
            if(cnt==key.length()){
                list.add(s.substring(start,i+1));
                cnt=0;
            }
        }
        String res=list.get(0);
        for (String s1:list) {
            cnt=key.length()-1;
            for (int i = s1.length()-1; i >=0 ; i--) {
                if(s1.charAt(i)==key.charAt(cnt)){
                    if(cnt==0){
                        if(res.length()>s1.length()-i){
                            res=s1.substring(i);
                            continue;
                        }
                    }
                    cnt--;
                }
            }
        }
        System.out.println(res);

    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String expression = in.next();
//        ArrayList<Integer> numList = new ArrayList<>();
//        ArrayList<Character> equList = new ArrayList<>();
//        int temp = 0;
//        for (int i = 0; i < expression.length(); i++) {
//            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
//                numList.add(temp);
//                temp = 0;
//                equList.add(expression.charAt(i));
//            } else {
//                temp = temp * 10 + (expression.charAt(i) - '0');
//            }
//        }
//        numList.add(temp);
//        Main main = new Main();
//        List<Integer> res=main.dfs(numList,0,numList.size()-1 ,equList,0,equList.size()-1);
//        System.out.println(res);
//    }
//
//    private List<Integer> dfs(ArrayList<Integer> numList, int nLeft , int nRight, ArrayList<Character> equList,int eLeft,int eRight) {
//        if(nLeft==nRight){
//            return new ArrayList<Integer>(){{
//                add(numList.get(nLeft));
//            }};
//        }
//        ArrayList<Integer> resList = new ArrayList<>();
//        for (int i = eLeft; i <= eRight; i++) {
//            char equ = equList.remove(i);
//            List<Integer> leftList=dfs(numList,nLeft,i,equList,eLeft,i);
//            List<Integer> rightList=dfs(numList,i+1,nRight,equList,i+1,eRight);
//
//            if (equ == '+') {
//                for(int leftNum:leftList){
//                    for (int rightNum:rightList) {
//                        resList.add(leftNum+rightNum);
//                    }
//                }
//            } else if (equ == '-') {
//                for(int leftNum:leftList){
//                    for (int rightNum:rightList) {
//                        resList.add(leftNum-rightNum);
//                    }
//                }
//            } else {
//                for(int leftNum:leftList){
//                    for (int rightNum:rightList) {
//                        resList.add(leftNum*rightNum);
//                    }
//                }
//            }
//        }
//        return resList;
//    }



}

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        double res = 0;
//        for (int i = 0; i < n; i++) {
//            double num=in.nextDouble();
//            res+=Math.abs(num-0.5)+0.5;
//        }
//        System.out.printf("%.4f\n",res);
//    }
