class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int maxlen=0;
        int sp=0;

        boolean[][] t=new boolean[n+1][n+1];
        
        for(int l=1;l<=n;l++){
            for(int i=0;i+l-1<n;i++){
                int j=i+l-1;

                if(i==j){
                    t[i][j]=true;
                }else if(i+1==j){
                    if(s.charAt(i)==s.charAt(j)){
                        t[i][j]=true;
                    }else{
                        t[i][j]=false;
                    }
                }else{
                    if(s.charAt(i)==s.charAt(j)){
                        if(t[i+1][j-1]== true){
                            t[i][j]=true;
                        }else{
                            t[i][j]=false;
                        }
                    }
                }

                if(t[i][j]==true){
                    if(maxlen < j-i+1){
                        maxlen=Math.max(j-i+1,maxlen);
                        sp=i;
                    }
                }
            }
        }

        return s.substring(sp,sp+maxlen);
    }
}