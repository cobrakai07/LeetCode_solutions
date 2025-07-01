class Solution {
    public int possibleStringCount(String word) {
        int i=0,j=0;
        int ans =1;
        int neg=0;

        while(j<word.length() && i<word.length()){
            if(i==j)j++;
            else if(word.charAt(i)==word.charAt(j)){

                while(j<word.length() && word.charAt(i)==word.charAt(j)){
                    j++;
                }
                // if(j==word.length())ans = ans + (j-i)-1;
                neg++;
                ans = ans + (j-i);

                i=j;
            }else{
                i++;j++;
            }
        }
        return ans-neg;
    }
}