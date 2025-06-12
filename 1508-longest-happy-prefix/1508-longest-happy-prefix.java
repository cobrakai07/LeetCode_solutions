class Solution {
    public String longestPrefix(String s) {
       int [] lps= new int[s.length()];
        int len=0;
        int i=1;
        while(i<lps.length){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i++]=len;
            }else{
                if(len==0){
                    lps[i++]=0;
                }else{
                    len=lps[len-1];
                }
            }
        }
        System.out.println(Arrays.toString(lps));
        int max = 0;
        for(int it: lps)max = Math.max(max,it);
        
        return s.substring(0,lps[lps.length-1]);
    }
}