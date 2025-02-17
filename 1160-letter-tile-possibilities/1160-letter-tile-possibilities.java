class Solution {
    Set<String> set = new HashSet<>();

    public void fun(String str, String tiles, boolean[] used) {
        
        if (!str.isEmpty()) set.add(str);

        for (int i = 0; i < tiles.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                fun(str + tiles.charAt(i), tiles, used);
                used[i] = false;
            }
        }
    }

    public int numTilePossibilities(String tiles) {
        boolean[] used = new boolean[tiles.length()];
        fun("", tiles, used);
        return set.size();
    }
}
