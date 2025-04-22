class Solution {
    public String reverseWords(String s) {
        int n=s.length();
        char str[]=s.toCharArray();

        reverse(str,0,n-1);

        int i=0;
        int l=0;
        int r=0;

        while(i<n){
            while(i<n && str[i]!=' '){
                str[r++]=str[i++];
            }

            if(l<r){
                reverse(str,l,r-1);
                if(r<n){
                    str[r]=' ';
                }
                r++;
                l=r;
            }

            i++;
        }

        String result = new String(str,0,r-1);
        return result;
    }
    public void reverse(char chars[] , int left, int right){
        while(left<right){
            char tmp=chars[left];
            chars[left]=chars[right];
            chars[right]=tmp;
            left++;
            right--;
        }
    }
}