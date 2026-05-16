class Solution {
    public int findMin(int[] arr) {
        int l=0;
        int r=arr.length-1;

        int ans=Integer.MAX_VALUE;

        while(l<=r){
            int mid=(l+r)/2;

            if(arr[l]<arr[r]){
                ans=Math.min(ans, arr[l]);
                break;
            }

            if(arr[l]<=arr[mid]){
                ans=Math.min(ans,arr[l]);
                l=mid+1;
            }else{
                ans=Math.min(ans,arr[mid]);
                r=mid-1;
            }
        }

        return ans;

    }
}