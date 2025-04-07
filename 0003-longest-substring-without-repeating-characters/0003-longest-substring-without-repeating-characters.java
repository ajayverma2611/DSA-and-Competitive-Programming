class Solution {
    public int lengthOfLongestSubstring(String s) {

    //     if(s.length()==0){
    //         return 0;
    //     }
    //     Set< Character > st=new HashSet<>();
    //     int n=s.length();
    //     int i=0;
    //     int j=0;

    //     int maxLen=-1;

    //    while(j<n){
    //     if(st.contains(s.charAt(j))){
    //        st.remove(s.charAt(i));
    //        i++;
    //        continue;
    //     }
    //     maxLen=Math.max(maxLen,j-i+1);
    //     st.add(s.charAt(j));
    //     j++;
    //    }

    //    return maxLen;
    // }

    if(s.length()==0){
        return 0;
    }

    Map< Character , Integer> map=new HashMap<>();
    int i=0;
    int j=0;
    int n=s.length();
    int maxLen=-1;

    while(j<n){

        if(map.containsKey(s.charAt(j))){
            i=Math.max(map.get(s.charAt(j))+1,i);
        }

        map.put(s.charAt(j),j);
        maxLen=Math.max(maxLen,j-i+1);
        j++;

    }

    return maxLen;
}
}