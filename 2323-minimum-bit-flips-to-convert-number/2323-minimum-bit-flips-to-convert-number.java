class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;  // XOR to find the differing bits
        int count = 0;
        
        while (xor != 0) {
            count += xor & 1;   // Add 1 to count if the LSB is 1
            xor >>= 1;          // Shift right to check the next bit
        }
        
        return count;
    }
}
