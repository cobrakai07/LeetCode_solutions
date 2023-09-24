class Solution {
    private void fun(int idx,char[]arr,List<String>ans,String str)
    {
      if(idx==arr.length)
      {
        ans.add(new String(str));
        return;
      }

      if((arr[idx]>=65&&arr[idx]<=90)||(arr[idx]>=97&&arr[idx]<=122))
      {
        swap(arr,idx);
        str=str+arr[idx];
        fun(idx+1,arr,ans,str);
        str=str.substring(0,str.length()-1);
        swap(arr,idx);
        str=str+arr[idx];
        fun(idx+1,arr,ans,str);
        str=str.substring(0,str.length()-1);
      }
      else
      {
        str=str+arr[idx];
        fun(idx+1,arr,ans,str);
        str=str.substring(0,str.length()-1);
       
      }
    }
    private void swap(char[]arr,int idx)
    {
      char temp=arr[idx];
      if(arr[idx]>=65&&arr[idx]<=90)
        {
          arr[idx]=(char)(temp+32);
        }
      else
      {
        arr[idx]=(char)(temp-32);
      }
    }
    public List<String> letterCasePermutation(String s) {
      List<String>ans=new ArrayList<>();
      char[]arr=s.toCharArray();
      fun(0,arr,ans,new String());
      return ans;
    }
}