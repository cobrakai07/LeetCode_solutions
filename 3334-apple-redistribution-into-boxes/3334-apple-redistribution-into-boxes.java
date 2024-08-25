class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
    //    Arrays.sort(capacity,(a,b)->b-a);
    List<Integer>list=Arrays.stream(capacity)
      .boxed()
      .collect(Collectors.toList());
    Collections.sort(list,(a,b)->b-a);
       int total =Arrays.stream(apple).sum();
       int count=0;

       for(int i: list){
        // System.out.println(list);
        // System.out.println(total);
        total=total-i;
        count++;
        if(total<=0)break;
        
       } 
       return count;
    }
}