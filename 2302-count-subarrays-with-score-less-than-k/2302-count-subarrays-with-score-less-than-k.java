class Solution {
    public long countSubarrays(int[] nums, long k) {
        long count = 0;
        long sum = 0;

        int i = 0;
        int j = 0;
        int n = nums.length;

        while (j < n) {
            
            sum+=nums[j];

            while (i <= j && sum*(j-i+1) >= k) {
                sum-=nums[i];
                i++;
            }

            count+=j-i+1;
            j++;
        }

        return count;
    }
}