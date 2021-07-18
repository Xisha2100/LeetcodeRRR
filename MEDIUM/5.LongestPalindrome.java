package top.nzhz;


import java.util.Arrays;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String sCode = preCode(s);
        int len = sCode.length();

        int[] armLen = new int[len];
        int pos = 0, right = 0;

        int start = 0, end = 0;

        for (int i = 0; i < len - 1; i++) {
            int curArmLen;
            if (right >= i) {
                int iMirror = pos * 2 - i;
                int minArmLen = Math.min(armLen[iMirror], right - i);
                curArmLen = expand(sCode, i - minArmLen, i + minArmLen);
            } else {
                curArmLen = expand(sCode, i, i);
            }
            armLen[i] = curArmLen;
            if (i + curArmLen > right) {
                pos = i;
                right = i + curArmLen;
            }
            if (curArmLen * 2 + 1 > end - start) {
                start = i - curArmLen;
                end = i + curArmLen;
            }
        }

        StringBuffer ans = new StringBuffer();
        for (int i = start; i <= end; ++i) {
            if (sCode.charAt(i) != '#') {
                ans.append(sCode.charAt(i));
            }
        }
            return ans.toString();


    }


    public String preCode(String s) {
        int len = s.length();

        if (len == 0) {
            return "##";
        }

        StringBuffer ans = new StringBuffer("");

        for (int i = 0; i < len; i++)
            ans.append('#').append(s.charAt(i));

        ans.append("#");

        return ans.toString();
    }

    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return (right - left - 2) / 2;
    }

}
