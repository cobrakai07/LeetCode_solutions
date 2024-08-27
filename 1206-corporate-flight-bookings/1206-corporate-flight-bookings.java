class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[]sweep= new int[n];
        for(int i[]: bookings){
            sweep[i[0]-1]+=i[2];
            if(i[1]<n)
                sweep[i[1]]-=i[2];
        }
        int prefix[]=new int[n];
        prefix[0]=sweep[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+sweep[i];
        }
        // System.out.println(Arrays.toString(sweep));
        return prefix;
    }
}