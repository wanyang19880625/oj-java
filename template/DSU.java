import java.io.*;
import java.util.*;

public class DSU {

    public static void main(String[] args) {
        int n = 5;
        DSU dsu = new DSU(n);

        //before union
        System.out.print("初始化");
        dsu.printFather();
        System.out.print("初始化");
        dsu.printSize();
        int[][] pairs = new int[][]{
                new int[]{1, 0},
                new int[]{0, 2},
                new int[]{1, 2},
                new int[]{3, 1},
                new int[]{4, 3}
        };

        //union
        for (int[] p : pairs) {
            dsu.union(p[0], p[1]);
        }

        //after union
        System.out.print("合并之后");
        dsu.printFather();
        System.out.print("合并之后");
        dsu.printSize();
    }

    private int n;

    private int[] father;

    // 集合块大小
    private int[] size;

    /**
     * 构造器初始化
     *
     * @param n
     */
    public DSU(int n) {
        this.n = n;
        this.father = new int[n];
        for (int i = 0; i < n; i++) {
            this.father[i] = i;
        }

        this.size = new int[n];
        Arrays.fill(size, 1);
    }

    /**
     * 递归查找父亲元素
     *
     * @param x
     * @return
     */
    public int find(int x) {
        if (x != father[x]) {
            father[x] = find(father[x]);
        }
        return father[x];
    }

    /**
     * 判断两个元素是否属于同一个连通块
     *
     * @param x
     * @param y
     * @return
     */
    public boolean same(int x, int y) {
        return find(x) == find(y);
    }

    /**
     * 并查集合并
     *
     * @param x
     * @param y
     * @return
     */
    public boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return false;
        }
        size[x] += size[y];
        father[y] = x;
        return true;
    }

    /**
     * 并查集元素x所属的连通块集合大小
     *
     * @param x
     * @return
     */
    public int size(int x) {
        return size[find(x)];
    }

    public void printSize() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(size(i));
            sb.append(" ");
        }
        System.out.println("size: "+sb.substring(0, sb.length() - 1));
    }

    public void printFather() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(find(i));
            sb.append(" ");
        }
        System.out.println("father:  "+sb.substring(0, sb.length() - 1));
    }

    //todo 打印所有的连通块
}
