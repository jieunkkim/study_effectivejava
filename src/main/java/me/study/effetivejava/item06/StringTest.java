package me.study.effetivejava.item06;

public class StringTest {
    public static void main(String[] args) {
        /* 문자열 예제 */
        // 나쁜 예
        String name = new String("test");
        String name2 = new String("test");
        // 좋은 예
        String name3 = "test";

        // 여기서 equals 는 object equals 를 Overriding 하여 컨텐츠를 비교하도록 구현되어 있음
        System.out.println(name.equals(name2)); // true
        System.out.println(name == name2); // false

        /* Boolean 예제 */
        // 좋은 예 (new 가 아닌 Boolean.valueOf 를 사용하면 불필요한 객체 사용 줄임)
        Boolean boolean1 = Boolean.valueOf("true");
        Boolean boolean2 = Boolean.valueOf("true");
        // 나쁜 예
        Boolean boolean3 = new Boolean(true);

        System.out.println(boolean1.equals(boolean2));   // true
        System.out.println(boolean1 == boolean2);        // true
        System.out.println(boolean1 == Boolean.TRUE);    // true 인스턴스가 다 동일
        System.out.println(boolean1 == boolean3);        // false 나쁜 예는 인스턴스가 다름 (new 로 새로 만들었으므로)
    }
}
