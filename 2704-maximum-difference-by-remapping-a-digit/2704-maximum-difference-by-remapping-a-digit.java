class Solution {
    public int minMaxDifference(int num) {
      String s = num+"";
    //   Map<Character,List<Integer>>mp = new HashMap<>();
    //   for(int i=0;i<s.length();i++){
    //     if(mp.get(s.charAt(i))==null){
    //         List<Integer>list= new ArrayList<>();
    //         list.add(i);
    //         mp.put(s.charAt(i),list);
    //     }else{
    //         List<Integer>list=mp.get(s.charAt(i));
    //         list.add(i);
    //     }
    //   }

      StringBuilder max= new StringBuilder(s);
      char c = max.charAt(0);
      for(int i=0; i<max.length();i++){
        if(max.charAt(i)!='9'){
            c=max.charAt(i);
            break;
        }
      }
      for(int i=0; i<max.length();i++){
        if(max.charAt(i)==c)max.setCharAt(i,'9');
      }
      int maxNum = Integer.parseInt(max.toString());

      StringBuilder min= new StringBuilder(s);
       c = min.charAt(0);
      for(int i=0; i<min.length();i++){
        if(min.charAt(i)==c)min.setCharAt(i,'0');
      }
      int minNum = Integer.parseInt(min.toString());
        // System.out.println(max+" "+min);
      return maxNum-minNum;  
    }
}
