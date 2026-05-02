class Solution {
    public int rotatedDigits(int n) {
        int cnt=0;
        for(int i=1;i<=n;i++){
            int num=i;
            boolean has = false;
            while(num!=0){
                int t=num%10;
                if(t==2 || t==5||t==6||t==9){
                    has=true;
                }else if(t==3||t==4||t==7){
                    has=false;
                    break;
                }
                num=num/10;
            }

            if(has==true){
                cnt++;
            }
        }

        return cnt;

    }
}