class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        int minInd=-1;
        int maxInd=-1;
        int culprit=-1;
        
        long ans=0;

        int n=nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]==minK){
                minInd=i;
            }
            if(nums[i]==maxK){
                maxInd=i;
            }
            if(nums[i]>maxK || nums[i]<minK){
                culprit=i;
            }

            long smaller=Math.min(minInd,maxInd);
            long temp=smaller-culprit;

            ans+=(temp<=0)?0:temp;
        }

        return ans;
    }
}