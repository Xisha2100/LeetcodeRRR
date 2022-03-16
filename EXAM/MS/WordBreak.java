//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1478 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Trie root = new Trie();
            root.insert(wordDict);
            return root.find(s,0);
        }


        class Trie {
            Trie[] children;
            boolean isEnd;
            boolean[] failed;

            public Trie(){
                children=new Trie[26];
                isEnd=false;
            }

            public void insert(List<String> wordDict){
                for(String word:wordDict){
                    Trie node=this;
                    for (int i = 0; i < word.length(); i++) {
                        int index=word.charAt(i)-'a';
                        if(node.children[index]==null){
                            node.children[index]=new Trie();
                        }
                        node=node.children[index];
                    }
                    node.isEnd=true;
                }
            }

            public boolean find(String s, int loc){
                if(failed==null) failed=new boolean[s.length()+1];
                if(failed[loc]) return false;
                if(loc>=s.length()) return true;
                Trie node= this;
                for (int i = loc; i <s.length() ; i++) {
                    int index=s.charAt(i)-'a';
                    if(node.children[index]==null) return false;
                    node=node.children[index];
                    if(node.isEnd){
                        if(find(s,i+1))return true;
                        failed[i+1]=true;
                    }
                }
                return false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}