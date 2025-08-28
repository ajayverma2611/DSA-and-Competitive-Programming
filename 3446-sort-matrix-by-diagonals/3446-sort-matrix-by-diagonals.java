class Solution {
    public int[][] sortMatrix(int[][] grid) {
        
        int n= grid.length;
        if(n==1){
            return grid;
        }
        for(int i=0;i<n;i++){
            int k=i;
            int l=0;
            ArrayList<Integer> t= new ArrayList<>();
            while(k<n && l<n){
                t.add(grid[k][l]);
                k++;
                l++;
            }

            if(t.size() > 1){
                Collections.sort(t);
            }
            
            
            k=i;
            l=0;
            
            while(k<n && l<n){
                grid[k][l]=t.remove(t.size()-1);
                k++;
                l++;
            }
        }

        for(int i=1;i<n;i++){
            int k=0;
            int l=i;
            ArrayList<Integer> t= new ArrayList<>();
            while(k<n && l<n){
                t.add(grid[k][l]);
                k++;
                l++;
            }

            if(t.size() > 1){
                Collections.sort(t);
            }

            k=0;
            l=i;
            
            while(k<n && l<n){
                grid[k][l]=t.remove(0);
                k++;
                l++;
            }
        }


        return grid;


    }
}