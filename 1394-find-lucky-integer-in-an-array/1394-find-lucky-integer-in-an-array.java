class Solution {
    public int findLucky(int[] nums) {
        int arr[]=new int[501];
        int n=nums.length;
        int ans=-1;

        int maxi=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            arr[nums[i]]++;
            maxi=Math.max(maxi,nums[i]);
        }

        for(int i=1;i<=maxi;i++){
            if(arr[i]==i && ans < i){
                ans=i;
            }
        }

        return ans;
    }
}