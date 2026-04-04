class Solution {

    public String decodeCiphertext(String encodedText, int rows) {

        int len = encodedText.length();
        if(len==0)return "";
        int cols = len / rows;

        char[][] arr = new char[rows][cols];

        int idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = encodedText.charAt(idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        int x = 0;
        int y = 0;
        int yPre = y;

        while (x < rows && y < cols) {

            sb.append(arr[x][y]);
            x++;
            y++;
            if (x == rows) {
                x = 0;
                y = yPre + 1;
                yPre = y;
            }
        }

        // for(char [] a: arr){
        //     System.out.println(Arrays.toString(a));
        // }
        // System.out.println(cols*rows +" "+ len);

        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) != ' ') {
                idx = i;
                break;
            }
        }

        return sb.toString().substring(0, idx + 1);
    }
}