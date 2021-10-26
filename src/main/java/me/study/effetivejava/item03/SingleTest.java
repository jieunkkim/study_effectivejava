package me.study.effetivejava.item03;

import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Constructor;
import java.util.function.Supplier;

public class SingleTest {
    public static void main(String[] args) throws NoSuchMethodException {
        /*  생성자가 private 이기 때문에 아래와 같은 객체 생성은 불가.
            대신 public 인 instance 를 받아올 수 있다.
            Singleton1 singleton1 = new Singleton1();
        */
        Singleton1 singleton1 = Singleton1.instance;    // final 필드를 사용한 싱글톤
        Singleton2 singleton2 = Singleton2.getInstance();   // static 팩토리 메소드를 사용한 싱글톤톤
        Supplier<Singleton2> singleton2Supplier = Singleton2::getInstance;

        Singleton3 singleton3 = Singleton3.INSTANCE;
        System.out.println(singleton3.getName());

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(UserConfig.class);
        UserService userService1 = applicationContext.getBean(UserService.class);
        UserService userService2 = applicationContext.getBean(UserService.class);
        System.out.println(userService1 + " / " + userService2);
    }
}
