class Solution {
    public int calculate(int[] weights, int tar){
        int cal=1;
        int sum=0;
        int n=weights.length;
        for(int i=0;i<n;i++){
            if(sum + weights[i] > tar){
                cal++;
                sum=0;
            }

            sum+=weights[i];
        }

        return cal;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int l=Integer.MIN_VALUE;
        int r=0;
        int ans=-1;

        for(int i=0;i<n;i++){
            l=Math.max(weights[i],l);
            r+=weights[i];
        }

        while(l<=r){

            int mid=(l+r)/2;
            int takeDay=calculate(weights,mid);
            if(takeDay<=days){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }

        return ans;
    }
}