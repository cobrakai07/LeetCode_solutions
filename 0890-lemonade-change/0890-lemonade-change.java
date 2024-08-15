class Solution {
    public boolean lemonadeChange(int[] bills) {
        int ten=0,five=0,twenty=0;
        for(int i: bills)
        {
            // System.out.println(i+" "+five+","+ten+","+twenty);
            if(i==5)
            {
                five++;
            }
            else if(i==10)
            {
                // System.out.println("10---");
                if(five==0)return false;
                five--;
                ten++;
            }
            else if(i==20)
            {
                //   System.out.println("20---");
                  if(ten>=1 && five>=1)
                  {
                    five--;
                    ten--;
                  }
                  else if(five>=3)
                  {
                    five-=3;
                  }   
                  else 
                  {
                    return false;
                  } 
            }

        }
        return true;
    }
}