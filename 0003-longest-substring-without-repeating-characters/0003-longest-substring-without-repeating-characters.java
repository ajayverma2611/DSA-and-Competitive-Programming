class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n= s.length();
        int len=0;
        HashMap<Character,Integer> mp=new HashMap<>();

        int i=0;
        int j=0;
        while(j<n){
            if(mp.containsKey(s.charAt(j))){
                i=Math.max(i,mp.get(s.charAt(j))+1);
            }

            len=Math.max(len,j-i+1);
            mp.put(s.charAt(j),j);
            j++;
        }


        return len;
        
    }
}