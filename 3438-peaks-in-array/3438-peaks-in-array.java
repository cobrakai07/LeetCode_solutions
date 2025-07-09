class SegmentTree {
    int[] seg;
    int[] nums;

    SegmentTree(int n, int[] nums) {
        seg = new int[4 * n];
        this.nums = nums;
        build(0, 0, nums.length - 1);
    }

    void build(int i, int s, int e) {
        if (s == e) {
            if (s == 0 || s == nums.length - 1) {
                seg[i] = 0;
            } else {
                seg[i] = (nums[s - 1] < nums[s] && nums[s] > nums[s + 1]) ? 1 : 0;
            }
            return;
        }
        int mid = s + (e - s) / 2;
        build(i * 2 + 1, s, mid);
        build(i * 2 + 2, mid + 1, e);
        seg[i] = seg[i * 2 + 1] + seg[i * 2 + 2];
    }

    public void update(int index, int value) {
        nums[index] = value;

        
        updateTree(0, 0, nums.length - 1, index);

        if (index > 0) {
            updateTree(0, 0, nums.length - 1, index - 1);
        }

        if (index < nums.length - 1) {
            updateTree(0, 0, nums.length - 1, index + 1);
        }
    }

    public void updateTree(int i, int left, int right, int index) {
        if (left == right) {
            if (left == 0 || right == nums.length - 1) {
                seg[i] = 0;
            } else {
                seg[i] = (nums[left - 1] < nums[left] && nums[left] > nums[left + 1]) ? 1 : 0;
            }
            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            updateTree(i * 2 + 1, left, mid, index);
        } else {
            updateTree(i * 2 + 2, mid + 1, right, index);
        }

        seg[i] = seg[i * 2 + 1] + seg[i * 2 + 2];
    }

    int query(int i, int l, int r, int s, int e) {
        
        if (r < s || e < l)
            return 0;

        
        if (l <= s && e <= r)
            return seg[i];

        
        int mid = s + (e - s) / 2;
        int left = query(2 * i + 1, l, r, s, mid);
        int right = query(2 * i + 2, l, r, mid + 1, e);
        return left + right;
    }
}

class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        SegmentTree st = new SegmentTree(nums.length, nums);
        List<Integer> ans = new ArrayList<>();

        for (int[] arr : queries) {
            if (arr[0] == 2) {
                st.update(arr[1], arr[2]);
            } else {
                int l = arr[1] + 1;
                int r = arr[2] - 1;
                if (l > r) {
                    ans.add(0);
                } else {
                    ans.add(st.query(0, l, r, 0, nums.length - 1));
                }
            }
        }
        return ans;
    }
}
