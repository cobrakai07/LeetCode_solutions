class Solution {
    public String fun(String s, String part){
        s=s.substring(0,s.indexOf(part))+s.substring(s.indexOf(part)+part.length(),s.length());
        return s;
    }
    public String removeOccurrences(String s, String part) {
        while(s.indexOf(part)!=-1){
            s=fun(s,part);
            // System.out.println(s);
        }
        // Stack<Character>stk = new Stack<>();
        // for(char c: s.toCharArray()){
        //     stk.push(c);
        //     if(stk.size()>=part.length()){
        //         int count=part.length();
        //         StringBuilder sb = new StringBuilder();
        //         while(count!=0){
        //             sb.append(stk.pop());
        //             count--;
        //         }
        //         if(!sb.toString().equals(part)){
                    
        //            while(count<sb.length()){
        //             stk.push(sb.charAt(count));
        //             count++;
        //         } 
        //         }
        //     }
        // }
        // System.out.println(stk);
        return s;
    }
}