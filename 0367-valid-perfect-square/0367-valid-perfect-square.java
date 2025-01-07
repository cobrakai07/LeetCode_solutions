class Solution {
    public boolean isPerfectSquare(int num) {
        String s =Math.sqrt(num)+"";
        s=s.substring(s.indexOf('.'));
        for(int i=1; i<10;i++){
            if(s.contains(i+""))return false;
        }
        return true;
    }
}