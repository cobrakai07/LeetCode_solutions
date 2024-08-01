class Solution {
    public int countSeniors(String[] details) {
        int c=0;
        for(String s: details){
            String age =s.substring(11,13);
            // System.out.println(age);
            if(Integer.parseInt(age)>60)c++;
        }
        return c;
    }
}