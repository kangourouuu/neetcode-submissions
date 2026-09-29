class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Time compl: O(n), because we browse three arrays independently
        // Space compl: We declare 3 arrays as prefix, suffix, res, so we can get the O(n) because each array have O(n) space compl
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;

        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int postFix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * postFix;
            postFix = postFix * nums[i];
        }

        return res;
    }
}  
