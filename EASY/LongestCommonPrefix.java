package top.nzhz;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }
        int strsNum = strs.length;
        int ansLen = strs[0].length();
        for (int i = 0; i < ansLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strsNum; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i))
                    //
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}


