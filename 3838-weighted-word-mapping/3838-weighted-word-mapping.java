class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for(String s: words){
            int w = 0;
            for(char c: s.toCharArray()){
                int ascii = weights[c-'a'];
                w+= ascii;
            }
            
            w = w%26;
            w = (25-w)+97;
            // System.out.println(w);
            char c = (char)w;
            sb.append(c);
        }
        return sb.toString();
    }
}