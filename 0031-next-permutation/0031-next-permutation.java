class Solution {
  public void rev(int[] arr, int s, int e) {
    for (int i = s, j = e; i < j; i++, j--) {
      int t = arr[i];
      arr[i] = arr[j];
      arr[j] = t;
    }
  }

  public void nextPermutation(int[] nums) {
    int idx = -1;
    for (int i = nums.length - 2; i >= 0; i--) 
      {
        if (nums[i] < nums[i + 1]) {
          idx = i;
          break;
        }
      }
      if (idx == -1) {
        rev(nums, 0, nums.length - 1);
        return;
      }

      for (int i = nums.length - 1; i >= 0; i--) {
        if (nums[idx] < nums[i]) {
          int t = nums[idx];
          nums[idx] = nums[i];
          nums[i] = t;
          break;
        }
      }
      rev(nums, idx + 1, nums.length - 1);

    
  }
}