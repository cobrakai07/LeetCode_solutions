class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        StringBuilder sb = new StringBuilder();
        for(String s: chunks){
            sb.append(s);
        }

        // System.out.println(sb);
        String notSep = "abcdefghijklmnopqrstuvwxyz";
        Map<String,Integer> map = new HashMap<>();
        StringBuilder temp = new StringBuilder();
        for(int i=0;i<sb.length();i++){
            char curr = sb.charAt(i);
           
            if(curr=='-'){
                if(i-1>=0 && notSep.indexOf(sb.charAt(i-1))!= -1 && i+1<sb.length() && notSep.indexOf(sb.charAt(i+1))!= -1){
                    temp.append(curr);
                }else{
                    String tempStr = temp.toString();
                    map.put(tempStr,map.getOrDefault(tempStr,0)+1);
                    temp = new StringBuilder();
                }
            }
            else if(notSep.indexOf(curr)==-1){
                String tempStr = temp.toString();
                map.put(tempStr,map.getOrDefault(tempStr,0)+1);
                temp = new StringBuilder();
            }else{
                temp.append(curr);
            }
        }
        String tempStr = temp.toString();
        map.put(tempStr,map.getOrDefault(tempStr,0)+1);
        // System.out.println(map);
        int[] ans = new int[queries.length];
        int idx = 0;
        for(String q: queries){
            ans[idx++]=map.getOrDefault(q,0);
        }
        return ans;
    }
}