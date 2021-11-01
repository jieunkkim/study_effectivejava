package me.study.effetivejava.item08;

public class SampleRunner {
    public static void main(String[] args) throws InterruptedException {
        SampleRunner sampleRunner = new SampleRunner();
        sampleRunner.run();
        Thread.sleep(1000l);

        // scope 이 종료되어 sampleRunner 가 gc 대상이 되어도, finalize 가 언제 실행될지 (gc가 언제 처리될지) 알지 못한다
        //System.gc(); // 이거 한다고 GC 되는건 아니지만 테스트해서 될 수도 있음.

        // AutoCloseable 활용 예
        SampleResource sampleResource = new SampleResource();
        sampleResource.hello();
        sampleResource.close();

        // try-finally 활용 예
        SampleResource sampleResource1 = null;
        try{
            sampleResource1 = new SampleResource();
            sampleResource1.hello();
        } finally {
            if(sampleResource1 != null) sampleResource1.close();
        }

        // try-with-resource 활용 예
        // 명시적으로 close 를 호출하지 않아도 자동으로 close() 호출해줌
        try(SampleResource sampleResource2 = new SampleResource()){
            sampleResource2.hello();
        }
    }
    public void run(){
        FinalizerExample finalizerExample = new FinalizerExample();
        finalizerExample.hello();
    }
}
