class Solution {
    public int reverse(int n){
        int temp =0;
        while(n!=0){
            int t=n%10;
            temp=temp*10+t;
            n=n/10;
        }

        return temp;
    }
    public int mirrorDistance(int n) {
        int rev = reverse(n);

        return Math.abs(n-rev);
    }
}