//输入一个字符串，打印出该字符串中字符的所有排列。
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 👍 487 👎 0


package top.nzhz.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res;
        boolean[] flag;
        char[] arr;
        public String[] permutation(String s) {
            flag=new boolean[s.length()];
            res=new ArrayList<String>();
            arr = s.toCharArray();
            Arrays.sort(arr);
            StringBuilder list = new StringBuilder();
            backtrack(0,s.length(),list);
            String[] resS=new String[res.size()];
            for (int i = 0; i < res.size(); i++) {
                resS[i]=res.get(i);
            }
            return resS;
        }

        private void backtrack(int cur , int len , StringBuilder list){
            if(cur==len) {
                res.add(list.toString());
                return;
            }
            for (int j = 0; j < len; j++) {
                if(flag[j]||(j>0&&!flag[j-1]&&arr[j-1]==arr[j])) continue;
                flag[j]=true;
                list.append(arr[j]);
                backtrack(cur+1,len,list);
                list.deleteCharAt(list.length()-1);
                flag[j]=false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}