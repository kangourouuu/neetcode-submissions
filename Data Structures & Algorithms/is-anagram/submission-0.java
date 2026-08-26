class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        String toStringS = new String(sArray);

        char[] tArray = t.toCharArray();
        Arrays.sort(tArray);
        String toStringT = new String(tArray);

        if (!toStringS.equals(toStringT)) return false;
        return true;
    }
}
