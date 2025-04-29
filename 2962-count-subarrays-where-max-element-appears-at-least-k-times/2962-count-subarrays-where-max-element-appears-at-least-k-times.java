class Solution {
    public int getMax(int nums[]){
        int maxi=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,nums[i]);
        }

        return maxi;
    }
    public long countSubarrays(int[] nums, int k) {
        int n=nums.length;
        int cnt=0;
        long ans=0;

        int i=0;
        int j=0;

        int maxi=getMax(nums);

        while(j<n){
            if(nums[j]==maxi){
                cnt++;
            }

            while(cnt>=k){
                ans+=n-j;
                if(nums[i]==maxi){
                    cnt--;
                }

                i++;
            }

            j++;
        }

        return ans;
    }
}