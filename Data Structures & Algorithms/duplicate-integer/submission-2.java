class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> hasDuplicated = new HashSet<>();
        boolean isDuplicated = false;

        for (int i = 0; i < nums.length; i++) {
            if (!hasDuplicated.add(nums[i])) {
                isDuplicated = true;
            }
        }
        return isDuplicated;
    }
}