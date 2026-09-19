class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        int n = numbers.length;
        int i = 0;
        int j = n - 1;

        while (i < n && j > 0 && i < j) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] == target) {
                return new int[] {i + 1, j + 1};
            }
        }
        return new int[0];
    }
}
