class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> substractMap = new HashMap<>();

        for (int i =0; i < nums.length; i++) {
            int complementary = target - nums[i];
            if (substractMap.containsKey(complementary)) {
                return new int[]{substractMap.get(complementary), i};
            }
            substractMap.put(nums[i], i);
        }
        return new int[]{0, 1};
    }
}
