package top.nzhz;

public class StrStr {
    public int strStr(String haystack, String needle) {
        int H_len = haystack.length();
        int N_len = needle.length();

        for (int start = 0; start < H_len - N_len + 1; start++) {
            if (haystack.substring(start, start+N_len).equals(needle)){
                return start;
            }
        }
        return -1;
    }
    
    public int strStr(String haystack, String needle) {
        int H_len = haystack.length();
        int N_len = needle.length();

        if (N_len == 0) return 0;

        for (int i = 0; i <= H_len - N_len; i++) {
            for (int j = 0; j < N_len; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) break;
                if (j == N_len - 1) return i;
            }
        }
        return -1;
    }
}
