class Solution {
    public int maxArea(int[] height) {
      int maxVol=0;
      int ptr1=0,ptr2=height.length-1;
       while(ptr1<ptr2)
       {
           
           if(height[ptr1]<=height[ptr2])
           {
               int vol=height[ptr1]*(ptr2-ptr1);
               if(vol>maxVol)maxVol=vol;
               ptr1++;
           }
             if(height[ptr1]>height[ptr2])
           {
               int vol=height[ptr2]*(ptr2-ptr1);
               if(vol>maxVol)maxVol=vol;
               ptr2--;
           }
       }  
       return maxVol;
    }
}