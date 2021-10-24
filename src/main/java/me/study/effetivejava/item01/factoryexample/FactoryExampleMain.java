package me.study.effetivejava.item01.factoryexample;

/**
 * 번외 Factory-method 디자인 패턴
 * 출처 : https://www.youtube.com/watch?v=q3_WXP9pPUQ
 */
public class FactoryExampleMain {
    public static void main(String[] args) {
        new ComponentConsole().withoutFactory();
        new ComponentConsole().withFactory();
    }
}
