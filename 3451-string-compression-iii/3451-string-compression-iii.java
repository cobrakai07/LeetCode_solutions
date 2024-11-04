class Solution {
    public String compressedString(String word) {
        // Stack<Character>stk=new Stack<>();
        StringBuilder sb= new StringBuilder();
        char[]arr=word.toCharArray();
        int count=0;
        int e=0;
        char pre=arr[0];
        while(e<arr.length)
        {
            // System.out.println(pre+" "+count+" "+e);
            if(count==0)
            {
                pre=arr[e];
                count=1;
                e++;
                continue;
            }
            else if(pre==arr[e]&&count<9)
            {
                e++;
                count++;
                continue;
            }
            else if(pre==arr[e]&&count==9)
            {
                sb.append(count);
                sb.append(pre);
                count=1;
                e++;
                continue;
            }
            else if(pre!=arr[e])
            {
                sb.append(count);
                sb.append(pre);
                pre=arr[e];
                count=1;
                e++;
                continue;
            }
        }
        sb.append(count);
        sb.append(pre);
        return sb.toString();
    }
}