class Solution {
    public void rev(int i, int j, List<Integer> list){
        while(i<j){
            int temp = list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
            i++;j--;
        }
    }
    public void rotateList(int k,List<Integer> list){
        k=k%list.size();
        
        rev(0,k-1,list);
        rev(k,list.size()-1,list);
        rev(0,list.size()-1,list);
    }
    public void rotate(int k, int[][] grid) {

        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        
        int limit = Math.min(grid.length / 2, grid[0].length / 2);
        int size = grid.length;
        int reduce = 0;

        for (int it = 0; it < limit; it++) {

            int i = it;
            int j = i;

            
            

            List<Integer> list = new ArrayList<>();

            for (int d = 0; d < 4; d++) {

                int ni = dir[d][0], nj = dir[d][1];

                if (d == 0 || d == 2) {
                    int count = 0;
                    while (count != grid[0].length - 1 - reduce) {
                        list.add(grid[i][j]);
                        i = i + ni;
                        j = j + nj;
                        count++;
                    }
                } else {
                    int count = 0;
                    while (count != grid.length - 1 - reduce) {
                        list.add(grid[i][j]);
                        i = i + ni;
                        j = j + nj;
                        count++;
                    }
                }

            }

            // System.out.println(list+"  ....");
            rotateList(k,list);
            // System.out.println(list+"  ...rr.");

            int fi = it;
            int fj = j;
            int idx = 0;

            for (int d = 0; d < 4; d++) {

                int ni = dir[d][0], nj = dir[d][1];

                if (d == 0 || d == 2) {
                    int count = 0;
                    while (count != grid[0].length - 1 - reduce) {
                       grid[fi][fj] = list.get(idx++);
                        fi = fi + ni;
                        fj = fj + nj;
                        count++;
                    }
                } else {
                    int count = 0;
                    while (count != grid.length - 1 - reduce) {
                        grid[fi][fj] = list.get(idx++);
                        fi = fi + ni;
                        fj = fj + nj;
                        count++;
                    }
                }

            }

            reduce = reduce+2;

            
        }
    }

    public int[][] rotateGrid(int[][] grid, int k) {
        rotate(k, grid);
        return grid;
    }
}