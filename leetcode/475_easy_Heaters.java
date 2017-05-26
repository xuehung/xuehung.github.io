public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int minRadius = Integer.MIN_VALUE;
        int heaterPtr = 0;
        for (int housePtr = 0 ; housePtr < houses.length ; housePtr++) {
            // Find the first heater which is greater than house.
            while (heaterPtr != heaters.length - 1 && heaters[heaterPtr] <= houses[housePtr]) heaterPtr++;
            int tmpMinRadius = Math.abs(houses[housePtr] - heaters[heaterPtr]);
            if (heaterPtr != 0) tmpMinRadius = Math.min(tmpMinRadius, Math.abs(houses[housePtr] - heaters[heaterPtr - 1]));
            minRadius = Math.max(tmpMinRadius, minRadius);
        }
        return minRadius;
    }
}
