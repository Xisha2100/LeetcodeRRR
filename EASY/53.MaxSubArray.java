package top.nzhz;

public class MaxSubArray {
    //方案一
    public int maxSubArray(@org.jetbrains.annotations.NotNull int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
  //方案二
    public class Status {
        public int lSum, rSum, maxSum, allSum;

        public Status(int lSum, int rSum, int maxSum, int allSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.maxSum = maxSum;
            this.allSum = allSum;
        }
    }

    public int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).maxSum;
    }

    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) / 2;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r) {
        int allSum = l.allSum + r.allSum;
        int lSum = Math.max(l.lSum, l.allSum + r.lSum);
        int rSum = Math.max(r.rSum, r.allSum + l.rSum);
        int maxSum = Math.max(Math.max(l.maxSum,r.maxSum),l.rSum+r.lSum);
        return new Status(lSum, rSum, maxSum, allSum);
    }

    public static void main(String[] args) {
        MaxSubArray msa = new MaxSubArray();
        int[] a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(msa.maxSubArray(a));
    }
}



