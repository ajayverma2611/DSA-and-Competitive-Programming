class Solution {
    public int countSymmetricIntegers(int low, int high) {
        
        int i=low;
        int cnt=0;
        while(i<=high){
            String num=String.valueOf(i);
            int l=num.length();
            if(l%2==0){
                int left=0;
                int right=0;

                for(int j=0;j<l/2;j++){
                    left+=num.charAt(j)-'0';
                }
                for(int j=l/2;j<l;j++){
                    right+=num.charAt(j)-'0';
                }

                if(left==right){
                    cnt++;
                }

            }
            i++;
        }

        return cnt;
    }
}