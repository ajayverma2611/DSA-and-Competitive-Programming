class Solution {
    public String removeOuterParentheses(String str) {
        
        int n=str.length();
        char s[]=str.toCharArray();
        int sum=0;
        for(int i=0;i<n;i++){
            if(s[i]=='('){
                sum++;
            }else{
                sum--;
            }

            if(sum==0){
                s[i]='#';
            }
        }

        sum=0;
        for(int i=n-1;i>=0;i--){
            if(s[i]=='('){
                sum--;
            }else{
                sum++;
            }

            if(sum==0){
                s[i]='#';
            }
        }

        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++){
            if(s[i]!='#'){
                ans.append(s[i]);
            }
        }

        return ans.toString();
    }
}