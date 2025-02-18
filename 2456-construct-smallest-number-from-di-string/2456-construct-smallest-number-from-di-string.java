class Solution {

    int minNum= Integer.MAX_VALUE;

    public void fun(int i, String s, String p, boolean []taken){
        if(s.length()==p.length()+1){
            int currNum = Integer.parseInt(s);
            minNum= Math.min(minNum, currNum);
            return;
        }

        if(p.charAt(i)=='I'){
            int greaterThan = Integer.parseInt(""+s.charAt(s.length()-1));
            for(int j=1; j< 10 ;j++){
                if(!taken[j] && j> greaterThan){
                    taken[j]=true;
                    fun(i+1, s+j, p, taken);
                    taken[j]=false;
                }
            }
        }else{
            int smallerThan = Integer.parseInt(""+s.charAt(s.length()-1));
            for(int j=1; j< 10 ;j++){
                if(!taken[j] && j< smallerThan){
                    taken[j]=true;
                    fun(i+1, s+j, p, taken);
                    taken[j]=false;
                }
            }
        }
       
    }
    public String smallestNumber(String pattern) {
        boolean [] vis= new boolean[10];
        for(int i=1;i<10;i++){
            vis[i]= true;
            fun(0,new String(i+""),pattern,vis);
            vis[i]=false;
        }
        return new String(minNum+"");
    }
}