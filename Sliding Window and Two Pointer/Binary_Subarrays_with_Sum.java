

//======================================== Solution for leetcode ===================================

//------------------------ better approach  ---------------------------------------
class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
      
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);

        int presum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];

            int remove = presum - k;

 
            if (prefixSumMap.containsKey(remove)) {
                count += prefixSumMap.get(remove);
            }


            prefixSumMap.put(presum, prefixSumMap.getOrDefault(presum, 0) + 1);
        }

        return count;
    }
}




// =================================================== optimal approach =========================================

class Solution {
    public int solve(int[] nums, int goal){
        if(goal < 0){
            return 0;
        }

        int l=0;
        int r=0;
        int cnt=0;
        int sum=0;
        int n=nums.length;

        while(r<n){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            cnt+=((r-l)+1);
            r++;
        }

        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {

        int ans=solve(nums,goal)-solve(nums,goal-1);
        return ans;
    }
}
