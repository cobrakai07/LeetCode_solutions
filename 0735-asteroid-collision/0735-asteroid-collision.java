class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer>st= new ArrayDeque<>();
        for(int i: asteroids){
            if(i<0){
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(i)){
                    st.pop();
                }
                boolean destroyed=false;
                while(!st.isEmpty() && st.peek()>0 && st.peek()==Math.abs(i)){
                    st.pop();
                    destroyed=true;
                    break;
                }
                if(!st.isEmpty() && st.peek()>0 && st.peek()>Math.abs(i)) 
                    destroyed=true;
                if(!destroyed)
                    st.push(i);
                
            }else{
                st.push(i);
            }
        }
        int[]ans = new int[st.size()];
        for(int i=ans.length-1;i>=0;i--)
            ans[i]=st.pop();
        return ans;
    }
}