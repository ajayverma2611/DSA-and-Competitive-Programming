class Solution {
    public boolean isValid(String s) {
        int n = s.length();

        Stack<Character> st = new Stack<>();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{'){
                st.push(ch);
            }else{
                char ch2=s.charAt(i);
                if(!st.isEmpty() && (ch2==')' && st.peek()=='(' || ch2=='}' && st.peek()=='{'  || ch2==']' && st.peek()=='[' )){
                    st.pop();
                }else{
                    st.push(ch2);
                }
            }
        }


        return st.isEmpty();
    }
}