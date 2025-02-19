class Solution {
    Set<String>set= new HashSet<>();
    public void fun(int n, String s, char[] arr){
        int currLength=s.length();
        if(currLength==n){
            set.add(new String(s));
            return;
        }
        
        for(int i=0; i<3;i++){
            if(currLength>0){
                char lastUsed = s.charAt(s.length()-1);
                if(lastUsed!=arr[i])
                    fun(n,s+arr[i],arr);
            }else{
                fun(n,s+arr[i],arr);
            }   
        }
    }
    public String getHappyString(int n, int k) {
        char[] arr={'a','b','c'};
        fun(n,"",arr);
        // System.out.println(set);
        List<String>list=new ArrayList<>(set);
        Collections.sort(list);
        // System.out.println(list);
        return list.size()>=k?list.get(k-1):"";
    }
}