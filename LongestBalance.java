class SegmentTree {
    public int n;
    public int size;
    public int[] sum;
    public int[] mn;
    public int[] mx;

    SegmentTree(int n_) {
        n = n_;
        size = 4 * n_;
        sum = new int[size];
        mn  = new int[size];
        mx  = new int[size];
    }

    void _pull(int node) {
        int l = node * 2, r = node * 2 + 1;

        sum[node] = sum[l] + sum[r];
        mn[node] = Math.min(mn[l], sum[l] + mn[r]);
        mx[node] = Math.max(mx[l], sum[l] + mx[r]);
    }

    void update(int idx, int val) {
        int node = 1, l = 0, r = n - 1;
        int[] path = new int[32]; 
        int ps = 0;

        while (l != r) {
            path[ps++] = node;
            int m = l + (r - l) / 2;
            if (idx <= m) {
                node = node * 2;
                r = m;
            } else {
                node = node * 2 + 1;
                l = m + 1;
            }
        }

        sum[node] = val;
        mn[node] = val;
        mx[node] = val;

        while (ps > 0) {
            _pull(path[--ps]);
        }
    }

    int find_rightmost_prefix(int target) {
        int node = 1, l = 0, r = n - 1, sum_before = 0;

        if (!(mn[node] <= target - sum_before && target - sum_before <= mx[node]))
            return -1;

        while (l != r) {
            int m = l + (r - l) / 2;
            int lchild = node * 2, rchild = node * 2 + 1;

            int sum_before_right = sum[lchild] + sum_before;
            int need_right = target - sum_before_right;

            if (mn[rchild] <= need_right && need_right <= mx[rchild]) {
                node = rchild;
                l = m + 1;
                sum_before = sum_before_right;
            } else {
                node = lchild;
                r = m;
            }
        }

        return l;
    }
}
class LongestBalance {
    public int longestBalanced(int[] nums) {
        int n = nums.length;

        SegmentTree stree = new SegmentTree(n);
        HashMap<Integer, Integer> first = new HashMap<>();

        int result = 0;

        for (int l = n - 1; l >= 0; --l) {
            int num = nums[l];

            Integer old = first.get(num);
            if (old != null)
                stree.update(old, 0);

            first.put(num, l);
            stree.update(l, (num % 2 == 0) ? 1 : -1);

            int r = stree.find_rightmost_prefix(0);

            if (r >= l)
                result = Math.max(result, r - l + 1);
        }

        return result;
    }
}
