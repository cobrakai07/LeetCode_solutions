class Solution {
    public String shiftingLetters(String s, int[][] shifts) {

        int[] lineSweep=new int[s.length()];
        
        for(int [] arr : shifts){
            int startIndex= arr[0];
            int endIndex= arr[1]+1;
            int direction= arr[2];

            if(endIndex < lineSweep.length){
                if(direction ==0 ){
                    lineSweep[startIndex]--;
                    lineSweep[endIndex]++;
                }else{
                    lineSweep[startIndex]++;
                    lineSweep[endIndex]--;
                }
            }else{
                if(direction ==0 ){
                    lineSweep[startIndex]--;
                }else{
                    lineSweep[startIndex]++;
                }
            }
        }

        for(int i=1;i<lineSweep.length;i++){
            lineSweep[i]=lineSweep[i-1]+lineSweep[i];
        }

         StringBuilder str = new StringBuilder();
        for (int i = 0; i < lineSweep.length; i++) {
            int asci = s.charAt(i) - 97; 
            int newIndex = (lineSweep[i] + asci) % 26; 
            
            if (newIndex < 0) {
                newIndex += 26;
            }

            str.append((char) (newIndex + 97)); 
        }


        // System.out.println(Arrays.toString(lineSweep));
        return str.toString();
    }
}