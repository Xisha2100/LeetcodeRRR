package top.nzhz;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int length = s.length();
        String temp = null;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                int j = 0;
                while (j <= i && i + j + 1 < s.length()) {
                    j++;
                    if (s.charAt(i - j) != s.charAt(i + j + 1))
                        break;

                }
                if (temp.length() < s.substring(i - j + 1, i + j).length())
                    temp = s.substring(i - j + 1, i + j);
            } else {
                
            }
        }
    }
}
