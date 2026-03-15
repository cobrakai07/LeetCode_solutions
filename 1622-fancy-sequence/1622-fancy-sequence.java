class SegmentTree {
    int[] seg;
    int[] addSeg;
    int[] mulSeg;
    int mod = 1000000007;

    public SegmentTree(int n) {
        seg = new int[4 * n];
        addSeg = new int[4 * n];
        mulSeg = new int[4 * n];

        for (int i = 0; i < 4 * n; i++) {
            mulSeg[i] = 1;
        }
    }

    void push(int i, int l, int r) {
        if (l == r) return;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        seg[left] = (int)(((long)seg[left] * mulSeg[i] + addSeg[i]) % mod);
        seg[right] = (int)(((long)seg[right] * mulSeg[i] + addSeg[i]) % mod);

        mulSeg[left] = (int)((long)mulSeg[left] * mulSeg[i] % mod);
        mulSeg[right] = (int)((long)mulSeg[right] * mulSeg[i] % mod);

        addSeg[left] = (int)(((long)addSeg[left] * mulSeg[i] + addSeg[i]) % mod);
        addSeg[right] = (int)(((long)addSeg[right] * mulSeg[i] + addSeg[i]) % mod);

        mulSeg[i] = 1;
        addSeg[i] = 0;
    }

    public int getVal(int i, int l, int r, int idx) {
        if (l == r) return seg[i];

        push(i, l, r);

        int mid = l + (r - l) / 2;

        if (idx > mid) {
            return getVal(2 * i + 2, mid + 1, r, idx);
        } else {
            return getVal(2 * i + 1, l, mid, idx);
        }
    }

    public void updatePoint(int i, int l, int r, int idx, int val) {
        if (l == r) {
            seg[i] = val % mod;
            return;
        }

        push(i, l, r);

        int mid = l + (r - l) / 2;

        if (idx > mid) {
            updatePoint(2 * i + 2, mid + 1, r, idx, val);
        } else {
            updatePoint(2 * i + 1, l, mid, idx, val);
        }

        seg[i] = (seg[2 * i + 1] + seg[2 * i + 2]) % mod;
    }

    public void rangeUpdate(int i, int l, int r, int x, int y, int val, boolean addOperation) {

        if (r < x || l > y) return;

        if (l >= x && r <= y) {
            if (addOperation) {

                seg[i] = (seg[i] + val) % mod;
                addSeg[i] = (addSeg[i] + val) % mod;

            } else {

                seg[i] = (int)((long)seg[i] * val % mod);
                mulSeg[i] = (int)((long)mulSeg[i] * val % mod);
                addSeg[i] = (int)((long)addSeg[i] * val % mod);
            }
            return;
        }

        push(i, l, r);

        int mid = l + (r - l) / 2;

        rangeUpdate(2 * i + 1, l, mid, x, y, val, addOperation);
        rangeUpdate(2 * i + 2, mid + 1, r, x, y, val, addOperation);

        // seg[i] = (seg[2 * i + 1] + seg[2 * i + 2]) % mod;
    }
}

class Fancy {

    SegmentTree st;
    int size = 0;
    int limit = 100000;

    public Fancy() {
        st = new SegmentTree(limit);
    }

    public void append(int val) {
        st.updatePoint(0, 0, limit - 1, size, val);
        size++;
    }

    public void addAll(int inc) {
        if (size == 0) return;
        st.rangeUpdate(0, 0, limit - 1, 0, size - 1, inc, true);
    }

    public void multAll(int m) {
        if (size == 0) return;
        st.rangeUpdate(0, 0, limit - 1, 0, size - 1, m, false);
    }

    public int getIndex(int idx) {
        if (idx >= size) return -1;
        return st.getVal(0, 0, limit - 1, idx) % 1000000007;
    }
}