package me.study.effetivejava.item05;

import java.util.List;

// 부적절한 구현 1. static 유틸 클래스 (item04)
// 모두 static으로 구현되어 있고, 생성자는 private 으로 설정
// KoreanDictionary는 static final 변수 통해 하나의 인스턴스로 생성됨
public class BadSpellChecker1 {

    // 문제. 유연성이 부족하다 만약 다른 언어 Dictionary가 추가되어야 하므로 이 부분 수정이 불가피
    private static final Lexicon dictionary = new KoreanDictionary();

    private BadSpellChecker1() {
        // Noninstantiable
    }

    public static boolean isValid(String word) {
        throw new UnsupportedOperationException();
    }


    public static List<String> suggestions(String typo) {
        throw new UnsupportedOperationException();
    }
}

interface Lexicon {}

class KoreanDictionary implements Lexicon {}
