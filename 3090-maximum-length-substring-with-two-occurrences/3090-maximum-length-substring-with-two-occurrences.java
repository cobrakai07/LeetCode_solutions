class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int i = 0, j = 0;
        char arr[] = s.toCharArray();
        int n = arr.length;
        int max = 0;
        while(j<n){
            int c = arr[j];
            freq[c-'a']++;
            if(freq[c-'a']<=2){
                max = Math.max(max,j-i+1);
            }else{
                while(freq[c-'a']>2){
                    freq[arr[i]-'a']--;
                    i++;
                }
            }
            j++;
        }
        return max;
    }
}