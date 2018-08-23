package com.leetcode.util;

import java.util.concurrent.ThreadLocalRandom;

public class Util {
    public static long time() {
        return System.currentTimeMillis();
    }

    public static int randomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
