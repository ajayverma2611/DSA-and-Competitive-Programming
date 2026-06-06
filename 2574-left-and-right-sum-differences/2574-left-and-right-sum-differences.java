class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int sum=0;
        
        int i=0;
        while(i<n){
            sum+=nums[i];
            i++;
        }

        int tmp = 0;
        
        i=0;
        while(i<n){
            if(i==0 || i==n-1){
                ans[i]=sum-nums[i];
                tmp+=nums[i];
                i++;
                continue;
            }

            ans[i]=Math.abs(tmp-(sum-tmp-nums[i]));
            tmp+=nums[i];
            i++;
        }

        return ans;
    }
}