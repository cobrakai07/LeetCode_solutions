
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
      Set<Integer>set1=new HashSet<>();
      for(int i=0;i<arr1.length;i++)
      {
        int n=arr1[i];
        while(n!=0)
        {
          set1.add(n);
          n=n/10;
        }
      }
      int max=0;
      for(int i=0;i<arr2.length;i++)
      {
        int n=arr2[i];
        while(n!=0)
        {
          if(set1.contains(n))
          {
            String s=""+n;
            if(s.length()>max)
              max=s.length();
            break;
          }
          n=n/10;
        }
      }
  return max;
    }
}