class Solution {

    public boolean isPossible(int[] arr, int k , int n , int mid){

        int part=1;
        int sum=0;
        
        for(int i=0;i<n;i++){
            if(sum+arr[i]<=mid){
                sum+=arr[i];
            }else{
                part++;
                if(part>k || arr[i]>mid){
                    return false;
                }
                sum=arr[i];
            }
        }

        return true;

    }
    public int splitArray(int[] nums, int k) {
        int l=Integer.MAX_VALUE;
        int r=0;
        int n=nums.length;
        int ans=-1;

        for(int i=0;i<n;i++){
            l=Math.min(l,nums[i]);
            r+=nums[i];
        }

        while(l<=r){
            int mid=(l+r)/2;

            if(isPossible(nums, k,n,mid)==true){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }

        return ans;
    }
}