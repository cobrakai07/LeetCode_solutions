class Solution {
    public List<String> partitionString(String s) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            sb.append(c);
            if(!set.contains(sb.toString())){
                set.add(sb.toString());
                ans.add(new String(sb.toString()));
                sb = new StringBuilder();
            }
        }
        // System.out.println(set);
        return ans;
    }
}