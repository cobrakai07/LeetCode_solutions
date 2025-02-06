class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int diff=0;
        int[]h1= new int[26];
        int[]h2= new int[26];

        for(int i=0; i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diff++;
            }
            h1[s1.charAt(i)-'a']++;
            h2[s2.charAt(i)-'a']++;
        }
        

        return (diff==0 || diff==1|| diff==2)&&Arrays.equals(h1,h2);


    }
}