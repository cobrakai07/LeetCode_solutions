class Solution {
    public int minimumRecolors(String blocks, int k) {

        

        int indexOne=0;
        int indexTwo=0;

        int blackCount=0;
        int whiteCount=0;

        int minimumSwapsRequired=Integer.MAX_VALUE;

        for(int i=0;i<k;i++){
            if(blocks.charAt(indexTwo)=='B')blackCount++;
            else whiteCount++;
            indexTwo++;
        }
        indexTwo--;

        if(whiteCount==0)return 0;

        minimumSwapsRequired = Math.min(whiteCount,minimumSwapsRequired);

        for(; indexTwo<blocks.length() ;){
            // System.out.println(STR."\{minimumSwapsRequired} bc:\{blackCount} wc:\{whiteCount}  i:\{indexOne} j:\{indexTwo}");
            minimumSwapsRequired = Math.min(whiteCount,minimumSwapsRequired);

            if(blocks.charAt(indexOne)=='W')whiteCount--;
            else blackCount--;
            indexOne++;
            if(indexTwo+1<blocks.length()){
                if(blocks.charAt(indexTwo+1)=='W')whiteCount++;
                else blackCount++;
            }
            
            indexTwo++;
        } 

        return minimumSwapsRequired;       
    }
}