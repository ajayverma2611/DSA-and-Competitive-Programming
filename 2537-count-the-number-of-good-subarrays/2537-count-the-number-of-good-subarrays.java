class Solution {
    public long countGood(int[] nums, int k) {
        
        Map<Integer, Integer> mp  = new HashMap<>();
        int i=0;
        int n=nums.length;
        int j=0;
        int pair =0;
        int res=0;
        while(j<n){
            if(mp.containsKey(nums[j])){
                pair+=mp.get(nums[j]);
            }
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

            if(pair >= k){
                res+=n-j;
            }

            while(pair>=k){
                mp.put(nums[i],mp.getOrDefault(nums[i],0)-1);
                pair-=mp.get(nums[i]);
                if(pair >= k){
                res+=n-j;
                }
                i++;
            }

            j++;
        }

        return res;
    }
}