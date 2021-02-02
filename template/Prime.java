import java.util.*;

public class Prime {

    /**
     * 获取数字n的所有质因数的map
     * 
     * @param n
     */
    Map<Long, Integer> getPrimeFactor(long n) {
        long i = 2;
        long num = n;
        Map<Long, Integer> map = new HashMap<>();
        while (i * i <= num) {
            while (num % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                num = num / i;
            }
            i++;
        }
        if (num != 1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    /**
     * 获取n阶乘的质因数k的个数(迭代)
     * 
     * @param n
     * @param k
     */
    void getCountOfFactorN(long n, int k) {
        long num = n;
        long count = 0;
        while (num >= k) {
            count += (num / k);
            num = num / k;
        }
        System.out.printf("%d阶乘的质因数%d的个数:%d", n, k, count);
        System.out.println();
    }

    /**
     * 获取n阶乘的质因数k的个数(递归)
     * 
     * @param n
     * @param k
     * @return
     */
    public long recurseGetCountOfFactorN(long n, int k) {
        if (n == 0)
            return 0;
        return n / k + recurseGetCountOfFactorN(n / k, k);
    }

    void Eratosthenes(int n) {
        int count = 0;
        int[] is_prime = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            is_prime[i] = 1;
        }
        is_prime[0] = is_prime[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (is_prime[i] == 1) {

            }
        }
    }

    /**
     * 求<=n的素数集合,朴素暴力写法
     * 
     * @param n
     * @return
     */
    List<Integer> getPrime(long n) {
        List<Integer> prime = new ArrayList<>();
        for (int j = 2; j < n + 1; j++) {
            if (isPrime(j)) {
                prime.add(j);
            }
        }
        return prime;
    }

    // check prime
    boolean isPrime(int x) {
        int m = (int) Math.sqrt(x) + 1;
        for (int i = 2; i < m; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Prime prime = new Prime();

        // 获取数字n的所有质因数的map
        long m = 725760000000000000l;
        Map<Long, Integer> map = prime.getPrimeFactor(m);
        System.out.println(m + "的质因数字典:" + map);

        // 求数n阶乘的质因数k的个数
        long n = 20;
        int k = 2;
        prime.getCountOfFactorN(n, k);
        long count = prime.recurseGetCountOfFactorN(n, k);
        System.out.println(n + "阶乘的质因数" + k + "的个数:" + count);
        //质数埃拉托斯特尼筛法

    }
}
