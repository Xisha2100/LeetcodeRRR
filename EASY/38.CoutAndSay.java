package top.nzhz;

public class CoutAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String Cou = countAndSay(n - 1);
        StringBuffer res = new StringBuffer();
        int start = 0, last = 1;
        while (last <= Cou.length()) {
            if (Cou.charAt(last) != Cou.charAt(start)) {
                res.append(last - start).append(Cou.charAt(start));
                start = last;
            }
            last++;
        }
        res.append(last - start).append(Cou.charAt(start));
        return res.toString();
    }
}
