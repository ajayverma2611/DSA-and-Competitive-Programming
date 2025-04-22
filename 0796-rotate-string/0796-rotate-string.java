class Solution {
    public boolean rotateString(String s, String goal) {
    //     int n=s.length();
    //     int m=goal.length();
    //     int i=0;

    //     if(m!=n){
    //         return false;
    //     }

    //     while(i<n){
    //         s=s.substring(1)+s.charAt(0);
    //         if(s.equals(goal)){
    //             return true;
    //         }
    //         i++;
    //     }

    //     return false;
    // }


    // ==================== Optimal =================================================
    
    int n=s.length();
    int m=goal.length();

    if(m!=n){
        return false;
    }
    if((s+s).contains(goal)){
        return true;
    }

        return false;
    }
}