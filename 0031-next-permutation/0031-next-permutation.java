class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int ti=-1;
        for(int i=n-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                ti=i-1;
                break;
            }
        }

        if(ti!=-1){
            int si=ti;
            for(int j=n-1;j>=ti+1;j--){
                if(nums[j]>nums[ti]){
                    si=j;
                    break;
                }
            }

            int temp=nums[ti];
            nums[ti]=nums[si];
            nums[si]=temp;
        }

        int k=n-1;
        ti++;
        while(ti<k){
            int temp=nums[ti];
            nums[ti]=nums[k];
            nums[k]=temp;

            ti++;
            k--;
        }
    }
}