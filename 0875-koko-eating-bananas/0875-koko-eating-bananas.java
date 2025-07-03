class Solution {
    public long calculate(int t , int[] piles, int n){
        long timeTaken = 0;
        for (int i = 0; i < n; i++) {
            timeTaken += (piles[i] + (long)t - 1) / t;  
        }
        return timeTaken;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Integer.MIN_VALUE;
        int ans = -1;

        int n = piles.length;
        for (int i = 0; i < n; i++) {
            r = Math.max(r, piles[i]); 
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            long timeToEat = calculate(mid, piles, n);  

            if (timeToEat <= h) {
                ans = mid;
                r = mid - 1;  
            } else {
                l = mid + 1;  
            }
        }

        return ans;
    }
}
