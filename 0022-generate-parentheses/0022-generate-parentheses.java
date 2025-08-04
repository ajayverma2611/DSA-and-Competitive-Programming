class Solution {
    List<String> ans=new ArrayList<>();
    public void solve(int ind , StringBuilder op, int sum, int n){
        if(ind==2*n){
            if(sum==0){
                ans.add(op.toString());
            }
            return;
        }
        op.append('(');
        // System.out.println(op +" "+sum);
        solve(ind+1,op,sum+1,n);
        

        op.deleteCharAt(op.length()-1);
        // sum-=1;

        if(sum>0){
            op.append(')');
            solve(ind+1,op,sum-1,n);
            op.deleteCharAt(op.length()-1);
            // sum+=1;
        }
    }
    public List<String> generateParenthesis(int n) {
        StringBuilder op=new StringBuilder();
        solve(0,op,0,n);
        return ans;
    }
}