package me.study.effetivejava.item05.springspellchecker;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpellCheckerClient {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        Spellchecker spellchecker = applicationContext.getBean(Spellchecker.class);
        spellchecker.isValid("hello");
    }
}
