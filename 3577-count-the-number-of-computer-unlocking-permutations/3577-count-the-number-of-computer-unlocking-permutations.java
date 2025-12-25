class Solution {
    public int countPermutations(int[] complexity) {
        int n=complexity.length;
        long ans=1;
        int mini=complexity[0];
        for(int i=1;i<n;i++){
            if(complexity[i]<=mini){
                return 0;
            }

            mini=Math.min(mini,complexity[i]);

            ans=(ans*i)%1000000007;
            
        }

        return (int)ans;
    }
}