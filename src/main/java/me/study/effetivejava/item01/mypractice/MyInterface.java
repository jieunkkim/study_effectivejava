package me.study.effetivejava.item01.mypractice;

public interface MyInterface {
    public String getName();

    public static MyInterface get(){
        return new MyClass();
    }

    public static MyInterface getNew(){
        return new MyNewClass();
    }
}
