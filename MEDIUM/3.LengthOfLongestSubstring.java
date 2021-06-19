package top.nzhz;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {


    //方法效果一般，滑动法，没有使用HashSet减少运行时间
    public int lengthOfLongestSubstring1(String s) {
        int max = 0, silp = 0;
        StringBuilder temp = new StringBuilder(s);
        while (max < temp.length()) {
            while (silp < temp.length() && temp.indexOf(String.valueOf(temp.charAt(silp))) == silp) {
                System.out.println(temp);
                silp++;
            }
            if (max < silp)
                max = silp;
            System.out.println(max);
            if (silp >= temp.length())
                break;
            int locate = temp.indexOf(String.valueOf(temp.charAt(silp)));

            temp.delete(0, locate + 1);
            silp = silp - locate;
            System.out.println(temp);
        }
        return max;
    }

    //改进
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> tempSet = new HashSet<Character>();
        int sLength = s.length();
        int max = 0;
        int rk = 0, lk = 0;

        while (rk < sLength) {
            while (rk < sLength && !tempSet.contains(s.charAt(rk))) {
                tempSet.add(s.charAt(rk));
                rk++;
            }

            max = Math.max(max, rk - lk);

            if (rk == sLength) {
                break;
            }

            while (tempSet.contains(s.charAt(rk))) {
                tempSet.remove(s.charAt(lk));
                lk++;
            }

            max = Math.max(max, rk - lk + 1);

        }
        return max;
    }

    //最终版，调整了方法2的顺序，更高效
    public int lengthOfLongestSubstring(String s) {
        Set<Character> tempSet = new HashSet<Character>();
        int sLength = s.length();
        int max = 0;
        int rk = 0, lk = 0;

        while (lk + max < sLength) {
            while (tempSet.contains(s.charAt(rk))) {
                tempSet.remove(s.charAt(lk));
                lk++;
            }

            while (rk < sLength && !tempSet.contains(s.charAt(rk))) {
                tempSet.add(s.charAt(rk));
                rk++;
            }

            max = Math.max(max, rk - lk);
        }
        return max;
    }
}
