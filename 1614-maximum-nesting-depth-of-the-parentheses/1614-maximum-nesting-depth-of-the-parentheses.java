class Solution {
    public int maxDepth(String s) {
        int n=s.length();
        int sum=0;
        int maxi=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                sum++;
                maxi=Math.max(maxi,sum);
            }else if(s.charAt(i)==')'){
                sum--;
            }
        }

        return maxi;
    }
}