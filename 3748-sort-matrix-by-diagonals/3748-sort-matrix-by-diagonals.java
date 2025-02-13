class Solution {
    public int[][] sortMatrix(int[][] grid) {
        List<List<Integer>>list= new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            List<Integer>temp= new ArrayList<>();
            for(int x=i,y=0;x<grid.length && y<grid[0].length; x++,y++){
                temp.add(grid[x][y]);
            }
            Collections.sort(temp,(a,b)->b-a);
            list.add(temp);
        }
        for(int i=0;i<grid.length;i++){
            List<Integer>temp= list.get(i);
            for(int x=i,y=0, it=0;x<grid.length && y<grid[0].length; x++,y++){
                grid[x][y]=temp.get(it++);
            }
        }
        list.clear();
        for(int i=1;i<grid[0].length;i++){
            List<Integer>temp= new ArrayList<>();
            for(int x=0,y=i;x<grid.length && y<grid[0].length; x++,y++){
                temp.add(grid[x][y]);
            }
            Collections.sort(temp,(a,b)->a-b);
            list.add(temp);
        }

        for(int i=1;i<grid[0].length;i++){
            List<Integer>temp= list.get(i-1);
            for(int x=0,y=i, it=0;x<grid.length && y<grid[0].length; x++,y++){
                grid[x][y]=temp.get(it++);
            }
          
        }

        return grid;
    }
}