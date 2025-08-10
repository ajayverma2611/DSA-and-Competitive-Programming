class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int n=nums.length;
        int ans[]=new int[k];
        PriorityQueue<Pair<Integer,Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        

        HashMap<Integer, Integer> mp= new HashMap<>();
        for(int i=0;i<n;i++){
           mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }


        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            pq.add(new Pair<>(entry.getKey(),entry.getValue()));
        }

        int ind=0;
        while(k!=0){
            ans[ind]=pq.poll().getKey();
            ind++;
            k--;
        }


        return ans;
    }
}