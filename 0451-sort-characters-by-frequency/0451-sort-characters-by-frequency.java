class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int n=s.length();
        
        for(int i=0;i<n;i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }

        PriorityQueue<Pair<Character,Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        
        for(Map.Entry<Character,Integer> entry : mp.entrySet()){
            pq.add(new Pair<>(entry.getKey(),entry.getValue()));
        }

        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()){
            char c=pq.peek().getKey();
            int val=pq.peek().getValue();
            pq.poll();

            for(int i=1;i<=val;i++){
                ans.append(c);
            }
        }


        return ans.toString();
    }
}