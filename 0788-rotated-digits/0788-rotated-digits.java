class Solution {
    public int rotatedDigits(int n) {
        // 3,4,7 //invalid
        // 0,1,8 //no change invalid
        int ans = 0;
        for (int i = 1; i <= n; i++) {

            StringBuilder sb = new StringBuilder(i+"");
            StringBuilder sbnew = new StringBuilder();

            boolean valid = true;

            for (int it = 0; it < sb.length(); it++) {
                int num = sb.charAt(it) - '0';
                // System.out.println(num);
                if (num == 3 || num == 4 || num == 7) {
                    valid = false;
                    break;
                } else if (num == 2 || num == 5 || num == 6 || num == 9) {
                    char temp = switch (num) {
                        case 2 -> '5';
                        case 5 -> '2';
                        case 6 -> '9';
                        case 9 -> '6';
                        default -> '0';
                    };
                    sbnew.append(temp);
                } else {
                    sbnew.append(num+"");
                }
            }
            // System.out.println(sbnew);
            if (sbnew.length() == 0)
                continue;
            int newnum = Integer.parseInt(sbnew.toString());
            // if(valid && newnum !=i)

            if (valid && i != newnum)
                ans++;
        }

        return ans;

    }
}