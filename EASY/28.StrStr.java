package top.nzhz;

public class StrStr {
    //方法一
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
    //方法二
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
    //方法三：常数时间，Hash，但是耗时增加很多，是个为了用方法而用的
    public int strStr(String haystack, String needle) {
        int H_len = haystack.length();
        int N_len = needle.length();

        if (H_len < N_len) return -1;

        int ch = 26;
        long modulus = (long) Math.pow(2, 31);

        long H_hash = 0, N_hash = 0, Inter_Num = 1;
        for (int i = 0; i < N_len; i++) {
            H_hash = (H_hash * ch + charToInt(i, haystack)) % modulus;
            N_hash = (N_hash * ch + charToInt(i, needle)) % modulus;
            Inter_Num = (Inter_Num * ch) % modulus;
        }
        if (H_hash == N_hash) return 0;

        for (int j = 0; j < H_len - N_len; j++) {
            H_hash = (H_hash * ch - charToInt(j, haystack) * Inter_Num + charToInt(j + N_len, haystack)) % modulus;
            if (H_hash == N_hash) return j + 1;
        }
        return -1;
    }

    public int charToInt(int idx, String s) {
        return (int) s.charAt(idx) - (int) 'a';
    }
}
