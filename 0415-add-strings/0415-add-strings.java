class Solution {
    public String addStrings(String num1, String num2) {
   
        String ans="";
        int idx1=num1.length()-1;
        int idx2=num2.length()-1;
        int carry=0;

        while(idx1>=0||idx2>=0)
        {
            int one=0;
            if(idx1>=0)
            {
                one=(int)num1.charAt(idx1)-48;
            }
            int two=0;
            if(idx2>=0)
            {
                two=(int)num2.charAt(idx2)-48;
            }


            if(carry==1)
            {
                if(one+two+carry>9)
                {
                ans=((one+two+carry)%10)+ans;
                carry=1;
                }
                else
                {
                ans=(one+two+carry)+ans;
                carry=0;
                }
            }
            else
            {
                 if(one+two+carry>9)
                {
                ans=((one+two+carry)%10)+ans;
                carry=1;
                }
                else
                {
                ans=(one+two+carry)+ans;
                carry=0;
                }
            }

            idx1--;idx2--;
        }

        if(carry==1)
        {
            ans=1+ans;
        }

        return ans;
    }
}