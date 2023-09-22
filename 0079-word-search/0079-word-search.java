class Solution {
    boolean flag=false;
    public void fun(int idx,int idy,int wordIdx,String str,char[] word,char[][]board)
    {
      
        if(word.length==str.length()||wordIdx==word.length)
        {
            String s=new String(word);
            if(s.equals(str))
            {
                flag=true;
            }
            return;
        }
        
        if((idx==board.length&&idy==board[0].length)||(idx<0)||(idy<0))return;

        if(idx+1<board.length)//down
        {
            if(board[idx+1][idy]==word[wordIdx])
            {
                str=str+board[idx+1][idy];
                char temp=board[idx+1][idy];
                board[idx+1][idy]='8';
                fun(idx+1,idy,wordIdx+1,str,word,board);
                str=str.substring(0,str.length()-1);
                board[idx+1][idy]=temp;
            }
        }
        if(idx-1>=0)//up
        {
            if(board[idx-1][idy]==word[wordIdx])
            {
                str=str+board[idx-1][idy];
                 char temp=board[idx-1][idy];
                board[idx-1][idy]='8';
                fun(idx-1,idy,wordIdx+1,str,word,board);
                str=str.substring(0,str.length()-1);
                board[idx-1][idy]=temp;
            }
        }
        if(idy+1<board[0].length)//left
        {
            if(board[idx][idy+1]==word[wordIdx])
            {
                str=str+board[idx][idy+1];
                char temp=board[idx][idy+1];
                board[idx][idy+1]='8';
                fun(idx,idy+1,wordIdx+1,str,word,board);
                str=str.substring(0,str.length()-1);
                board[idx][idy+1]=temp;
            }
        }
         if(idy-1>=0)//right
        {
            if(board[idx][idy-1]==word[wordIdx])
            {
                str=str+board[idx][idy-1];
                char temp=board[idx][idy-1];
                board[idx][idy-1]='8';
                fun(idx,idy-1,wordIdx+1,str,word,board);
                str=str.substring(0,str.length()-1);
                board[idx][idy-1]=temp;
            }
        }
    }
    public boolean exist(char[][] board, String word) {
        char []wordarr=word.toCharArray();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(word.charAt(0)==board[i][j])
                {
                    if(flag)return true;;
                    String str="";
                    str=str+word.charAt(0);
                    char temp=board[i][j];
                    board[i][j]='8';//visited
                    fun(i,j,1,str,wordarr,board);
                    board[i][j]=temp;
                }
            }
        }
        if(flag)return true;
        return false;
    }
}