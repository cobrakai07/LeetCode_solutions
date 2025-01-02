class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[]ans=new int[queries.length];
        String vowel="aeiou";
        int[]prefixSum= new int[words.length];
        for(int i=0,count=0;i<words.length;i++){
            if(vowel.indexOf(words[i].charAt(0))!=-1 && vowel.indexOf(words[i].charAt(words[i].length()-1))!=-1)count++;
            prefixSum[i]=count;
        }
        // System.out.println(Arrays.toString(prefixSum));
        int idx=0;
        for(int []arr: queries){
            if(arr[0]-1>=0)
            ans[idx++]=prefixSum[arr[1]]-prefixSum[arr[0]-1];
            else
            ans[idx++]=prefixSum[arr[1]];
        }

        return ans;
    }
}