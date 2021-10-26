package me.study.effetivejava.item04;

import jdk.jshell.execution.Util;

public abstract class UtilClass {

    // 주석 ) UtilClass 이므로 생성자 사용 불가 (인스턴스 생성 불가)
    private UtilClass(){
        throw new AssertionError();
    }

    public static String getName(){
        return "jieun";
    }

    public static class AnotherUtilClass extends UtilClass{

    }

    public static void main(String[] args) {
        // static 으로만 구성된 Class(주로 Util용)들은 인스턴스를 만들필요 없다.
        UtilClass.getName();

        // 아래와 같은 인스턴스 생성이 필요없음
        UtilClass utilClass = new UtilClass();

        // class 앞에 abstract를 붙이면 일차적으로 막을 순 있지만 (개발자들이 주로 사용)
        // 만약 다른 static 클래스를 생성하여 위 클래스를 상속 받으면 새로 만든 클래스를 통해 기존 클래스 인스턴스 생성이 가능해진다.
        // (다만, 만든 인스턴스로 static 메소드 사용은 안됨. ex. newUtilClass.getName();)
        AnotherUtilClass anotherUtilClass = new AnotherUtilClass();
        anotherUtilClass.getName();

        // 권장하는 방법은 생성자를 private 으로 명시하는 것이다. 다만 생성자가 private 이라는 것이 직관적이지 않은 방식이기 때문에
        // 주석, AssertionError 등을 통해 다른 개발자가 의도를 파악하도록 남겨둔다.


    }
}
