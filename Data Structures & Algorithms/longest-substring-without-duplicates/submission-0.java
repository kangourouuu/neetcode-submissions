class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int res = 0;
        HashSet<Character> map = new HashSet<>();

        for (int r = 0; r < s.length(); r++) {
            while (map.contains(s.charAt(r))) {
                map.remove(s.charAt(l));
                l++;
            }
            map.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
