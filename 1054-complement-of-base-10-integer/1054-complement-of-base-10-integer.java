class Solution {
    public int bitwiseComplement(int num) {
                // Step 1: Convert the number to binary and find its complement

        if(num==1 || num==0)return num==1? 0:1;
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            int r = num % 2;
            sb.append(r == 1 ? '0' : '1'); // Find complement (0->1, 1->0)
            num = num / 2;
        }
        
        // Step 2: Reverse the binary string as we built it in reverse order
        
        sb.reverse();
        
        // Step 3: Convert the complemented binary string back to a decimal number
        int ans = 0;
        int length = sb.length();
        for(int i = 0; i < length; i++){
            if(sb.charAt(i) == '1') {
                ans += (int)Math.pow(2, length - 1 - i);
            }
        }
        
        return ans;
    }
}