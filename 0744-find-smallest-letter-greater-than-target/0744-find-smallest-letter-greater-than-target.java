class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char c = letters[0];
        boolean found = false;
        for(char ch: letters){
            if(found){
                if(ch<c){
                    c=ch;
                }
            }else{
                if(ch>target){
                    found = true;
                    c = ch;
                }

            }
            
        }
        return c;
    }
}