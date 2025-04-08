class Solution {

    public boolean isUnique(int i , int n , int[] nums){
        Set<Integer> st= new HashSet<>();
        while(i<n){
            if(st.contains(nums[i])){
                return false;
            }

            st.add(nums[i]);

            i++;
        }

        return true;
    }

    public int minimumOperations(int[] nums) {
        int cnt=0;
        int n = nums.length;
        int i=0;
        

        while(i<n){
            if(isUnique(i,n,nums)==false){
                cnt++;
            }

            i+=3;
        }


        return cnt;

    }
}