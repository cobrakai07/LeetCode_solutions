class Solution {
    public boolean hasAllCodes(String s, int k) {
        int totalPossiblities = (int) Math.pow(2,k);
        Set<String> set = new HashSet<>();
        for(int i=0; i+k<=s.length(); i++){
            set.add(s.substring(i,i+k));
        }
        return totalPossiblities == set.size();
    }
}