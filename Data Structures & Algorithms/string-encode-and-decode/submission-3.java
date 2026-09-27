class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for (String s : strs) {
            res += Integer.toString(s.length()) + "#" + s;
        }
        System.out.println(res);
        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            System.out.println("length" + length);
            System.out.println("i" + i);
            System.out.println("j" + j);
            res.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }
        return res;
    }
}
