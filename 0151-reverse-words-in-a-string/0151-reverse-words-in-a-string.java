class Solution {
    public String reverseWords(String s) {

        String str = "";
        Stack<String> st = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                if (!str.equals("")) {
                    st.push(str);
                    str = "";
                }
            } else {
                str += s.charAt(i);
            }
        }
        
        if (!str.equals("")) {
            st.push(str);
        }

        String ans = "";
        while (st.size() > 1) {
            ans += st.pop() + " ";
        }

        ans += st.pop();

        return ans;
    }
}
