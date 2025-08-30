class Solution {
    public boolean canBePlaced(int minForce, int m, int[] position){
        int prev=position[0];
        m--;
        for(int i=1;i<position.length;i++){
            if(position[i]-prev >= minForce){
                m--;
                prev=position[i];
            }
        }
        return m<=0;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l=0, h=position[position.length-1];
        int ans=0;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(canBePlaced(mid,m,position)){
                ans=mid;
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return ans;
    }
}