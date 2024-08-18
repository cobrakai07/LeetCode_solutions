class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)->{
            return Integer.compare(a[1],b[1]);
            // return Integer.compare(a[0],b[0]);
        });

        int arrow=1;
        int ps=points[0][0];
        int pe=points[0][1];

        for(int i=1; i<points.length; i++){
            int cs= points[i][0], ce= points[i][1];
            // System.out.println(cs+" ,"+pe);
            if(cs>pe){
                // System.out.println("bada hai "+i);
                arrow++;
                pe=ce;
            }
        }
        return arrow;
    }
}