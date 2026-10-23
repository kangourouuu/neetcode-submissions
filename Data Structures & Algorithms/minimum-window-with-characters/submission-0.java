class Solution {
    public String minWindow(String s, String t) {
      int l = 0;
      int[] window = new int[128], countT = new int [128];
      int res = Integer.MAX_VALUE;
      int n1 = s.length(), n2 = t.length();
      int have = 0, need = 0;
      int bestStart = -1;

      if (n2 > n1 || n2 == 0) return "";

      for (char c : t.toCharArray()) {
        if (countT[c] == 0) need++;
        countT[c]++;
      }

      for (int r = 0; r < n1; r++) {
        char c = s.charAt(r);
        window[c]++;

        if (countT[c] > 0 && window[c] == countT[c]) have++;

        while (have == need) {
            if (r - l + 1 < res) {
                res = r - l + 1;
                bestStart = l;
            }

            char leftChar = s.charAt(l);
            window[leftChar]--;

            if (countT[leftChar] > 0 && window[leftChar] < countT[leftChar]) have--;
            l++;
        }
      }
      return res == Integer.MAX_VALUE ? "" : s.substring(bestStart, res + bestStart);
    }
}
