package top.nzhz;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        Scanner sc = new Scanner(System.in);
//
//        int topN = sc.nextInt();
//        int M = sc.nextInt();
//        sc.nextLine();
//        HashMap<String, Integer> map = new HashMap<>();
//        String[] title = new String[M];
//        String[] article = new String[M];
//        for (int i = 0; i < M; i++) {
//            title[i] = sc.nextLine();
//            article[i] = sc.nextLine();
//            String[] tempTitle = title[i].split(" ");
//            String[] tempArticle = article[i].split(" ");
//            for (int j = 0; j < title.length; j++) {
//                map.put(tempTitle[j], map.getOrDefault(tempTitle[j], 0) + 3);
//            }
//            for (int j = 0; j < article.length; j++) {
//                map.put(tempArticle[j], map.getOrDefault(tempArticle[j], 0) + 1);
//            }
//        }
//
//        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return o2.getValue().compareTo(o1.getValue());
//            }
//        });
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            queue.add(entry);
//        }
//
//        map.clear();
//        HashMap<Integer, Integer> valueMap = new HashMap<>();
//        for (int i = 0; i < topN; i++) {
//            Map.Entry<String, Integer> temp = queue.poll();
//            map.put(temp.getKey(), temp.getValue());
//            int pre = temp.getValue();
//            int count = 1;
////            valueMap.put(pre,valueMap.getOrDefault(pre,0)+1);
//            while (queue.peek().getValue() == pre ) {
//                temp = queue.poll();
//                map.put(temp.getKey(), temp.getValue());
////                valueMap.put(pre,valueMap.getOrDefault(pre,0)+1);
//                count++;
//                i++;
//            }
//            if(i<topN) {
//                while (count > 1) {
//                    for (int k = 0; k < M; k++) {
//                        String[] tempTitle = title[k].split(" ");
//                        for (int j = 0; j < title.length; j++) {
//                            if (map.containsKey(tempTitle[j])) {
//                                count--;
//                                map.remove(tempTitle[j]);
//                                System.out.print(tempTitle[j] + ' ');
//                                if (count == 1) break;
//                            }
//                        }
//                    }
//                    for (int k = 0; k < M; k++) {
//                        String[] tempArticle = article[k].split(" ");
//                        for (int j = 0; j < title.length; j++) {
//                            if (map.containsKey(tempArticle[j])) {
//                                count--;
//                                map.remove(tempArticle[j]);
//                                System.out.print(tempArticle[j] + ' ');
//                                if (count == 1) break;
//                            }
//                        }
//                    }
//                }
//                if (count == 1) {
//                    for (String s:map.keySet()) {
//                        if(i==topN-1) {
//                            System.out.println(s);
//                            return;
//                        }
//                        map.clear();
//                        System.out.print(s+' ');
//                    }
//                }
//            }else {
//                while (i-count < topN-1) {
//                    for (int k = 0; k < M; k++) {
//                        String[] tempTitle = title[k].split(" ");
//                        for (int j = 0; j < title.length; j++) {
//                            if (map.containsKey(tempTitle[j])) {
//                                count--;
//                                map.remove(tempTitle[j]);
//                                if (i-count == topN-1){
//                                    System.out.println(tempTitle[j]);
//                                    return;
//                                }
//                                System.out.print(tempTitle[j] + ' ');
//                            }
//                        }
//                    }
//                    for (int k = 0; k < M; k++) {
//                        String[] tempArticle = article[k].split(" ");
//                        for (int j = 0; j < title.length; j++) {
//                            if (map.containsKey(tempArticle[j])) {
//                                count--;
//                                map.remove(tempArticle[j]);
//                                if (i-count == topN-1){
//
//                                    System.out.println(tempArticle[j]);
//                                    return;
//                                }
//                                System.out.print(tempArticle[j] + ' ');
//                            }
//                        }
//                    }
//                }
//            }
//
//        }
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int res=0;
        LinkedList<int[]> stack = new LinkedList<>();
        stack.push(new int[]{0,-1});
        String numStr=sc.next();
        String[] nums=numStr.split(",");
        for (int i = 0; i < M; i++) {
            int curNum=Integer.parseInt(nums[i]);
            if(curNum>0) curNum=0;
            if(curNum<stack.peek()[0]){
                stack.push(new int[]{curNum,i});
            }else if(curNum>stack.peek()[0]){

                while (curNum>stack.peek()[0]){
                    int[] temp=stack.pop();
                    res+=(i-temp[1])/N*(curNum-temp[0]);
                }
                stack.push(new int[]{curNum,i});
            }

        }
        System.out.println(res);
    }
}
