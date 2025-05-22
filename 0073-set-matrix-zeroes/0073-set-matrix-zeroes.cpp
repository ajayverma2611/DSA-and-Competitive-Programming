class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {

        int n=matrix.size();
        int m=matrix[0].size();
        
        stack<pair<int,int>> st;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] ==0){
                    st.push(make_pair(i,j));
                }
            }
        }

        while(!st.empty()){
             
             int rb=st.top().first;
             int cb=st.top().second; 
             int rl=st.top().first;
             int cl=st.top().second; 

             while(rb>=0){
                matrix[rb][st.top().second]=0;
                rb--;
             }

             while(rl<n){
                matrix[rl][st.top().second]=0;
                rl++;
             }

             while(cb>=0){
                matrix[st.top().first][cb]=0;
                cb--;
             }
             while(cl<m){
                matrix[st.top().first][cl]=0;
                cl++;
             }


             st.pop();
        }
    }
};