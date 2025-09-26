class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];

        int odd=0;
        int eve=1;

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                arr[odd]=nums[i];
                odd+=2;
            }else{
                arr[eve]=nums[i];
                eve+=2;
            }
        }


        return arr;
        
    }
}