package me.study.effetivejava.item07;

import java.util.Arrays;
import java.util.EmptyStackException;

// Can you spot the "memory leak"?
public class Stack {

    private Object[] elements; // 이런 멤버변수는

    private int size = 0;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        this.ensureCapacity();
        this.elements[size++] = e;
    }

    // 나쁜 예
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        return this.elements[--size]; // 주목!! 여기서 값이 리턴되기만 했고 값을 뺀 공간에는 값이 그대로 남아있다
    }

    // 좋은 예
    public Object newPop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        Object value = this.elements[--size];
        this.elements[size] = null; // 값을 뺀 뒤 해당 공간의 값을 null 로 만들어준다. (다만 굳이 매번 이럴 필욘 없다)
        return value;
    }

    public void test() {
        Object age = 100;
        /* use age */
        age = null;  // age 는 메소드 내 로컬변수 이므로, test() 가 종료되면 GC에 의해 정리된다. 따라서 굳이 이런 때 매번 null 처리해줄 필요는 없다.
    }
    /**
     * Ensure space for at least one more element,
     * roughly doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (this.elements.length == size) {
            this.elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}