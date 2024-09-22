class Solution {
    // Check if it is possible to ship within 'days' given a capacity 'c'
    public boolean fun(int c, int days, int[] nums) {
        int curr = 0;  // Current weight on the ship for the day
        int currDays = 1;  // Number of days required (start with day 1)
        
        for (int i : nums) {
            // If the current weight + next package exceeds capacity
            if (curr + i > c) {
                currDays++;  // Increment days
                curr = i;  // Start a new day with this package
                
                // If the number of days exceeds allowed days, return false
                if (currDays > days) return false;
            } else {
                curr += i;  // Add package to current day
            }
        }
        return true;  // Return true if shipping is possible within 'days'
    }

    // Binary search to find the minimum ship capacity
    public int shipWithinDays(int[] weights, int days) {
        int min = 0;  // The minimum ship capacity is at least the heaviest package
        int max = 0;  // The maximum ship capacity is the sum of all weights
        
        for (int i : weights) {
            min = Math.max(min, i);  // The minimum capacity must be at least the largest item
            max += i;  // The maximum capacity is the total weight (one trip)
        }
        
        int ans = -1;
        while (min <= max) {
            int mid = min + (max - min) / 2;  // Calculate the mid-point capacity
            if (fun(mid, days, weights)) {  // Check if it's possible to ship with this capacity
                ans = mid;  // Store the valid capacity
                max = mid - 1;  // Try to find a smaller valid capacity
            } else {
                min = mid + 1;  // Try to find a larger valid capacity
            }
        }

        return ans;
    }
}
