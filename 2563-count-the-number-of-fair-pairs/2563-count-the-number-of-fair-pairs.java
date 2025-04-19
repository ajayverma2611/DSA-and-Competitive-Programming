class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {

       long result=0;
       Arrays.sort(nums);

       int n=nums.length;
       for(int i=0;i<n;i++){
        int leftInd=lowerBound(nums,i+1,n,lower-nums[i]);
        int rightInd=upperBound(nums,i+1,n,upper-nums[i]);

        int x=leftInd-1-i;
        int y=rightInd-1-i;

        result+=(y-x);
       } 

       return result;
    }

    public int lowerBound (int nums[] , int start, int end , int t){
        while(start<end){
            int mid = start + (end - start) / 2;
            if(nums[mid]<t){
                start=mid+1;
            }else{
                end=mid;
            }
        }

        return start;
    }

    public int upperBound (int nums[] , int start, int end , int t){
        while(start<end){
            int mid = start + (end - start) / 2;
            if(nums[mid]<=t){
                start=mid+1;
            }else{
                end=mid;
            }
        }

        return start;
    }
}