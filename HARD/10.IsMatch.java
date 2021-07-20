package top.nzhz;

public class IsMatch {
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if(pLen==0&&sLen!=0)
            return false;
        if(sLen==0)


        for(int j =pLen-1; j>=0; j--){
            if(p.charAt(j)=='*') {
                j--;
                while (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
                    i--;
            }
            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')

        }
    }
}
