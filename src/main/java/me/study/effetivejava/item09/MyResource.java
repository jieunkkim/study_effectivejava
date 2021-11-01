package me.study.effetivejava.item09;

public class MyResource implements AutoCloseable {

    public void doSomething(){
        System.out.println("Do Something");
        throw new FirstError();
    }

    @Override
    public void close() {
        System.out.println("Close My Resource");
        throw new SecondError();
    }
}
