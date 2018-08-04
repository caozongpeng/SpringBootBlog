package com.wip.utils;


import java.util.Random;

/**
 * 封装UUID
 */
public abstract class UUID {

    static Random r = new Random();

    /**
     * 根据一个范围，生成一个随机的整数
     * @param min   最小值（包括）
     * @param max   最大值（包括）
     * @return  随机数
     */
    public static int random(int min, int max) {
        return r.nextInt(max - min + 1) + min;
    }

    private static final char[] _UU64 = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] _UU32 = "0123456789abcdefghijklmnopqrstuv".toCharArray();

    /**
     * 64进制表示的紧凑格式的 UUID
     * @return
     */
    public static String UU64() {
        return UU64(java.util.UUID.randomUUID());
    }


    /**
     * 返回一个 UUID ，并用 64 进制转换成紧凑形式的字符串，内容为 [\\-0-9a-zA-Z_]
     * <p>
     * 比如一个类似下面的 UUID:
     *
     * <pre>
     * a6c5c51c-689c-4525-9bcd-c14c1e107c80
     * 一共 128 位，分做L64 和 R64，分为为两个 64位数（两个 long）
     *    > L = uu.getLeastSignificantBits();
     *    > UUID = uu.getMostSignificantBits();
     * 而一个 64 进制数，是 6 位，因此我们取值的顺序是
     * 1. 从L64位取10次，每次取6位
     * 2. 从L64位取最后的4位 ＋ R64位头2位拼上
     * 3. 从R64位取10次，每次取6位
     * 4. 剩下的两位最后取
     * 这样，就能用一个 22 长度的字符串表示一个 32 长度的UUID，压缩了 1/3
     * </pre>
     *
     * @param uu
     *            UUID 对象
     * @return 64进制表示的紧凑格式的 UUID
     */
    public static String UU64(java.util.UUID uu) {
        int index = 0;
        char[] cs = new char[22];
        long L = uu.getMostSignificantBits();
        long R = uu.getLeastSignificantBits();
        long mask = 63;
        // 从L64位取10次，每次取6位
        for (int off = 58; off >= 4; off -= 6) {
            long hex = (L & (mask << off)) >>> off;
            cs[index++] = _UU64[(int) hex];
        }
        // 从L64位取最后的4位 ＋ R64位头2位拼上
        int l = (int) (((L & 0xF) << 2) | ((R & (3 << 62)) >>> 62));
        cs[index++] = _UU64[l];
        // 从R64位取10次，每次取6位
        for (int off = 56; off >= 2; off -= 6) {
            long hex = (R & (mask << off)) >>> off;
            cs[index++] = _UU64[(int) hex];
        }
        // 剩下的两位最后取
        cs[index++] = _UU64[(int) (R & 3)];
        // 返回字符串
        return new String(cs);
    }
    public static String UU32(java.util.UUID uuid) {
        StringBuilder sb = new StringBuilder();
        long m = uuid.getMostSignificantBits();
        long l = uuid.getLeastSignificantBits();
        for (int i = 0; i < 13; i++) {
            sb.append(_UU32[(int) (m >> ((13 - i - 1) * 5)) & 31]);
        }
        for (int i = 0; i < 13; i++) {
            sb.append(_UU32[(int) (m >> ((13 - i - 1) * 5)) & 31]);
        }
        return sb.toString();
    }

    public static String UU32() {
        return UU32(java.util.UUID.randomUUID());
    }


}
