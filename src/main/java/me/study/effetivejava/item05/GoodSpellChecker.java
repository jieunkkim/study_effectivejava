package me.study.effetivejava.item05;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

// 적절한 구현. 의존성 주입을 사용
// 어떤 클래스가 사용하는 리소스(여기선 dictionary)에 따라 행동을 달리해야 하는 경우에는
// 새 인스턴스를 생성할 때 사용할 리소스를 넘겨주는 방법이 좋다.
public class GoodSpellChecker {

    private final Lexicon dictionary;

    // 인스턴스 생성과 의존성 주입
    public GoodSpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    // Supplier 를 사용하여 의존성 주입 (위 코드를 Supplier만 추가하여 적용)
    public GoodSpellChecker(Supplier<Lexicon> dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary.get());
    }

    public boolean isValid(String word) {
        throw new UnsupportedOperationException();
    }

    public List<String> suggestions(String typo) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        Lexicon lexicon = new KoreanDictionary();
        GoodSpellChecker goodSpellChecker = new GoodSpellChecker(lexicon);
        goodSpellChecker.isValid("hello");

        Lexicon lexicon2 = new TestDictionary();
        GoodSpellChecker goodSpellChecker2 = new GoodSpellChecker(lexicon);
        goodSpellChecker.isValid("hello");

        // Supplier 를 통해 의존성을 주입할 경우
        Lexicon lexicon3 = new TestDictionary();
        GoodSpellChecker goodSpellChecker3 = new GoodSpellChecker(new Supplier<Lexicon>() {
            @Override
            public Lexicon get() {
                return lexicon3;
            }
        });
        // 아래는 위 supplier 람다 적용 시
        GoodSpellChecker goodSpellChecker4 = new GoodSpellChecker(() -> lexicon);


    }

}

class TestDictionary implements Lexicon {}