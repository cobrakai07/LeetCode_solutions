class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        StringBuilder sb = new StringBuilder();
        List<String>list = new ArrayList<>();

        for(char c : s.toCharArray()){
            if(c==' '){
                if(sb.length()>0)
                    list.add(new String(sb.toString()));
                sb = new StringBuilder();
            }
            else{
                sb.append(c);
            }
        }

        list.add(new String(sb.toString()));
        sb = new StringBuilder();

        for(int i=list.size()-1;i>=0;i--){
            sb.append(list.get(i)+" ");
        }
        return sb.toString().trim();
    }
}