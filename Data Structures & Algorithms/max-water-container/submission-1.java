public class Solution {
    public int maxArea(int[] heights) {
        // Time compl: use only 1 loop for it, On
        // Space compl: input is array with n value, and return the output with only one variable, so the space compl is O1
        // left pointer = first index
        // right pointer = last index
        // res = stored result
        // while (l < r)
        // calculate the are = (right poiner subtract left pointer) * min value of these height
        // res will be Max value between current res and the are
        // move the left pointer if left height less than or equal right height
        // otherwise move right pointer
        int l = 0;
        int r = heights.length - 1;
        int res = 0;
        while (l < r) {
            int area = (r - l) * Math.min(heights[l], heights[r]);
            res = Math.max(res, area);
            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}