class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String string = new String(charArr);
            res.putIfAbsent(string, new ArrayList<>());
            res.get(string).add(s);
        }

        return new ArrayList<>(res.values());
    }
}
