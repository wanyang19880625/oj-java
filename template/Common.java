import java.io.*;
import java.util.*;

public class Common {

    /**
     * a,b最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * a,b最大公约数
     * @param a
     * @param b
     * @return
     */
    int gcd(int a,int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * 快速幂求(a^count)%power
     *
     * @param a
     * @param count
     * @param power
     * @return
     */
    long quickpower(long a, long count, long power) {
        long result = 1;
        while (count != 0) {
            if ((count & 1) == 1) {
                result = (result * a) % power;
            }
            a = (a * a) % power;
            count = count >> 1;
        }
        return result;
    }

    /**
     * 求逆元
     *
     * @param a
     * @param power
     * @return
     */
    long inverse(long a, long power) {
        return quickpower(a, power - 2, power);
    }

    public static void main(String[] args) {
        Common common = new Common();

        // 最大公约数
        System.out.println("最大公约数:" + common.gcd(12, 8));

        long mod = 998244353;
        int a = 3;
        //求逆元
        System.out.println(a + "取逆元:" + 1 * common.quickpower(a, mod - 2, mod) % mod);

        //组合数
        int n = 11;
        long[] fact = new long[n], infact = new long[n];
        Arrays.fill(fact, 1);
        Arrays.fill(infact, 1);
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i % mod;
            infact[i] = infact[i - 1] * common.quickpower(i, mod - 2, mod) % mod;
        }
        int x = 4, y = 2;
        System.out.println(
            "组合数C(" + x + "," + y + "):" + fact[x] * infact[y] % mod * infact[x - y] % mod);
    }
}
