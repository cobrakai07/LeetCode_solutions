class Solution {
    public boolean parseBoolExpr(String expression) {
        ArrayDeque<Character>s= new ArrayDeque<>();
        for(char c: expression.toCharArray()){
            if(c==')'){
                List<Character>list= new ArrayList<>();
                while(s.peek()!='('){
                    char popped=s.pop();
                    if(popped!=',')
                        list.add(popped);
                }
                s.pop();
                char operator=s.pop();
                if(operator=='|'){

                    boolean f1= list.get(0)== 'f' ? false : true ;
                    for(int i=1; i<list.size(); i++){
                        boolean f2= list.get(i)== 'f' ? false : true ;
                        f1 = f1||f2;
                    }
                    char toPush = f1==true ? 't' : 'f';
                    s.push(toPush);

                }else if(operator=='&'){

                    boolean f1= list.get(0)== 'f' ? false : true ;
                    for(int i=1; i<list.size(); i++){
                        boolean f2= list.get(i)== 'f' ? false : true ;
                        f1 = f1&&f2;
                    }
                    char toPush = f1==true ? 't' : 'f';
                    s.push(toPush);

                }else{

                    char toPush = list.get(0)== 'f'  ? 't' : 'f';
                    s.push(toPush);

                }
            }

            else{
                s.push(c);
            }
        }
        // System.out.println(s);
        return s.peek()=='t'? true: false;
    }
}