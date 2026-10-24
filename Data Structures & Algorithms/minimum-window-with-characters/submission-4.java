class Solution {
    public String minWindow(String s, String t) {
        // l = 0
        // bestStart = -1
        // 2 int[] array = fixed size 128
        // need = 0 - required matched chars
        // have = 0 - how many matched chars with t
        // while have == need - drop the left side

        int l = 0, bestStart = - 1, res = Integer.MAX_VALUE;
        int[] countT = new int[128];
        int[] window = new int[128];
        int have = 0, need = 0;
        int n = s.length();
        if (n < t.length()) return "";

        for (char c : t.toCharArray()) {
            if (countT[c] == 0) need++;
            countT[c]++;
        }

        for (int r = 0; r < n; r++) {
            char rightChar = s.charAt(r);
            window[rightChar]++;

            if (countT[rightChar] > 0 && window[rightChar] == countT[rightChar]) {
                have++;
            }

            while (have == need) {
                char leftChar = s.charAt(l);
                window[leftChar]--;
                if (r - l + 1 < res) {
                    res = r - l + 1;
                    bestStart = l;
                }

                if (countT[leftChar] > 0 && window[leftChar] < countT[leftChar]) {
                    have--;
                }
                l++;
            }
        }

        return res == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + res);
    }
}
