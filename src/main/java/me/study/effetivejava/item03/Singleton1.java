package me.study.effetivejava.item03;

//final 필드를 사용하여 singleton 구현하기
public class Singleton1 {

    public static final Singleton1 instance = new Singleton1();
    private Singleton1(){}

/*
리플렉션을 사용하면 생성자를 privated으로 해도 우회가능.
따라서 아래와 같이 생성자가 한번 이상 호출될 떄 Exception을 발생하게 장치해둘 수도 있으나 코드가 더러워짐
리플랙션 : 클래스, 메소드, 생성자 등을 변수로 사용하는 것 (더 찾아봐야 함)

ex)
Constructor<Singleton1> constructor = Singleton1.class.getConstructor();
constructor.setAccessible(true);
constructor.newInstance(..)

    int count;
    private Singleton1(){
        count++;
        if (count != 1) {
            throw new IllegalStateException("this object should be singleton");
        }
    }
    */

}
