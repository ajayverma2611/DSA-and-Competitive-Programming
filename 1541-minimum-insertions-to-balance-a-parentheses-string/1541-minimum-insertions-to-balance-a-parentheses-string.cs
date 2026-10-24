public class Solution
{
    public int MinInsertions(string s)
    {
        int n = s.Length;
        Stack<char> st = new Stack<char>();
        int ans = 0;

        for (int i = 0; i < n ; i++)
        {
            if (i<n-1 && s[i] == ')' && s[i + 1] == ')')
            {
                if (st.Count > 0 && st.Peek() == '(')
                {
                    st.Pop();
                    i = i + 1;
                    continue;

                }else{
                    ans++;
                    i = i + 1;
                    continue;
                }
            }

            if (s[i] == ')' && st.Count > 0 && st.Peek() == '(')
            {
                ans++;
                st.Pop();
                continue;
            }

            st.Push(s[i]);
        }
        int count = st.Count;
        ans = ans + (count*2);

        return ans;
    }
}
