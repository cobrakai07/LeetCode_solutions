record Pair(char ch, int c){}
class Solution {
    public String makeFancyString(String s) {
        ArrayDeque<Pair>stk = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            // System.out.println(stk);
            if(stk.isEmpty()){
                Pair p = new Pair(c,1);
                stk.push(p);
            }else{
                Pair p = stk.peek();
                if(p.ch()==c && p.c()==2){continue;}
                else{
                    if(p.ch()==c)
                       { Pair p1 = new Pair(c,p.c()+1);
                        stk.push(p1);}
                    else
                       { Pair p1 = new Pair(c,1);
                        stk.push(p1); } 
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty())sb.append(stk.pop().ch());
        return sb.reverse().toString();
    }
}