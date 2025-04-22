class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mp = new HashMap<>();
        Set<Character> st=new HashSet<>();

        int n=s.length();
        int i=0;
        while(i<n){
           if(!mp.containsKey(s.charAt(i))){
                if(st.contains(t.charAt(i))){
                    return false;
                }
                mp.put(s.charAt(i),t.charAt(i));
                st.add(t.charAt(i));
           }
           i++;
        }

        i=0;
        char arr[]=s.toCharArray();
        while(i<n){
            arr[i]=mp.get(s.charAt(i));
            i++;
        }

        String news=new String(arr,0,n);

        return news.equals(t);

    }
}