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
    public int lengthOfLongestSubstring(String s) {
        Set<Character> tempSet = new HashSet<Character>();
        int sLength = s.length();
        int rk = 0, lk;
        for (int i = 0; i < sLength; i++) {
            while (rk < sLength && !tempSet.contains(s.charAt(rk))){
                tempSet.add(s.charAt(rk));
                rk++;
            }
            while (s.charAt())
        }
    }
}
