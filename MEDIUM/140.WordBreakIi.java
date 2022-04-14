//给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可
//能的句子。 
//
// 注意：词典中的同一个单词可能在分段中被重复使用多次。 
//
// 
//
// 示例 1： 
//
// 
//输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
//输出:["cats and dog","cat sand dog"]
// 
//
// 示例 2： 
//
// 
//输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine",
//"pineapple"]
//输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//输出:[]
// 
//
// 
//
// 提示： 
//
// 
//
// 
// 1 <= s.length <= 20 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 10 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中所有字符串都 不同 
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 回溯 👍 580 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreakIi {
    public static void main(String[] args) {
        Solution solution = new WordBreakIi().new Solution();
        solution.wordBreak("catsanddog",new ArrayList<String>(Arrays.asList("cat","cats","and","sand","dog")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        StringBuilder sentence;
        boolean[][] isContain;
        ArrayList<String> res;
        public List<String> wordBreak(String s, List<String> wordDict) {
//            HashSet<String> words = new HashSet<>(wordDict);
            int len=s.length();
            res=new ArrayList<>();
            isContain = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    if(wordDict.contains(s.substring(i,j+1)))
                        isContain[i][j]=true;
                }
            }
            sentence=new StringBuilder();
            dfs(s,0);
            return res;
        }

        private  void dfs(String s,int start){
            int len=s.length();
            if(start==len){
                sentence.deleteCharAt(sentence.length()-1);
                res.add(sentence.toString());
                sentence.append(' ');
                return;
            }
            for (int i = start; i < len; i++) {
                if(isContain[start][i]){
                    sentence.append(s.substring(start,i+1)+' ');
                    dfs(s,i+1);
                    sentence.delete(sentence.length()-i+start-2,sentence.length());
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}