class Solution {
    public int countSubstrings(String s) {

        int n=s.length();
        int cnt=0;
        boolean t[][]=new boolean[n][n];

        for(int l=1;l<=n;l++){
            for(int i=0;i+l-1<n;i++){
                int j=i+l-1;

                if(i==j){
                    t[i][j]=true;
                }else if(i+1 == j){
                    if(s.charAt(i)==s.charAt(j)){
                        t[i][j]=true;
                    }else{
                        t[i][j]=false;
                    }
                }else{
                    if(s.charAt(i)==s.charAt(j) && t[i+1][j-1]){
                        t[i][j]=true;
                    }else{
                        t[i][j]=false;
                    }
                }

                if(t[i][j]==true){

                    cnt++;

                }
            }
        }

        return cnt;

    }
}