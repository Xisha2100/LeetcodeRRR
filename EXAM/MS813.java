package top.nzhz;


public class Main {

    public static void main(String[] args) {

    }

    class Solution {
        public int solution(int[] A, int X, int Y) {
            // write your code in Java 8 (Java SE 8)
            int res = Integer.MAX_VALUE;
            int N = A.length;
            for (int i = 0; i < Y; i++) {
                int endLoc = i + (X - 1) * Y;
                if (endLoc >= N) {
                    break;
                }
                int sum = 0;
                for (int j = 0; j < X; j++) {
                    sum += A[i + j * Y];
                }
                res = Math.min(res, sum);
                endLoc += Y;
                while (endLoc < N) {
                    sum -= A[endLoc - X * Y];
                    sum += A[endLoc];
                    res = Math.min(res, sum);
                    endLoc += Y;
                }
            }
            return res;
        }
    }

//    class Solution {
//        public int solution(int[] X, int[] Y) {
//            // write your code in Java 8 (Java SE 8)
//            HashMap<Integer, int[]> fraMap = new HashMap<>();
//            for (int i = 0; i < X.length; i++) {
//                if (X[i] < Y[i]) {
//                    int div = gcd(X[i], Y[i]);
//                    int numerator = X[i] / div;
//                    int denominator = Y[i] / div;
//                    if (!fraMap.containsKey(denominator)) {
//                        fraMap.put(denominator, new int[denominator - 1]);
//                    }
//                    int[] sons = fraMap.get(denominator);
//                    sons[numerator - 1]++;
//                }
//            }
//            int res = 0;
//            if (fraMap.containsKey(2)) {
//                int[] sons = fraMap.remove(2);
//                res += sons[0] * (sons[0] - 1) / 2;
//            }
//            for (int denominator : fraMap.keySet()) {
//                int[] sons = fraMap.get(denominator);
//                for (int i = 0; i < (denominator - 1) / 2; i++) {
//                    res += sons[i] * sons[denominator - 2 - i];
//                }
//            }
//            return res;
//        }
//
//        private int gcd(int a, int b) {
//            if (b % a == 0) return a;
//            else return gcd(b % a, a);
//        }
//    }

//    class Solution {
//        public int solution(int[] A) {
//            // write your code in Java 8 (Java SE 8)
//            PriorityQueue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder());
//            double sum = 0;
//            for (int num : A) {
//                queue.add((double) num);
//                sum += num;
//            }
//            double target = sum / 2;
//            int res=0;
//            while (sum > target) {
//                double num = queue.poll() / 2;
//                sum -= num;
//                queue.add(num);
//                res++;
//            }
//            return res;
//        }
//    }

}

