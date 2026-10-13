class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> num : freqMap.entrySet()) {
            freq[num.getValue()].add(num.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = freq.length - 1; i > 0; i--) {
            for (int n : freq[i]) {
                res[idx++] = n;
                if (idx == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
