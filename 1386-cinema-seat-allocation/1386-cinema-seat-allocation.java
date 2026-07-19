class Solution {
    
    public int check(int[] arr){
        boolean first = true;
        for(int i=2;i<=5;i++){
           if(arr[i]==-1){
            first = false;
            break;
           }
        }
        boolean second = true;
        for(int i=4;i<=7;i++){
           if(arr[i]==-1){
            second = false;
            break;
           }
        }
        boolean third = true;
        for(int i=6;i<=9;i++){
           if(arr[i]==-1){
            third = false;
            break;
           }
        }

        // System.out.println(Arrays.toString(arr));
        // System.out.println(first+","+second+","+third);

        int possible = 0;
        if(!first && !third && !second)return 2;
        if(!first && !third && second)return 1;
        if(!first || !third)return 1;
        return 0;

    }
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats,(a,b)->{
            if(a[0]==b[0])return Integer.compare(a[1],b[1]);
            else return Integer.compare(a[0],b[0]);
        });

        int ans = 0;

        int[][] arr = reservedSeats;


        int total = n*2;

        for(int i = 0;i<arr.length; ){
            int currRow = arr[i][0];
            int[]row = new int[11];
            row[0]=-1;
            while(i<arr.length && currRow==arr[i][0]){
                row[arr[i][1]]=-1;
                i++;
            }
            int val =  check(row);
            // System.out.println(val);
            total -= val;
        }

        return total;
    }
}