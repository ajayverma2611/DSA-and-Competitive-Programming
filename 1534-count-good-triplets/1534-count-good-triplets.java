class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        
        int cnt=0;
        int n=arr.length;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                int f=Math.abs(arr[i]-arr[j]);
                if(f<=a){
                    for(int k=j+1;k<n;k++){
                        int s =Math.abs(arr[j]-arr[k]);
                        int t=Math.abs(arr[i]-arr[k]);

                        if(s<b && t<=c){
                            cnt++;
                        }
                    }
                }
            }
        }

        return cnt;
    }
}