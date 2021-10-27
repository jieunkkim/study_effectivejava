package me.study.effetivejava.item05;

import java.util.List;

// 부적절한 구현 2. 싱글톤으로 구현하기
public class BadSpellChecker2 {

    // 문제. 유연성이 부족하다 만약 다른 언어 Dictionary가 추가되어야 하므로 이 부분 수정이 불가피
    private final Lexicon dictionary = new KoreanDictionary();

    private BadSpellChecker2() {
    }

    public static final BadSpellChecker2 INSTANCE = new BadSpellChecker2() {
    };

    public boolean isValid(String word) {
        throw new UnsupportedOperationException();
    }


    public List<String> suggestions(String typo) {
        throw new UnsupportedOperationException();
    }
}
