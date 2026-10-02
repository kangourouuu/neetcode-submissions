class Solution {
    public int longestConsecutive(int[] nums) {
        // Time compl: Browse to fill the set with O(n), browse the set with O(n), at the end we will get O(n)
        // Space compl: nums is the array of input - do not count it, we use one more set to store the element of input array, the set will have n element, so the space compl is O(n)

        Set<Integer> set = new HashSet<>();
        int longest = 0;

        for (int n : nums) {
            set.add(n);
        }

        for (int n : set) {
            int length = 0;
            if (!set.contains(n - 1)) {
                while (set.contains(n + length)) {
                    length++;
                }
            }
            longest = Math.max(longest, length);
        }

        return longest;
    }
}
