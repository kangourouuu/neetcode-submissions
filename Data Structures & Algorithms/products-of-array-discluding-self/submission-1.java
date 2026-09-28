class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Time compl: O(n), because we browse three arrays independently
        // Space compl: We declare 3 arrays as prefix, suffix, res, so we can get the O(n) because each array have O(n) space compl
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] res = new int[n];
        
        prefix[0] = 1;
        suffix[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }
}  
