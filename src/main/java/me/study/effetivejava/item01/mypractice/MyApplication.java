package me.study.effetivejava.item01.mypractice;

public class MyApplication {
    public static void main(String[] args) {
        System.out.println(new MyClass());  // Default 생성자
        System.out.println(MyClass.createMyClass()); // 생성자 역할을 하는 정적 메소드 (static method)

        // Default 생성자
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        System.out.println(myClass1 + " / " + myClass2);

        myClass1 = MyClass.createMyClass();
        myClass2 = MyClass.createMyClass();
        System.out.println(myClass1 + " / " + myClass2);

        MyInterface myInterface1 = MyInterface.get();
        MyInterface myInterface2 = MyInterface.getNew();
        System.out.println(myInterface1.getName());
        System.out.println(myInterface2.getName());



    }

}
