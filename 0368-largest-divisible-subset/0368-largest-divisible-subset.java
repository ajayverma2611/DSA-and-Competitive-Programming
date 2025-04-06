class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n=nums.length;
        int maxi = 1;
        int lastInd = 0;
        int hash[]=new int[n];
        int dp[]=new int[n];

        Arrays.fill(dp,1);

        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[j]+1 > dp[i]){
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                }

                if(dp[i]>maxi){
                    maxi=dp[i];
                    lastInd=i;
                }
            }

        }

        while(true){
            ans.add(nums[lastInd]);
            if(lastInd ==  hash[lastInd]){
                break;
            }

            lastInd=hash[lastInd];
        }


        return ans;

    }
}