class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> mp= new HashMap<>();

        mp.put(0,1);
        int presum=0;
        int count =0;
        for(int i=0;i<n;i++){
            presum+=nums[i];
            int req=presum-k;

            if(mp.containsKey(req)){
                count+=mp.get(req);
            }

            mp.put(presum,mp.getOrDefault(presum,0)+1);
        }

        return count;
    }
}