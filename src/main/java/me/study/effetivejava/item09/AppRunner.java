package me.study.effetivejava.item09;

public class AppRunner {
    public static void main(String[] args) {

        // try-with-resource 는 최초 에러부터 확인이 가능 (고전방법은 가장 마지막 에러만 확인 가능)
        // java 7 이상부터 가능
        try (MyResource myResource3 = new MyResource();
        MyResource myResource4 = new MyResource()) {
            myResource3.doSomething();
            myResource4.doSomething();
        }


        // 리소스를 반납하면서 error 처리하는 고전적인 방법
        // 아래와 같이 구현하면 FirstError 를 확인할 수 없음 (최초에 발생한 에러 확인 불가)
        /*MyResource myResource = new MyResource();
        try{
            myResource.doSomething();
        }finally {
            myResource.close();
        }
        */
        /*MyResource myResource1 = new MyResource();
        try{
            myResource1.doSomething();
            MyResource myResource2 = null;
            try{
                myResource2 = new MyResource();
                myResource2.doSomething();
            }finally {
                if (myResource2 != null) {
                    myResource2.close();
                }
            }
        }finally {
            myResource1.close();
        }*/
    }
}
