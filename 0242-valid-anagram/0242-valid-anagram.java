class Solution {
    public boolean isAnagram(String s, String t) {
        
        int n=s.length();
        int m=t.length();

        if(m!=n){
            return false;
        }

        
        Map<Character,Integer> mp=new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for(int i=0;i<n;i++){
            if(mp.containsKey(t.charAt(i))){
                int val=mp.get(t.charAt(i));
                mp.put(t.charAt(i),val-1);
                val-=1;
                if(val==0){
                    mp.remove(t.charAt(i));
                }
            }else{
                return false;
            }
        }

        return mp.size()==0;
    }
}