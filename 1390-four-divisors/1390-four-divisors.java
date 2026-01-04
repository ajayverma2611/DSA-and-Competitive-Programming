class Solution {
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for(int i=0;i<n;i++){
            int cnt=0;
            int tmp=0;

            for(int j=1;j*j<=nums[i];j++){
                if(nums[i]%j==0){
                    if(nums[i] / j == j){
                        cnt++;
                        tmp+=j;
                    }else{
                        cnt=cnt+2;
                        tmp+=j;
                        tmp+=nums[i]/j;
                    }
                }


                if(cnt>4){
                    break;
                }
            }

            if(cnt==4){
                ans+=tmp;
            }
        }


        return ans;
    }
}