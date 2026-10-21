public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // matches = 22 - 23 - 24 - 25 - 26 -> return true here
        // int r = s1.length; r < s2.length; r++ 
        // Time cpl: Om + On + O26 -> Total On
        // Space cpl: O1

        int l = 0, matches = 0;
        int n1 = s1.length();
        int n2 = s2.length();
        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];
        if (n1 > n2) return false;
        for (int i = 0; i < n1; i++) {
            s1Counts[s1.charAt(i) - 'a']++;
            s2Counts[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (s1Counts[i] == s2Counts[i]) {
                matches++;
            }
        }

        for (int r = n1; r < n2; r++) {
            if (matches == 26) return true;
            int idx = s2.charAt(r) - 'a';
            s2Counts[idx]++;
            if (s1Counts[idx] == s2Counts[idx]) matches++;
            else if (s1Counts[idx] + 1 == s2Counts[idx]) matches--;
            idx = s2.charAt(l) - 'a';
            s2Counts[idx]--;
            if (s1Counts[idx] == s2Counts[idx]) matches++;
            else if (s1Counts[idx] - 1 == s2Counts[idx]) matches--;
            l++;
        }
        return matches == 26;
    }
}