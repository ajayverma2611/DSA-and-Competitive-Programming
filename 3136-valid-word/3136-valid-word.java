class Solution {
    public boolean isValid(String word) {
        int n = word.length();

        if(n<3){
            return false;
        }

        boolean isVowel = false;
        boolean isCons = false;

        for(int i=0;i<n;i++){
            if(word.charAt(i) == 'A' || word.charAt(i) == 'E'|| word.charAt(i) == 'I' || word.charAt(i) == 'O' || word.charAt(i) == 'U' || word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u'){
                
                isVowel=true;
                continue;
            }else if((word.charAt(i) >= 'a' && word.charAt(i) <='z') || (word.charAt(i) >= 'A' && word.charAt(i) <='Z')){
                isCons=true;
                continue;
            }else if(word.charAt(i) >= '0' && word.charAt(i) <='9'){
                continue;
            }else{
                return false;
            }
        }

        if(isVowel == false  || isCons ==false){
            return false;
        }
        
        return true;
    }
}