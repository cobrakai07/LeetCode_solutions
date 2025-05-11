class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length<3)return false;
        int c=0;

        int s=0,e=0;
        while(e<arr.length){

            if(arr[e]%2==1){
                
                if(e-s+1==3)
                {
                    return true;
                }
                else
                {
                    e++;
                }
            }
            else{
                s++;
                e=s;
                c=0;
            }
        }
        return false;
        
    }
}