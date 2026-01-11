class Solution {
    public int histogram(int row, int[][]arr){
        int n= arr.length;
        int m = arr[0].length;

        int nse[] = new int[m];
        int pse[] = new int[m];

        ArrayDeque<Integer>stk = new ArrayDeque<>();

        for(int i=m-1;i>=0;i--){
            while(!stk.isEmpty() && arr[row][stk.peek()]>=arr[row][i])
                stk.pop();
            nse[i]= stk.isEmpty()?m:stk.peek();
            stk.push(i);
        }

        stk.clear();

        for(int i=0;i<m;i++){
            while(!stk.isEmpty() && arr[row][stk.peek()]>=arr[row][i])
                stk.pop();
            pse[i]= stk.isEmpty()?-1:stk.peek();
            stk.push(i);
        }

        int max = 0;

        for(int i=0;i<m;i++){
            int l = (nse[i]-1)-(pse[i]+1)+1; // j-i+1
            int b = arr[row][i];
            max = Math.max(max, l*b);
        }

        
        // System.out.println(Arrays.toString(pse)+" pse");
        // System.out.println(Arrays.toString(nse)+" nse");
        // System.out.println("______");
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        
        int[][]prefix = new int[matrix.length][matrix[0].length];

        for(int i=0; i<matrix[0].length; i++){
            int sum=0;
            for(int j=0;j<matrix.length; j++){
                if(matrix[j][i]=='1'){
                    sum=sum+1;
                    prefix[j][i]=sum;
                }else{
                    sum=0;
                    prefix[j][i]=sum;
                }
            }
        }

        int max = 0;

        for(int i=0;i<matrix.length;i++){
            max= Math.max(max, histogram(i,prefix));
        }

        // for(int[]aa: prefix)System.out.println(Arrays.toString(aa));
        return max;




    }
}