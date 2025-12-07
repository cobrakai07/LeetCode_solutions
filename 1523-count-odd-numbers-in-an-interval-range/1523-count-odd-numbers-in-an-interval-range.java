class Solution {
    public int countOdds(int low, int high) {
    int total = high - low +1;
       if(high%2==1 && low%2==1)return total - (total/2);
        else if(high%2!=1 && low%2!=1)return  (total/2);
        else if(high%2==1 && low%2!=1)return (total/2);
         else return (total/2);
    //    1 2 3 4 5 // 1 2 3 4 5 6 7
    //    2 3 4 5 6 // 0 1 2 3 4 5 6
    //    1 2 3 4 // 
    //    2 3 4 5// 2 3 4 5 6 7
    }
}