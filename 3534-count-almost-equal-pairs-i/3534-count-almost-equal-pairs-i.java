class Solution {
    public boolean check(int num1, int num2) {
        String first = String.valueOf(num1);
        String second = String.valueOf(num2);

        while (first.length() < second.length()) first = "0" + first;
        while (second.length() < first.length()) second = "0" + second;

        int diffCount = 0;
        int firstMismatch = -1, secondMismatch = -1;

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                diffCount++;
                if (diffCount == 1) {
                    firstMismatch = i;
                } else if (diffCount == 2) {
                    secondMismatch = i;
                } else {
                    return false;
                }
            }
        }


        if (diffCount == 2) {
            char[] firstArray = first.toCharArray();
            char temp = firstArray[firstMismatch];
            firstArray[firstMismatch] = firstArray[secondMismatch];
            firstArray[secondMismatch] = temp;
            first = new String(firstArray);
        }

        return first.equals(second);
    }

    public int countPairs(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i]== nums[j] || check(nums[i], nums[j])) {
                    count++;
                }
            }
        }
        return count;
    }

}