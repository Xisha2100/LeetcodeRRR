package top.nzhz;

public class MySqrt {
    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }

    public static void main(String[] args) {
        MySqrt ms = new MySqrt();
        System.out.println(ms.mySqrt(15));
    }
}
