class Solution {
    public void setZeroes(int[][] m) {
        List<int[]>list = new ArrayList<>();
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                if(m[i][j]==0){
                    list.add(new int[]{i,j});
                }
            }
        }

        // list.forEach(e->System.out.println(Arrays.toString(e)));

        for(int [] a: list){
            int r=a[0], c=a[1];

            for(int i=0;i<m[0].length;i++)
                m[r][i]=0;

            for(int i=0;i<m.length;i++)
                m[i][c]=0;


            // for(int x[]: m)System.out.println(Arrays.toString(x));
            // System.out.println();
                
        }


    }
}