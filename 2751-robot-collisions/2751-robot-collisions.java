class Pair{
    int i,p,h;
    char d;
    Pair(int i, int p, int h ,char d){
        this.i=i;this.p=p;
        this.h=h; this.d=d;
    }
    public String toString(){
        return this.i+"|"+this.p+"|"+this.h+"|"+this.d;
    }
}
class Solution {
    public void fun(Pair p, ArrayDeque<Pair>s){
        if(s.isEmpty()){
            s.push(p);return;
        }
        if(s.peek().d=='L'){
            s.push(p);return;
        }
        if(p.h==s.peek().h){
            s.pop();return;
        }
        if(p.h<s.peek().h){
            Pair t= s.pop();
            t.h--;
            s.push(t);
            return;
        }
        if(p.h>s.peek().h){
            s.pop();
            p.h--;
            fun(p,s);
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
       ArrayDeque<Pair>s=new ArrayDeque<>(); 
       List<Pair>list=new ArrayList<>();

       for(int i=0;i<positions.length;i++){
            list.add(new Pair(i,positions[i],healths[i],directions.charAt(i)));
       }

       Collections.sort(list,(a,b)->a.p-b.p);
        // System.out.println(list);
       for(int i=0;i<list.size();i++){
        // System.out.println(s+" //");
        Pair p=list.get(i);

        if(p.d=='R'){
            s.push(p);

        }else if(p.d=='L'){
            // System.out.println(s+" L enter");
            fun(p,s);
            // System.out.println(s+" L exit");
        }

       }
       list=new ArrayList<>();

       while(!s.isEmpty())list.add(s.pop());
        Collections.sort(list,(a,b)->a.i-b.i);
    //    System.out.println(list);
    List<Integer>ans=new ArrayList<>();
    for(Pair p: list)ans.add(p.h);
       return ans;
    }
}