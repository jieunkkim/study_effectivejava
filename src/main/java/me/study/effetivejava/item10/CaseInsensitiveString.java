package me.study.effetivejava.item10;

import java.util.Objects;

/**
 * 대칭성 위배 Case
 * 대칭성(symmetry)
 * null 이 아닌 모든 참조 값 x, y에 대해 x.equals(y)가 true 면, x.equals(x)도 true 여야 한다.
 */
public class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // 나쁜 예
    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        }

        if (o instanceof String) {
            return s.equalsIgnoreCase((String) o);
        }
        return false;
    }

    // 개선된 예
/*
    @Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString &&
                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }
*/

    public static void main(String[] args) {
        CaseInsensitiveString cts = new CaseInsensitiveString("Polish");
        String s = "polish";

        // CaseInsensitiveString 에서 equals 를 구현했다고 해서 String 의 equals 와 연동된다는 허황된 생각은 버릴 것
        System.out.println(cts.equals(s));      // true (CaseInsensitiveString 의 equals 는 소대문자 구분 무시)
        System.out.println(s.equals(cts.s));    // false (String 의 equals 는 소대문자 구분)

    }
}
