class Solution {
    public void fun(StringBuilder sb, int ob, int cb, int max, List<String>list){
        if(sb.length()==max*2){
            list.add(new String(sb.toString()));
            return;
        }

        if(ob<max){
            sb.append('(');
            fun(sb,ob+1,cb,max,list);
            sb.deleteCharAt(sb.length()-1);
        }
        if(cb<ob){
            sb.append(')');
            fun(sb,ob,cb+1,max,list);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>ans = new ArrayList<>();
        fun(new StringBuilder(),0,0,n,ans);
        return ans;
    }
}