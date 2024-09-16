
//============================== Leetcode  131  ===============================================================


class Solution {

    public boolean isPalind(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
    public void solve (int ind, String s, List<List<String>> ans, List<String> sub){
        if(ind>=s.length()){
            ans.add(new ArrayList<>(sub));
            return;
        }
        
        for(int i=ind;i<s.length();i++){
            if(isPalind(s,ind,i)){
                sub.add(s.substring(ind,i+1));
                solve(i+1,s,ans,sub);
                sub.remove(sub.size()-1);
            }
        }
       
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> sub=new ArrayList<>();

        solve(0,s,ans,sub);

        return ans;
    }
}