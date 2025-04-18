class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }

        String say=countAndSay(n-1);

        StringBuilder result=new StringBuilder("");
        int l=say .length();

        for(int i=0;i<l;i++){
            char ch=say.charAt(i);
            int count=1;

            while(i<l-1 && say.charAt(i) == say.charAt(i+1)){
                count++;
                i++;
            }

            result.append(count).append(ch);
        }

        return result.toString();
    }
}