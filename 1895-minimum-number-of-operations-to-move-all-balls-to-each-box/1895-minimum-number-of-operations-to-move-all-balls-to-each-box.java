class Solution {
    public int[] minOperations(String boxes) {
    //keep track of how many balls there are to the right.
    //calculate base case for first index. 
    //when we iterate right, if we encounter a 1, 
        int rightSideCount = 0; 
        int leftSideCount = 0; 
        int currentVal = 0;
        char[] box = boxes.toCharArray();
        for(int i = box.length - 1; i>= 0; i--){
            if(box[i] == '1'){
                rightSideCount += 1;
                currentVal += i;
            }
        }
        int[] result = new int[box.length];
        for(int i =0; i<box.length; i++){
            result[i] = currentVal;
            if(box[i] == '1'){
                rightSideCount --; 
                leftSideCount ++;
            }
            currentVal = currentVal - rightSideCount;
            currentVal = currentVal + leftSideCount; 
        }
        return result;
    }
}