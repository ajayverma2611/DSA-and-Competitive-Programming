class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int len=-1;
        Map<Character, Integer> mp = new HashMap<>();

        int n=s.length();

        while(j<n){
            if(mp.containsKey(s.charAt(j))){
                i=Math.max(mp.get(s.charAt(j))+1,i);
            }

            len=Math.max(len, j-i+1);
            mp.put(s.charAt(j),j);
            j++;

        }

        return len;
    
    }
}