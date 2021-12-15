//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼
//写检查。 
//
// 请你实现 Trie 类： 
//
// 
// Trie() 初始化前缀树对象。 
// void insert(String word) 向前缀树中插入字符串 word 。 
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 
//false 。 
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word 和 prefix 仅由小写英文字母组成 
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 10⁴ 次 
// 
// Related Topics 设计 字典树 哈希表 字符串 👍 981 👎 0


package top.nzhz.leetcode.editor.cn;

public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie solution = new ImplementTriePrefixTree().new Trie();
        solution.insert("apple");
        solution.search("apple");

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        private Trie[] children;
        private boolean exixt;

        public Trie() {
            children=new Trie[26];
            exixt=false;
        }

        public void insert(String word) {
            Trie root = this;

            for (int i = 0; i < word.length(); i++) {
                char c=word.charAt(i);
                int index=c-'a';
                if(root.children[index]==null){
                    root.children[index]=new Trie();
                }
                root=root.children[index];
            }
            root.exixt=true;
        }

        public boolean search(String word) {
            Trie root = this;
            for (int i = 0; i < word.length(); i++) {
                char c=word.charAt(i);
                int index=c-'a';
                if(root.children[index]==null){
                    return false;
                }
                root=root.children[index];
            }
            return root.exixt;
        }

        public boolean startsWith(String prefix) {
            Trie root = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c=prefix.charAt(i);
                int index=c-'a';
                if(root.children[index]==null){
                    return false;
                }
                root=root.children[index];
            }
            return true;
        }
//        个人实现方法
//        class Tree {
//            char val;
//            boolean exist;
//            HashMap<Character, Tree> treeMap;
//
//            public Tree(char val, HashMap<Character, Tree> treeMap) {
//                this.val = val;
//                this.exist = false;
//                this.treeMap = treeMap;
//            }
//        }
//
//        private Tree root;
//
//        public Trie() {
//            root = new Tree('n', new HashMap<>());
//        }
//
//        public void insert(String word) {
//            Tree temp = root;
//            for (int i = 0; i < word.length(); i++) {
//                if (!temp.treeMap.containsKey(word.charAt(i))) {
//                    temp.treeMap.put(word.charAt(i), new Tree(word.charAt(i), new HashMap<>()));
//                }
//                temp = temp.treeMap.get(word.charAt(i));
//            }
//            temp.exist = true;
//        }
//
//        public boolean search(String word) {
//            Tree temp = root;
//            for (int i = 0; i < word.length(); i++) {
//                if (temp.treeMap.containsKey(word.charAt(i)))
//                    temp = temp.treeMap.get(word.charAt(i));
//                else return false;
//            }
//            if (temp.exist) return true;
//            return false;
//        }
//
//        public boolean startsWith(String prefix) {
//            Tree temp = root;
//            for (int i = 0; i < prefix.length(); i++) {
//                if (temp.treeMap.containsKey(prefix.charAt(i)))
//                    temp = temp.treeMap.get(prefix.charAt(i));
//                else return false;
//            }
//            return true;
//        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}