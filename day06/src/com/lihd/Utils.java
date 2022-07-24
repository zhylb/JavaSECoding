package com.lihd;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/8 22:01
 */
public class Utils {
    private static final Unsafe unsafe;

    static {
        try {
            unsafe = getUnsafe();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalStateException("Unsafe获取失败！", e);
        }
    }

    private static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (Unsafe) field.get(null);
    }

    @SafeVarargs
    public static <T> String objectAddress(T... objects) {
        long offset = unsafe.arrayBaseOffset(objects.getClass());
        long factor = 8;
        final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
        return "0x" + Long.toHexString(i1);
    }
}
