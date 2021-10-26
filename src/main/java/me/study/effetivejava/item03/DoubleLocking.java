package me.study.effetivejava.item03;

public class DoubleLocking {
    private static volatile DoubleLocking instance = null;
    // volatile : volatile keyword는 Java 변수를 Cache가 아닌 Main Memory에 저장하겠다라는 것을 명시하는 것입니다.
    // 상세 내용 출처 : https://nesoy.github.io/articles/2018-06/Java-volatile

    private DoubleLocking() {
    };

    public static DoubleLocking getInstance() {
        if (instance == null) {

            // synchronized : 함수에 synchronized를 걸면 그 함수가 포함된 해당 객체(this)에 lock을 거는것과 같습니다.
            //출처: https://tourspace.tistory.com/54 [투덜이의 리얼 블로그]
            synchronized (DoubleLocking.class) {
                if (instance == null) {             // 멀티쓰레드 환경에서 위 조건절을 우회하여 인스턴스가 더 생길 수 있음. 따라서 이와 같이 double locking을 해줌
                    instance = new DoubleLocking();
                }
            }
        }
        return instance;
    }

}
