package contest.CodeforcesRound806;

import java.io.*;
import java.util.*;

public class C1703 {
    InputStream is;
    FastWriter out;
    String INPUT = "";

    //提交时注意需要注释掉首行package
    //尽量用对象Arrays.sort(new Long[]{})
    //int 最大值2**31-1,2147483647;
    //尽量使用long类型,避免int计算的数据溢出
    //String尽量不要用+号来,可能会出现TLE,推荐用StringBuffer
    //注意对象类型Long,Integer相等使用equals代替== !!!
    void solve() {
        int t = ni();
        for (; t > 0; t--)
            go();
    }

    void go() {
        int n = ni();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ni();
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int b = ni();
            String s = ns();
            int cnt = 0;
            for (int j = 0; j < b; j++) {
                if (s.charAt(j) == 'D') {
                    cnt++;
                } else {
                    cnt--;
                }
            }
            ans[i] = (a[i] + cnt) % 10;
            if (ans[i] < 0) {
                ans[i] += 10;
            }
        }
        out.println(ans);
    }

    void run() throws Exception {
        is = System.in;
        out = new FastWriter(System.out);

        long s = System.currentTimeMillis();
        solve();
        out.flush();
        //debug log
        //tr(System.currentTimeMillis() - s + "ms");
    }

    public static void main(String[] args) throws Exception {
        new C1703().run();
    }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1)
            throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0)
                return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b))
            ;
        return b;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private Integer[] na(int n) {
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++)
            a[i] = ni();
        return a;
    }

    private Long[] nal(int n) {
        Long[] a = new Long[n];
        for (int i = 0; i < n; i++)
            a[i] = nl();
        return a;
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++)
            map[i] = ns(m);
        return map;
    }

    private Integer[][] nmi(int n, int m) {
        Integer[][] map = new Integer[n][];
        for (int i = 0; i < n; i++)
            map[i] = na(m);
        return map;
    }

    private int ni() {
        return (int) nl();
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    public static class FastWriter {
        private static final int BUF_SIZE = 1 << 13;
        private final byte[] buf = new byte[BUF_SIZE];
        private final OutputStream out;
        private int ptr = 0;

        private FastWriter() {
            out = null;
        }

        public FastWriter(OutputStream os) {
            this.out = os;
        }

        public FastWriter(String path) {
            try {
                this.out = new FileOutputStream(path);
            } catch (FileNotFoundException e) {
                throw new RuntimeException("FastWriter");
            }
        }

        public FastWriter write(byte b) {
            buf[ptr++] = b;
            if (ptr == BUF_SIZE)
                innerflush();
            return this;
        }

        public FastWriter write(char c) {
            return write((byte) c);
        }

        public FastWriter write(char[] s) {
            for (char c : s) {
                buf[ptr++] = (byte) c;
                if (ptr == BUF_SIZE)
                    innerflush();
            }
            return this;
        }

        public FastWriter write(String s) {
            s.chars().forEach(c -> {
                buf[ptr++] = (byte) c;
                if (ptr == BUF_SIZE)
                    innerflush();
            });
            return this;
        }

        private static int countDigits(int l) {
            if (l >= 1000000000)
                return 10;
            if (l >= 100000000)
                return 9;
            if (l >= 10000000)
                return 8;
            if (l >= 1000000)
                return 7;
            if (l >= 100000)
                return 6;
            if (l >= 10000)
                return 5;
            if (l >= 1000)
                return 4;
            if (l >= 100)
                return 3;
            if (l >= 10)
                return 2;
            return 1;
        }

        public FastWriter write(int x) {
            if (x == Integer.MIN_VALUE) {
                return write((long) x);
            }
            if (ptr + 12 >= BUF_SIZE)
                innerflush();
            if (x < 0) {
                write((byte) '-');
                x = -x;
            }
            int d = countDigits(x);
            for (int i = ptr + d - 1; i >= ptr; i--) {
                buf[i] = (byte) ('0' + x % 10);
                x /= 10;
            }
            ptr += d;
            return this;
        }

        private static int countDigits(long l) {
            if (l >= 1000000000000000000L)
                return 19;
            if (l >= 100000000000000000L)
                return 18;
            if (l >= 10000000000000000L)
                return 17;
            if (l >= 1000000000000000L)
                return 16;
            if (l >= 100000000000000L)
                return 15;
            if (l >= 10000000000000L)
                return 14;
            if (l >= 1000000000000L)
                return 13;
            if (l >= 100000000000L)
                return 12;
            if (l >= 10000000000L)
                return 11;
            if (l >= 1000000000L)
                return 10;
            if (l >= 100000000L)
                return 9;
            if (l >= 10000000L)
                return 8;
            if (l >= 1000000L)
                return 7;
            if (l >= 100000L)
                return 6;
            if (l >= 10000L)
                return 5;
            if (l >= 1000L)
                return 4;
            if (l >= 100L)
                return 3;
            if (l >= 10L)
                return 2;
            return 1;
        }

        public FastWriter write(long x) {
            if (x == Long.MIN_VALUE) {
                return write("" + x);
            }
            if (ptr + 21 >= BUF_SIZE)
                innerflush();
            if (x < 0) {
                write((byte) '-');
                x = -x;
            }
            int d = countDigits(x);
            for (int i = ptr + d - 1; i >= ptr; i--) {
                buf[i] = (byte) ('0' + x % 10);
                x /= 10;
            }
            ptr += d;
            return this;
        }

        public FastWriter write(double x, int precision) {
            if (x < 0) {
                write('-');
                x = -x;
            }
            x += Math.pow(10, -precision) / 2;
            //		if(x < 0){ x = 0; }
            write((long) x).write(".");
            x -= (long) x;
            for (int i = 0; i < precision; i++) {
                x *= 10;
                write((char) ('0' + (int) x));
                x -= (int) x;
            }
            return this;
        }

        public FastWriter writeln(char c) {
            return write(c).writeln();
        }

        public FastWriter writeln(int x) {
            return write(x).writeln();
        }

        public FastWriter writeln(long x) {
            return write(x).writeln();
        }

        public FastWriter writeln(double x, int precision) {
            return write(x, precision).writeln();
        }

        public FastWriter write(int... xs) {
            boolean first = true;
            for (int x : xs) {
                if (!first)
                    write(' ');
                first = false;
                write(x);
            }
            return this;
        }

        public FastWriter write(long... xs) {
            boolean first = true;
            for (long x : xs) {
                if (!first)
                    write(' ');
                first = false;
                write(x);
            }
            return this;
        }

        public FastWriter writeln() {
            return write((byte) '\n');
        }

        public FastWriter writeln(int... xs) {
            return write(xs).writeln();
        }

        public FastWriter writeln(long... xs) {
            return write(xs).writeln();
        }

        public FastWriter writeln(char[] line) {
            return write(line).writeln();
        }

        public FastWriter writeln(char[]... map) {
            for (char[] line : map)
                write(line).writeln();
            return this;
        }

        public FastWriter writeln(String s) {
            return write(s).writeln();
        }

        private void innerflush() {
            try {
                out.write(buf, 0, ptr);
                ptr = 0;
            } catch (IOException e) {
                throw new RuntimeException("innerflush");
            }
        }

        public void flush() {
            innerflush();
            try {
                out.flush();
            } catch (IOException e) {
                throw new RuntimeException("flush");
            }
        }

        public FastWriter print(byte b) {
            return write(b);
        }

        public FastWriter print(char c) {
            return write(c);
        }

        public FastWriter print(char[] s) {
            return write(s);
        }

        public FastWriter print(String s) {
            return write(s);
        }

        public FastWriter print(int x) {
            return write(x);
        }

        public FastWriter print(long x) {
            return write(x);
        }

        public FastWriter print(double x, int precision) {
            return write(x, precision);
        }

        public FastWriter println(char c) {
            return writeln(c);
        }

        public FastWriter println(int x) {
            return writeln(x);
        }

        public FastWriter println(long x) {
            return writeln(x);
        }

        public FastWriter println(double x, int precision) {
            return writeln(x, precision);
        }

        public FastWriter print(int... xs) {
            return write(xs);
        }

        public FastWriter print(long... xs) {
            return write(xs);
        }

        public FastWriter println(int... xs) {
            return writeln(xs);
        }

        public FastWriter println(long... xs) {
            return writeln(xs);
        }

        public FastWriter println(char[] line) {
            return writeln(line);
        }

        public FastWriter println(char[]... map) {
            return writeln(map);
        }

        public FastWriter println(String s) {
            return writeln(s);
        }

        public FastWriter println() {
            return writeln();
        }
    }

    public void trnz(int... o) {
        for (int i = 0; i < o.length; i++)
            if (o[i] != 0)
                System.out.print(i + ":" + o[i] + " ");
        System.out.println();
    }

    // print ids which are 1
    public void trt(long... o) {
        Queue<Integer> stands = new ArrayDeque<>();
        for (int i = 0; i < o.length; i++) {
            for (long x = o[i]; x != 0; x &= x - 1)
                stands.add(i << 6 | Long.numberOfTrailingZeros(x));
        }
        System.out.println(stands);
    }

    public void tf(boolean... r) {
        for (boolean x : r)
            System.out.print(x ? '#' : '.');
        System.out.println();
    }

    public void tf(boolean[]... b) {
        for (boolean[] r : b) {
            for (boolean x : r)
                System.out.print(x ? '#' : '.');
            System.out.println();
        }
        System.out.println();
    }

    public void tf(long[]... b) {
        if (INPUT.length() != 0) {
            for (long[] r : b) {
                for (long x : r) {
                    for (int i = 0; i < 64; i++) {
                        System.out.print(x << ~i < 0 ? '#' : '.');
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public void tf(long... b) {
        if (INPUT.length() != 0) {
            for (long x : b) {
                for (int i = 0; i < 64; i++) {
                    System.out.print(x << ~i < 0 ? '#' : '.');
                }
            }
            System.out.println();
        }
    }

    private void tr(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
}
