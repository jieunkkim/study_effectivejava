package me.study.effetivejava.item08;

public class FinalizerExample {

    // finalize 는 GC 수행 시 실행되는데 언제 실행될지 정확한 시점을 예측할 수 없음.
    // GC의 대상이 될 뿐, GC 시점은 파악할 수 없으므로..
    // 특히 finalize 의 우선 순위도 낮음
    @Override
    protected void finalize() throws Throwable {    // Java 9에서 deprecated 됨
        System.out.println("Clean up");
    }

    public void hello() {
        System.out.println("hello");
    }
}
