class Solution {
    public int countVowel(String s){
        int count=0;
        for(char c: s.toCharArray()){
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')count++;
        }
        return count;
    }
    public String reverseWords(String s) {
        String arr[]= s.split(" ");
        int count = countVowel(arr[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append(" ");
        for(int i=1;i<arr.length;i++){
            if(countVowel(arr[i])==count){
                StringBuilder rev = new StringBuilder(arr[i]);
                rev.reverse();
                sb.append(rev).append(" ");
            }else{
                sb.append(arr[i]).append(" ");
            }
        }

        return sb.toString().trim();
    }
}