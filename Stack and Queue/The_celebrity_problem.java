


//=====================solution for gfg=========================================================================

//---------------------------- Brute Force ---------------------------
class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        
        int r=mat.length;
        int c=mat[0].length;
        int ans=-1;
        
        int row=-1;
        
        for(int i=0;i<r;i++){
            
            
            for(int j=0;j<c;j++){
                
                if(mat[i][j]==1){
                    row=-1;
                    break;
                }else{
                    row=i;
                }
            }
            
            if(row != -1){
                for(int k=0;k<r;k++){
                    if(k!= row && mat[k][row]==0){
                        ans=-1;
                        break;
                    }else{
                        ans=row;
                    }
                }
            }
        }
        
        return ans;
    }
}


//---------------------------------------- Better approach ---------------------------------------------------------

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        
        int r=mat.length;
        int c=mat[0].length;
        int ans=-1;
        
        int row=-1;
        
        for(int i=0;i<r;i++){
            
            
            for(int j=0;j<c;j++){
                
                if(mat[i][j]==1){
                    row=-1;
                    break;
                }else{
                    row=i;
                }
            }
            
            if(row != -1){
                for(int k=0;k<r;k++){
                    if(k!= row && mat[k][row]==0){
                        ans=-1;
                        break;
                    }else{
                        ans=row;
                    }
                }
            }
        }
        
        return ans;
        // code here
    }
}


