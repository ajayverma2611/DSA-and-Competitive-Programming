class Solution {
    public List<List<Integer>> ans = new ArrayList<>();

    public void solve(int ind, int n, int arr[], int t, List<Integer> sub){
        if(t==0){
            ans.add(new ArrayList<>(sub));
            return;
        }
        if(ind >=n || t<0){
            return;
        }

        sub.add(arr[ind]);
        solve(ind,n,arr,t-arr[ind],sub);
        sub.remove(sub.size()-1);

        for(int i=ind+1;i<n;i++){
            sub.add(arr[i]);
            solve(i,n,arr,t-arr[i],sub);
            sub.remove(sub.size()-1);
        }

        return;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> sub = new ArrayList<>();
        int n=candidates.length;

        solve(0,n, candidates, target, sub);

        return ans;
    }
}