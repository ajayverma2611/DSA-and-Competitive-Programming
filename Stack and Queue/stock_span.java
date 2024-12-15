

// =========================== solution for leetcode =======================================================

class StockSpanner {

    private Stack<Pair<Integer, Integer>> st; 
    private int i = 0;
    
    public StockSpanner() {
        st = new Stack<>(); 
    }
    
    public int next(int price) {
        i++;
        Pair<Integer, Integer> p; 

      
        while (!st.isEmpty() && st.peek().getKey() <= price) {
            st.pop();
        }

     
        int ans = st.isEmpty() ? i : i - st.peek().getValue();

  
        st.push(new Pair<>(price, i));

        return ans;
    }
}
