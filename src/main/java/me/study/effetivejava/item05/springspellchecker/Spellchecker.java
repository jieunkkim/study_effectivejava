package me.study.effetivejava.item05.springspellchecker;

import org.springframework.stereotype.Component;

@Component
public class Spellchecker {

    private Lexicon lexicon;

    public Spellchecker(Lexicon lexicon) {
        this.lexicon = lexicon;
    }

    public boolean isValid(String word){
        lexicon.print();
        return true;
    }
}
