class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for(char c: moves.toCharArray()){
            switch(c){
                case 'U' -> x++;
                case 'D' -> x--;
                case 'L' -> y--;
                case 'R' -> y++;
            }
        }
        return x==0 && y==0;
    }
}