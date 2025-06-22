class Solution {
    public String[] divideString(String s, int k, char fill) {
        StringBuilder sb = new StringBuilder();
        List<String>ans = new ArrayList<>();
        for(char c: s.toCharArray()){
            if(sb.length()==k){
                ans.add(new String(sb.toString()));
                sb = new StringBuilder();
                sb.append(c);
            }
            else{
                sb.append(c);
            }
        }
        if(sb.length()!=0&&sb.length()<k){
            while(sb.length()<k)sb.append(fill);
            ans.add(new String(sb.toString()));
        }else{
            ans.add(new String(sb.toString()));
        }
        String[] arr = new String[ans.size()];
        for(int i=0; i<ans.size();i++){
            arr[i]=ans.get(i);
        }
        return arr;
        
    }
}