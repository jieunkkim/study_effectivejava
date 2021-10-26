package me.study.effetivejava.item03;

// static 팩토리 메소드를 사용하여 싱글톤 구현하기
public class Singleton2 {

    // Singleton1 에선 final 변수가 public이었으나 여기선 private
    private static final Singleton2 instance = new Singleton2();

    private Singleton2(){}

    // final 변수를 직접 가져가지 않고 static 메소드를 호출하여 생성된 인스턴스를 불러옴
    public static Singleton2 getInstance() {
        return instance;
        // 만약 추후 싱글톤에서 스레드별 인스턴스를 새로 호출하도록 방식이 바뀐다면 클라이언트 수정없이 이 메소드만 수정해주면 된다 (ex. return new Singleton2();)
    }

}
