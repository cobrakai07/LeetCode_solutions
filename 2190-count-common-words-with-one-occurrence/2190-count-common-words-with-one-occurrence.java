class Solution {
    public int countWords(String[] str1, String[] str2) {
        Map<String,Integer>m1=new HashMap<>();
        Map<String,Integer>m2=new HashMap<>();
        for(String ss: str1)m1.put(ss, m1.getOrDefault(ss,0)+1);
        for(String ss: str2)m2.put(ss, m2.getOrDefault(ss,0)+1);
        int ans =0;
        for(String ss : str1){
            if(m1.get(ss)==null || m2.get(ss)==null)continue;
            if(m1.get(ss)==1 && m2.get(ss)==1)ans++;
        }
        return ans;
    }
}