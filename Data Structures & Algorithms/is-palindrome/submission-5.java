class Solution {
    public boolean isPalindrome(String s) {
        String acceptableString = s.replaceAll("[^\\p{L}\\p{N}]", "");
        String normalizedString = acceptableString.trim().toLowerCase();
        int l = normalizedString.length() - 1;
        boolean isEqual = false;
        int i = 0;
        int j = l;

        if (normalizedString.isEmpty()) {return true;}
        if (normalizedString.length() == 1) {return true;}

        while (i < l && j > 0) {
            if (i == j) {return true;}

            if (normalizedString.charAt(i) != normalizedString.charAt(j)) {
                return false;
            }
            
            isEqual = true;
            i++;
            j--;
        }

        return isEqual;
    }
}
