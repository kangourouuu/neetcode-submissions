class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 0) {return 0;}
        int count = 1;
        int maxCount = 1;
        int i = 0;
        while (i < n - 1) {
            if (nums[i + 1] - nums[i] == 1) {
                count++;
            } else if (nums[i + 1] != nums[i]) {
                count = 1;
            }
            if (count > maxCount) {
                maxCount = count;
            }
            i++;
        }
        return maxCount;
    }
}