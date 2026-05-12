class Solution {

    boolean canBeDone(int startEnergy, int[][] tasks){

        for(int i = 0; i < tasks.length; i++){

            int actual = tasks[i][0];
            int minimum = tasks[i][1];

            if(startEnergy < minimum) return false;

            startEnergy -= actual;
        }

        return true;
    }

    public int minimumEffort(int[][] tasks) {

        Arrays.sort(tasks, (a, b) ->
            Integer.compare(
                (b[1] - b[0]),
                (a[1] - a[0])
            )
        );

        int low = 0;
        int high = 1_000_000_000;
        int ans = -1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(canBeDone(mid, tasks)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
}