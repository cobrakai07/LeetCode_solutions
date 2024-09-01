class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        String s1="aceg";
        String s2="bdfh";

        Set<String>black=new HashSet<>();
        Set<String>white=new HashSet<>();

        for(int i=1; i<=7; i=i+2){
            for(char c: s1.toCharArray())
                {
                    String ss=""+c+i;
                    black.add(ss);
                }
        }
        for(int i=1; i<=7; i=i+2){
            for(char c: s2.toCharArray())
                {
                    String ss=""+c+i;
                    white.add(ss);
                }
        }
        for(int i=2; i<=8; i=i+2){
            for(char c: s2.toCharArray())
                {
                    String ss=""+c+i;
                    black.add(ss);
                }
        }
        for(int i=2; i<=8; i=i+2){
            for(char c: s1.toCharArray())
                {
                    String ss=""+c+i;
                    white.add(ss);
                }
        }

        if(black.contains(coordinate1)&&black.contains(coordinate2))return true;
        if(white.contains(coordinate1)&&white.contains(coordinate2))return true;
        return false;
    }
}