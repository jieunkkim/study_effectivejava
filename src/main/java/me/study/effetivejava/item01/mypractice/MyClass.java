package me.study.effetivejava.item01.mypractice;

public class MyClass implements MyInterface{
    public static MyClass createMyClass(){
        return new MyClass();
    }

    @Override
    public String getName() {
        return "I'm myClass";
    }
}
