class Solution {
    public String largestOddNumber(String num) {
        int n=num.length();
        int i=n-1;
        while(i>=0){
            int d=num.charAt(i)-'0';
            if(d%2!=0){
                break;
            }
            i--;
        }

        if(i<0){
            return "";
        }

        return num.substring(0,i+1);
    }
}