class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();

        if(n!=m){
            return false;
        }
        String str = s.concat(s);

        if (str.contains(goal)) {
            return true;
        }

        return false;
    }
}