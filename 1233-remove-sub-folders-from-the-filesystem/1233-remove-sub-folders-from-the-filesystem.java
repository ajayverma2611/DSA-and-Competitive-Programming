class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        HashSet<String> st = new HashSet<>();

        int n = folder.length;
        for(int i=0;i<n;i++){
            st.add(folder[i]);
        }

        for(int i=0;i<n;i++){
            if(folder[i].length() == 2){
                ans.add(folder[i]);
            }else{
                String temp=folder[i];
                int m=temp.length();
                boolean unique=true;

                // int ind=0;

                for(int j=m-1;j>=2;j--){
                    if(temp.charAt(j)=='/'){
                        
                        if(st.contains(temp.substring(0,j))){
                            unique=false;
                            break;
                        }
                    }
                }

            
                if(unique == true){
                    ans.add(temp);
                }

            }
        }

        return ans;
    }
}