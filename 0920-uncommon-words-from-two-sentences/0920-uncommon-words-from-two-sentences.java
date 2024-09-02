class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] str1=s1.split(" ");
        String[] str2=s2.split(" ");
        Map<String,Integer>m1=new HashMap<>();
        Map<String,Integer>m2=new HashMap<>();
        for(String ss: str1)m1.put(ss, m1.getOrDefault(ss,0)+1);
        for(String ss: str2)m2.put(ss, m2.getOrDefault(ss,0)+1);
        List<String>list=new ArrayList<>();
        // System.out.println(m1+" -- "+m2);
        for(String ss: str1){
            if(m1.get(ss)==1 && m2.get(ss)==null)list.add(ss);
        }
        for(String ss: str2){
            if(m2.get(ss)==1 && m1.get(ss)==null)list.add(ss);
        }
        String[]ans = new String[list.size()];
        int i=0;
        for(String ss: list)ans[i++]=ss;
        return ans;
    }
}