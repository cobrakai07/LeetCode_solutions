class Solution {
    public boolean isAnagram(String s, String t) {

        char sa[]= s.toCharArray();
        char ta[]= t.toCharArray();
        Arrays.sort(sa); Arrays.sort(ta);
        if(Arrays.equals(sa,ta))return true;
        return false;
    }
}