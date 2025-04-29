class Solution {
    public int maxPoints(int[][] points) {
        int n=points.length;
        if(n==1){
            return 1;
        }

        int result=0;

        for(int i=0;i<n;i++){
            Map<Double,Integer> mp=new HashMap<>();

            for(int j=0;j<n;j++){
                if(i==j) continue;

                int dx=points[j][0]-points[i][0];
                int dy=points[j][1]-points[i][1];
                Double slope=Math.atan2(dx,dy);

                mp.put(slope,mp.getOrDefault(slope,0)+1);
            }

            for(int count:mp.values()){
                result=Math.max(result,count+1);
            }
        }

        return result;
    }
}