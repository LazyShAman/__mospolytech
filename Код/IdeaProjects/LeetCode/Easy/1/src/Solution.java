public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[4];
        nums[0] = 2;
        nums[1] = 7;
        nums[2] = 11;
        nums[3] = 15;
        int target = 9;
        int[] two = twoSum(nums, target);
        System.out.println(two[0] + ", " + two[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] two = new int[2];
        boolean flag = false;
        for (int i = 0; i < nums.length-1; i++) {
            for (int k = 1; k < nums.length; k++) {
                if (nums[i] + nums[k] == target && i != k) {
                    two[0] = i;
                    two[1] = k;
                    flag = true;
                    break;
                }

                if (flag) break;
            }
        }

        return two;
    }
}
