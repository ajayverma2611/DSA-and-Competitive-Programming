class Solution {
    public int jump(int[] nums) {
        int n= nums.length;
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        int i = 0;
        int count = 0;
        while(i<=n-1){
            if(i+nums[i]>=n-1){
                count++;
                break;
            }
            int j=i;
            int farthestReach = i;
            int till=i+nums[i];
            while(j<n && j<=till){
                if(j+nums[j]>farthestReach){
                    farthestReach = j+nums[j];
                    i=j;
                }
                j++;
            }

            count++;
        }

        return count;
    }
}