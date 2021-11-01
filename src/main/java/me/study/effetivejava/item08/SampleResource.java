package me.study.effetivejava.item08;

public class SampleResource implements AutoCloseable{

    // 자원 반납을 위한 메소드 (AutoCloseable 을 상속받아 close 내 반납 구현을 하고, main에서 객체 사용 이후 close 호출)
    @Override
    public void close() throws RuntimeException{
        System.out.println("close");
    }

    public void hello(){
        System.out.println("resource hello");
    }
}

