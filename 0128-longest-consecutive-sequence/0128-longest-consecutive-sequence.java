class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st=new HashSet<>();
        int n=nums.length;
        for(int i=-0;i<n;i++){
            st.add(nums[i]);
        }

        int len=0;

        for(int it:st){
            if(!st.contains(it-1)){
                int x=it;
                int cnt=0;
                while(st.contains(x)){
                    cnt++;
                    x++;
                }

                len=Math.max(len,cnt);
            }

        }

        return len;
    }
}