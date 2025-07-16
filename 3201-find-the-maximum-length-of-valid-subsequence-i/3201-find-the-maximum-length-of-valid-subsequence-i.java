class Solution {
    public int maximumLength(int[] nums) {
        int evenCount=0;
        int oddCount=0;

        int n = nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                evenCount++;
            }else{
                oddCount++;
            }
        }

        int parity = nums[0]%2;
        int alternate=1;
        for(int i=1;i<n;i++){
            int currentParity = nums[i]%2;
            if(currentParity != parity){
                parity=currentParity;
                alternate++;
            }
        }


        return Math.max(alternate,Math.max(evenCount , oddCount));

    }
}