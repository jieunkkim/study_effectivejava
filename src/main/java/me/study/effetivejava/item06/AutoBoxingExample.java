package me.study.effetivejava.item06;

public class AutoBoxingExample {
    public static void main(String[] args) {
        // 나쁜 예
        long start = System.currentTimeMillis(); // long : primitive Type
        Long sum = 0l;  // Long : Reference Type
        for (long i = 0 ; i <= Integer.MAX_VALUE ; i++) {
            sum += i;   // sum(Long)에 값을 넣기 위해 계속 새로운 Long 인스턴스를 만드는 중
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - start);

        // 정상적인
        start = System.currentTimeMillis();
        long sum2 = 0l;
        for (long i = 0 ; i <= Integer.MAX_VALUE ; i++) {
            sum2 += i;
        }
        System.out.println(sum2);
        System.out.println(System.currentTimeMillis() - start);
    }
}
