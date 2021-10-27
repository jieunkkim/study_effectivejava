package me.study.effetivejava.item05.springspellchecker;

import org.springframework.stereotype.Component;

@Component
public class KoreanDictionary implements Lexicon{

    @Override
    public void print() {
        System.out.println("KoreanDictionary");
    }
}
