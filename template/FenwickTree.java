import java.io.*;
import java.util.*;

public class FenwickTree {

    private int n;

    private int[] a;

    public FenwickTree(int n) {
        this.a = new int[n];
        this.n = n;
    }

    void add(int x, int v) {
        for (int i = x + 1; i <= n; i += i & -i) {
            a[i - 1] += v;
        }
    }

    // <=x的数量
    int sum(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= i & -i) {
            ans += a[i - 1];
        }
        return ans;
    }

    int rangeSum(int l, int r) {
        return sum(r) - sum(l);
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 1, 7};
        // 离散化数组,按照数值大小将实际坐标进行排序
//        Integer[][] b = new Integer[a.length][2];
//        int[] pos = new int[a.length];
//        for (int i = 0; i < a.length; i++) {
//            b[i] = new Integer[]{a[i], i + 1};
//        }
//        Arrays.sort(b, (o1, o2) -> o2[0] - o1[0]);
//        for (int i = 0; i < a.length; i++) {
//            pos[i] = b[i][1];
//        }
        // [4]3 [3,5]2 [2,6]1 [1,7]0
        FenwickTree fenwickTree = new FenwickTree(20);
        int ans = 0;
        int n = a.length;
        for (int i = 1; i <= n; i++) {
            fenwickTree.add(a[i - 1], 1);
            int sum = fenwickTree.sum(a[i - 1] + 1);
            System.out.println(a[i - 1] + "," + (sum - 1));
            ans += sum - 1;
        }
        System.out.println(ans);
    }
}

