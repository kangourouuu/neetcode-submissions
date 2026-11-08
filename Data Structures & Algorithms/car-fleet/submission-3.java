class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[] speedAtPos = new int[target];

        for (int i = 0; i < position.length; i++) {
            speedAtPos[position[i]] = speed[i];
        }

        int fleets = 0;
        double maxTime = 0.0;

        for (int i = target - 1; i >= 0; i--) {
            if (speedAtPos[i] > 0) {
                double time = (double) (target - i) / speedAtPos[i];

                if (time > maxTime) {
                    maxTime = time;
                    fleets++;
                }
            }
        }

        return fleets;
    }
}
