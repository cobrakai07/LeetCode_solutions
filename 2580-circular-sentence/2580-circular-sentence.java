class Solution {
    public boolean isCircularSentence(String sentence) {
        String[]arr=sentence.split(" ");
        if(arr.length==1){
            if(arr[0].charAt(0)==arr[0].charAt(arr[0].length()-1))return true;
            return false;
        }

        char pre= arr[0].charAt(arr[0].length()-1);

        for(int i=1; i<arr.length; i++){
            if(pre!=arr[i].charAt(0))return false;
            pre=arr[i].charAt(arr[i].length()-1);
        }

        if(arr[0].charAt(0)!=arr[arr.length-1].charAt(arr[arr.length-1].length()-1))return false;
        return true;
    }
}