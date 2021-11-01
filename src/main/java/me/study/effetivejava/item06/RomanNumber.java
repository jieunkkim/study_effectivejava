package me.study.effetivejava.item06;

import java.util.regex.Pattern;

public class RomanNumber {

    // String.matches 는 내부적으로 Pattern 객체를 만들어 사용. 무거운 객체
    static boolean isRomanNumeralBad(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    // 성능을 개선하려면 Pattern 객체를 만들어 재사용하는 것이 좋다
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeralGood(String s) {
        return ROMAN.matcher(s).matches();
    }
}
