import java.io.*;
import java.util.*;

public class BinarySearch {

    public static void main(String[] args) {
        Integer[] a = new Integer[] { 0, 1, 1, 1, 1, 1, 1, 2, 3, 7, 7 };
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.lowbound(0, a.length, 1, a));
        System.out.println(binarySearch.upperbound(0, a.length, 1, a));
    }

    /**
     * left=0,right=n
     * python:bisect.bisect_left()
     * 查询符合>=value值的最小个数
     * 
     * @param left
     * @param right
     * @param value
     * @param a
     * @return
     */
    public int lowbound(int left, int right, int value, Integer[] a) {
        // lowbound
        while (left < right) {
            int mid = (right + left) / 2;
            if (a[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * left=0,right=n
     * python:bisect.bisect_right()
     * 查询符合<=value值的个数
     * @param left
     * @param right
     * @param value
     * @param a
     * @return
     */
    public int upperbound(int left, int right, int value, Integer[] a) {
        // upperbound
        while (left < right) {
            int mid = (right + left) / 2;
            if (a[mid] > value) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
