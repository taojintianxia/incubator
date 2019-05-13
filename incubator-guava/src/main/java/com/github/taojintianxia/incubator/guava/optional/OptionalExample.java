package com.github.taojintianxia.incubator.guava.optional;

import com.google.common.base.Optional;

/**
 * @author Nianjun Sun
 * @date 2019-05-13 10:17
 */
public class OptionalExample {

    public static Optional<String> getNoneNull() {
        Optional optionalStr = Optional.of(new String("optional test"));
        return optionalStr;
    }

    public static void main(String... args) {
        // 1. 这样的代码不需要NPE 检测，一定不会返回 null
        Optional noneNullOptionalStr = getNoneNull();
        System.out.println(noneNullOptionalStr.get());
    }
}
