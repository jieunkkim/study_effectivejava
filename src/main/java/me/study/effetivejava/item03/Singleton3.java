package me.study.effetivejava.item03;

// ENUM 사용하여 싱글톤 구현 (enum은 필드와 메소드를 다 가질 수 있고, INSTANCE 는 하나만 존재할 수 있기 때문에..)
// 다만 상속이 불가하고.. 너무 이상적
public enum Singleton3 {
    INSTANCE;

    public String getName() {
        return "jieun";
    }
}
