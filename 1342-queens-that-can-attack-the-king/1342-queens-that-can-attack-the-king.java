class Solution {
    private boolean fun(int[]queen,int[][]board)
    {
        int x=queen[0],y=queen[1];

        for(int i=x+1;i<board.length;i++)//down
        {
            if(board[i][y]==69)break;
            if(board[i][y]==100)
            return true;
        }
        for(int i=x-1;i>=0;i--)//up
        {
            if(board[i][y]==69)break;
            if(board[i][y]==100)
            return true;
        }
        for(int i=y+1;i<board[0].length;i++)//left
        {
            if(board[x][i]==69)break;
            if(board[x][i]==100)
            return true;
        }
        for(int i=y-1;i>=0;i--)//right
        {
            if(board[x][i]==69)break;
            if(board[x][i]==100)
            return true;
        }

        for(int i=x-1,j=y-1;i>=0&&j>=0;i--,j--)//up left
        {
            if(board[i][j]==69)break;
            if(board[i][j]==100)
            return true;
        }
        for(int i=x-1,j=y+1;i>=0&&j<board[0].length;i--,j++)//up right
        {
            if(board[i][j]==69)break;
             if(board[i][j]==100)
            return true;
        }
        for(int i=x+1,j=y-1;i<board.length&&j>=0;i++,j--)//down left
        {
            if(board[i][j]==69)break;
            if(board[i][j]==100)
            return true;
        }
        for(int i=x+1,j=y+1;i<board.length&&j<board[0].length;i++,j++)//down right
        {
            if(board[i][j]==69)break;
            if(board[i][j]==100)
            return true;
        }

        return false;

    }
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>>ans=new ArrayList<>();

        int [][]board=new int[8][8];
        board[king[0]][king[1]]=100;

        for(int i=0;i<queens.length;i++)
        {
              int arr[]=queens[i];
            {
                board[arr[0]][arr[1]]=69;
            }
        }

        for(int i=0;i<queens.length;i++)
        {
            if(fun(queens[i],board))
            {
                List<Integer>temp=new ArrayList<>();
                temp.add(queens[i][0]);
                temp.add(queens[i][1]);
                ans.add(temp);
            }
        }

        return ans;
    }
}