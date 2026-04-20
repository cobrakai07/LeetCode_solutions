class Solution {
    public int maxDistance(int[] colors) {
        int max = 0;
        int i=0, j = colors.length-1;
        while(i<=j){
            if(colors[i]==colors[j]){
                i++;
            }else{
                max = Math.max(max,Math.abs(i-j));
                j--;
            }

        }
        i=0; 
        j = colors.length-1;
        while(i<=j){
            if(colors[i]==colors[j]){
                j--;
            }else{
                max = Math.max(max,Math.abs(i-j));
                i++;
            }

        }
        return max;
    }
}