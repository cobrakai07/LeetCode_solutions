class Solution {
    public void reverse(int[]arr, int s, int e){
        while(s<e){
            int t = arr[s];
            arr[s]= arr[e];
            arr[e] = t;
            s++;
            e--;
        }
    }
    public void shift(boolean left, int[] arr, int k) {
    int n = arr.length;
    k = k % n;

    if (k == 0) return;

    if (left) {
        // left rotate
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);
    } else {
        // right rotate
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }
}

    public boolean isNotEqual(int[]a, int []b){
        // System.out.println(Arrays.toString(a));
        // System.out.println(Arrays.toString(b));
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i])return true;
        }
        return false;
    }
    public boolean areSimilar(int[][] mat, int k) {

        int [][] arr = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                arr[i][j] = mat[i][j];
            }
        }

        for(int i=0;i<mat.length;i++){
            if((i&1)==0){
                shift(true,mat[i],k);
            }else{
                shift(false,mat[i],k);
            }

            if(isNotEqual(mat[i],arr[i]))return false;
        }

        return true;
    }
}