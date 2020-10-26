package top.nzhz;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,5};
        RemoveElement re = new RemoveElement();
        int a = re.removeElement(arr, 1);
        int b = re.removeElement(arr, 4);
        System.out.println(a);
        System.out.println(b);
    }
    public  int removeElement(int[] nums, int val) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

//
    public int removeElementS2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

}
