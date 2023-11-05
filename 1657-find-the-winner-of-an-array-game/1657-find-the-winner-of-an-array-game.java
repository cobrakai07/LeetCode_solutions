class Solution {
    public int getWinner(int[] arr, int k) {

        if(k>=arr.length)
        {
            int max=Integer.MIN_VALUE;
            for(int i=0;i<arr.length;i++)
              {
                  if(max<arr[i])
                    max=arr[i];
              }
              return max;
        }

        Queue<Integer>q=new ArrayDeque<>();
        for(int i=1;i<arr.length;i++)
            q.offer(arr[i]);

        int winCount=0;
        int winner=arr[0];
        
        while(winCount!=k)
        {
            int contender=q.poll();
            if(winner<contender)
            {
                q.offer(winner);
                winner=contender;
                winCount=1;
            }
            else
            {
                q.offer(contender);
                winCount++;
            }
        }
        return winner;
        
    }
}