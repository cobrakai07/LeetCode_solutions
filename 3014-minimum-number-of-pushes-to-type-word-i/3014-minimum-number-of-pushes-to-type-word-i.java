class Solution {
    public int minimumPushes(String word) {
        int count = 1;
        int ans = 0;
        for(char c: word.toCharArray()){
            if(count<=8){
                ans++;
            }else if(count<=16){
                ans = ans+2;
            }else if(count<=24){
                ans = ans+3;
            }else{
                ans = ans+4;
            }
            count++;
        }
        return ans;
    }
}