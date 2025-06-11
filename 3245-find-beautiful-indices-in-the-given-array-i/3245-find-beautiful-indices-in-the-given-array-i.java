class Solution {
    public void fill(String s,String t, List<Integer>list){
        int i=0,j=t.length()-1;
        for(;j<s.length();i++,j++){
            if(s.substring(i,j+1).equals(t))list.add(i);
        }
    }
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer>lista = new ArrayList<>();
        List<Integer>listb = new ArrayList<>();

        fill(s,a,lista);
        fill(s,b,listb);

        List<Integer>ans = new ArrayList<>();
        for(int i=0;i<lista.size();i++){
            for(int j=0;j<listb.size();j++){
                if(Math.abs(lista.get(i)-listb.get(j))<=k){
                    ans.add(lista.get(i));break;
                }
            }
        }
        return ans;

    }
}