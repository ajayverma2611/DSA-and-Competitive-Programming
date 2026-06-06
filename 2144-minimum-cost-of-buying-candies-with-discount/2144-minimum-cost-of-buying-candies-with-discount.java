class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;

        Arrays.sort(cost);
        int ans=0;

        int tmp=0;
        for(int i=n-1;i>=0;i--){
            if(tmp==2){
                tmp=0;
                continue;
            }

            ans+=cost[i];
            tmp++;
        }

        return ans;
    }
}