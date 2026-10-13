public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<int[]> tempList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> num : map.entrySet()) {
            tempList.add(new int[]{num.getValue(), num.getKey()});
        }
        tempList.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = tempList.get(i)[1];
        }
        return res;
    }
}