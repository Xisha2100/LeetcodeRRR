//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> 
//s2 -> ... -> sk： 
//
// 
// 每一对相邻的单词只差一个字母。 
// 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。 
// sk == endWord 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 
//中的 单词数目 。如果不存在这样的转换序列，返回 0 。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 哈希表 字符串 👍 1001 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
        int res = solution.ladderLength("hit", "cog", new ArrayList<>() {{
            add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
            add("cog");
        }});
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) return 0;
            wordList.add(beginWord);
            Set<String> wordSet = new HashSet<>(wordList);
            int step = 1;

            LinkedList<String> fifo1 = new LinkedList<>();
            LinkedList<String> fifo2 = new LinkedList<>();
            fifo1.offerFirst(beginWord);
            fifo2.offerFirst(endWord);


            HashSet<String> isAccessed1 = new HashSet<>();
            HashSet<String> isAccessed2 = new HashSet<>();
            isAccessed1.add(beginWord);
            isAccessed2.add(endWord);

            int fifo1Size = 1;
            int fifo2Size = 1;

            while (!fifo1.isEmpty() && !fifo2.isEmpty()) {
                fifo1Size = fifo1.size();
                fifo2Size = fifo2.size();
                if(fifo1Size>fifo2Size){
                    HashSet<String> isAE=isAccessed1;
                    isAccessed1=isAccessed2;
                    isAccessed2=isAE;
                    LinkedList fifoE=fifo1;
                    fifo1=fifo2;
                    fifo2=fifoE;
                }
                fifo1Size = fifo1.size();
                step++;
                for (int i = 0; i < fifo1Size; i++) {
                    String curStr = fifo1.pollLast();
                    wordSet.remove(curStr);
                    char[] chars=curStr.toCharArray();
                    for (int j = 0; j < curStr.length(); j++) {
                        char temp=chars[j];
                        for (char k = 'a'; k <= 'z'; k++) {
                            chars[j]=k;
                            String covStr=String.copyValueOf(chars);
                            if(wordSet.contains(covStr)){
                                if(isAccessed2.contains(covStr)) return step;
                                fifo1.offerFirst(covStr);
                                isAccessed1.add(covStr);
                            }
                        }
                        chars[j]=temp;
                    }
//                    for (String[] e : edge) {
//                        if (curStr.equals(e[0])) {
//                            if (isAccessed2.contains(e[1])) return step;
//                            fifo1.offerFirst(e[1]);
//                            isAccessed1.add(e[1]);
//                        } else if (curStr.equals(e[1])) {
//                            continue;
//                        } else {
//                            tempEdge.add(e);
//                        }
//                    }
//                    edge = tempEdge;
                }

            }
            return 0;

        }


//        private void addWord(List<String> wordList) {
//            wordSet=new HashSet<>(wordList);
//        }
//
//        private void addEdge() {
//            for (String s1 : wordSet) {
//                char[] chars = s1.toCharArray();
//                for (int i = 0; i < chars.length; i++) {
//                    char temp = chars[i];
//                    for (char j = 'a'; j <= 'z'; j++) {
//                        chars[i] = j;
//                        String s2 = String.copyValueOf(chars);
//                        if (wordSet.contains(s2))
//                            edge.add(new String[]{s1, s2});
//                    }
//                    chars[i] = temp;
//                }
////                for (String s2 : wordId.keySet()) {
////                    if (edge.contains(new int[]{wordId.get(s2), wordId.get(s1)}))
////                        edge.add(new int[]{wordId.get(s1), wordId.get(s2)});
////                    if (isDiff1(s1, s2)) edge.add(new int[]{wordId.get(s1), wordId.get(s2)});
////                }
//            }
//        }
//
//        private boolean isDiff1(String a, String b) {
//            if (a.equals(b)) return false;
//            int difNum = 0;
//            for (int i = 0; i < a.length(); i++) {
//                if (a.charAt(i) != b.charAt(i)) difNum++;
//                if (difNum > 1) return false;
//            }
//            return true;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}