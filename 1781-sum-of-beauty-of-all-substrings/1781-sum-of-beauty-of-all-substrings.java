class Solution {

    public int getMin(int arr[]){
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(arr[i]!=0){
                mini=Math.min(mini,arr[i]);
            }
        }

        return mini;
    }
    public int getMax(int arr[]){
        int maxi=0;
        for(int i=0;i<26;i++){
            maxi=Math.max(maxi,arr[i]);
        }

        return maxi;
    }
    public int beautySum(String s) {
        
        int n=s.length();
        int hash[];
        int sum=0;

        for(int i=0;i<n;i++){
            hash=new int[26];
            for(int j=i;j<n;j++){
                int ind=s.charAt(j)-'a';
                hash[ind]++;

                int beauty=getMax(hash)-getMin(hash);
                sum+=beauty;
            }
        }

        return sum;
    }
}