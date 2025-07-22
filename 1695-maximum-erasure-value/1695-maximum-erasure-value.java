class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int j=0;
        int i=0;
        int ans = Integer.MIN_VALUE;
        int sum=0;
        int n=nums.length;

        HashMap<Integer, Integer> mp= new HashMap<>();

        while(j<n){
            if(mp.containsKey(nums[j])){
                
                int ind = mp.get(nums[j]);
                while(i<=ind){
                    mp.remove(nums[i]);
                    sum-=nums[i];
                    i++;
                }

                mp.put(nums[j],j);
                sum+=nums[j];

            }else{
                
                mp.put(nums[j],j);
                sum+=nums[j];
                ans=Math.max(ans,sum);

            }


            j++;
        }

        return ans;
    }
}