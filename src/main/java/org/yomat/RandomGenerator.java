package org.yomat;

import java.util.Random;

/**
 * Created by hb on 25/05/2016.
 */
public class RandomGenerator {

    static Random r = new Random();

    public static long nextLong(Random rng, long n) {
        // TODO error checking and 2^x checking removed for simplicity.
        long bits, val;
        do {
            bits = (rng.nextLong() << 1) >>> 1;
            val = bits % n;
        } while (bits-val+(n-1) < 0L);
        return val;
    }

    public static long nextLong(long n) {
        // TODO error checking and 2^x checking removed for simplicity.
        long bits, val;
        do {
            bits = (r.nextLong() << 1) >>> 1;
            val = bits % n;
        } while (bits-val+(n-1) < 0L);
        return val;
    }

}

