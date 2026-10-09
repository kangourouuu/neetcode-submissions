class Solution {
    public boolean isAnagram(String s, String t) {
        char[] firstStr = s.toCharArray();
        char[] secondStr = t.toCharArray();

        Arrays.sort(firstStr);
        Arrays.sort(secondStr);
        if (Arrays.equals(firstStr, secondStr)) {
            return true;
        }

        return false;
    }
}
