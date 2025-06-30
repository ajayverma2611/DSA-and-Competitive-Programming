class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n= nums.size();
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

            swap(nums[ti], nums[si]);
        }

            reverse(nums.begin()+ti+1, nums.end());


    }
};