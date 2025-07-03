class Solution {
    public String s="a";
    public void solve(int k ){
        if(s.length()>k){
            return;
        }

        String temp=s;
        int i=0;
        while(i<s.length()){
            temp += (char)(s.charAt(i) + 1);
            i++;
        }

        s=temp;
        solve(k);
    }
    public char kthCharacter(int k) {
        
        solve(k);
        return s.charAt(k-1);
    }
}