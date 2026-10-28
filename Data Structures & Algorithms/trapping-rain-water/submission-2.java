class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int leftMax = height[0], rightMax = height[r];
        int res = 0;

        if (n == 0 || height == null) return 0;

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r --;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }

        return res;
    }
}
