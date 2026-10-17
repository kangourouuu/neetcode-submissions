public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int l = 0, res = 0;

        for (int r = 0; r < s.length(); r++) {
            if (count.containsKey(s.charAt(r))) {
                l = Math.max(l, count.get(s.charAt(r)) + 1);
            }
            count.put(s.charAt(r), r);
            res = Math.max(r - l + 1, res);
        }

        return res;
    }
}