class Solution {
    public int numberOfSpecialChars(String word) {

        int l[] = new int[26];
        int u[] = new int[26];
        int n = word.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);

            if (Character.isLowerCase(c)) {
                l[c-'a']=i+1;
            } else {
                if (u[c - 'A']==0) {
                    u[c-'A']=i+1;
                }

            }
        }

        for(int i=0;i<26;i++){
            if(l[i]!=0 && u[i]!=0 && u[i]>l[i]){
                cnt++;
            }
        }

        return cnt;
    }
}