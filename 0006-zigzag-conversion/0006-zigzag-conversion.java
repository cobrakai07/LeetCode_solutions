class Solution {
    
    public String convert(String s, int numRows) {
        if(numRows==1)return s;
        int[][]arr= new int[numRows][s.length()];
        int idx=0;
        char[]str=s.toCharArray();
        boolean flag=true;
        int i=0,j=0;

        while(idx<s.length()){
            if(flag){
                for(;i<arr.length && idx<str.length;i++){
                    arr[i][j]=(int)str[idx++];
                }
                flag=false;
                i=i-2;
                j=j+1;
                // System.out.println(i+","+j+"   down");
            }else{
                for(;i>=0 && j<arr[0].length&& idx<str.length;i--,j++){
                    arr[i][j]=(int)str[idx++];
                }
                flag=true;
                i=i+2;
                j=j-1;
                // System.out.println(i+","+j+"   up");
            }
        }

        StringBuilder sb = new StringBuilder();
        // for(int[] x: arr)System.out.println(Arrays.toString(x));
        for(int x=0;x<arr.length;x++){
            for(int y=0; y<arr[0].length;y++){
                if(arr[x][y]!=0){
                    sb.append((char)(arr[x][y]));
                }
            }
        }
        return sb.toString();
    }
}