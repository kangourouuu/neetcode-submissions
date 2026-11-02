class Solution {
    public int maxArea(int[] heights) {
        int l = heights.length;
        int left =0, right = l - 1;
        int res = 0, area = 0;
        
        while (left < right) {
            area = (right - left) * Math.min(heights[left], heights[right]);
            res = Math.max(res, area);

            if (heights[left] < heights[right]) left++;
            else right--;
        }

        return res;
    }
}
