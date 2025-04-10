class Solution {

    public long solve(String str, String s, int limit){
        if(str.length() < s.length()){
            return 0;
        }

        long cnt=0;
        String trailString=str.substring(str.length()-s.length());

        int remainL=str.length()-s.length();

        for(int i=0;i<remainL;i++){
            int digit=str.charAt(i)-'0';
            if(digit<=limit){
                cnt+=digit*Math.pow(limit+1,remainL-i-1);
            }else{
                cnt+=Math.pow(limit+1,remainL-i);
                return cnt;
            }
        }

        // for the edge case ===========================
        if (trailString.compareTo(s) >= 0) {
            cnt++;
        }

        return cnt;

    }
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String start_str=String.valueOf(start-1);
        String finish_str=String.valueOf(finish);

        return solve(finish_str,s,limit)-solve(start_str,s,limit);
    }
}