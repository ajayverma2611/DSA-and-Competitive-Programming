class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> mp=new HashMap<>();

        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Pair<Integer,Integer>> q=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());

        for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
            q.add(new Pair<>(entry.getKey(),entry.getValue()));
        }

        int ans[]=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=q.poll().getKey();
        }

        return ans;
    }
}