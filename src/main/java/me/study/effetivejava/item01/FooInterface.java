package me.study.effetivejava.item01;

public interface FooInterface {

    // 자바 8 부턴 Interface 에 public static 구현체 가능
    public static Foo getFoo(){
        return new Foo();
    }
}
