package me.study.effetivejava.item01;

import java.util.EnumSet;

import static me.study.effetivejava.item01.Foo.Color.RED;
import static me.study.effetivejava.item01.Foo.Color.WHITE;


public class Foo {

    private String name;
    private String address;
    private static final Foo STATIC_FOO = new Foo();

    // 일반 생성자
    public Foo(){}
    public Foo(String name) {
        this.name = name;
    }
    /* 아래와 같은 생성자는 만들지 못한다 위에 동일한 시그니처를 가진 생성자가 있기 때문에
    public Foo(String address) {
        this.address = address;
    }*/


    // static Factory
    public static Foo withName(String name) {
        return new Foo(name);
    }
    public static Foo withAddress(String address) { // 장점1. Foo(String address) 를 만들지 못한다면 static method로 역할 대신 가능
        Foo foo = new Foo();
        foo.address = address;
        return foo;
    }

    public static Foo getStaticFoo() { // 장점2. 미리 새로운 객체를 생성하지 않고, 만들어둔 인스턴스를 리턴할 수 있음.
        return STATIC_FOO;
    }

    public static Foo getFoo(boolean flag){
        return flag ? new Foo() : new BarFoo();
    }

    // 장점5. 리턴하는 객체는 static 메소드 작성시점과 무관하게 계속 바뀔 수 있다. FQCN 을 바꾸면서
    // JDBC를 예로 든 이유. JDBC 에서 getConnection 으로 나오는 Connection 객체는 DB 마다 다름
    public static Foo getRemoteFoo(){
        Foo foo = new Foo();
        // TODO 특정 텍스트파일에서 Foo 의 구현체 FQCN 을 읽어온다 (FQCN : Full Qualified Class Name 클래스가 속한 패키지명을 모두 포함한 이름)
        // TODO FQCN 에 해당하는 인스턴스를 생성한다
        // TODO foo 변수를 해당 인스턴스를 가르키도록 수정한다 (ex. foo = 위 내용에서 언급한 Class)
        return foo;
    }
    public static void main(String[] args){

        // 장점1. 일반 생성자로 Foo 를 생성하는 것보다, 잘 명명된 static method 를 활용해 생성하는 것이 훨씬 직관적
        Foo foo = new Foo("jieun");
        Foo fooFactory = Foo.withName("jieun");

        // 장점2. 매번 새로운 객체를 생성하지 않고, 만들어둔 인스턴스를 계속 재활용할 수 있음.
        Foo fooStatic1 = Foo.getStaticFoo();
        Foo fooStatic2 = Foo.getStaticFoo();
        System.out.println(fooStatic1 + " / " + fooStatic2); // 동일 값을 리턴

        // 장점3, 4. 리턴하는 객체가 꼭 Foo 가 아니어도 된다. 매개변수에 따르던 그냥이던 상황따라 Foo 의 하위타입 리턴이 가능하다.
        Foo fooTrue = Foo.getFoo(true);
        Foo fooFalse = Foo.getFoo(false);
        System.out.println(fooTrue + " / " + fooFalse); // 두 객체는 Foo 로 생성되었지만 매개변수에 따라 생성된 구현체가 다르다
        EnumSet<Color> colors = EnumSet.allOf(Color.class);
        EnumSet<Color> redAndwhite = EnumSet.of(RED,WHITE);

    }

    static class BarFoo extends Foo{
        public BarFoo(){}
    }

    enum Color {
        RED, BLUE, WHITE
    }

    // 번외. private static method가 필요한 이유.
    // private - public 내부에서만 실행되는 method 굳이 외부 노출시킬 필요 없음
    // static - 메소드를 호출하는 곳이 static 일 경우 이 메소드도 static 이어야 하므로 (호출되는 scope 때문)

}