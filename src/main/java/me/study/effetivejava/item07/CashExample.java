package me.study.effetivejava.item07;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class CashExample {
    public static void main(String[] args) {
        Object key1 = new Object();
        Object value1 = new Object();

        Map<Object, Object> cache = new HashMap<>(); // 나쁜 예 : 보통 Cash에 HashMap을 잘 쓰지 않음
        cache.put(key1, value1);    // 일반 HashMap은 Strong Reference. cache 가 key1 을 Strong reference 로 가르키고 있어서, key1 을 GC 할 수 없음

        // cache 나 callback 을 사용 후, 더 이상 사용하지 않아 비워줘야 하는 경우가 있을 때 WeakHashMap 을 사용하면 유용 (뒤에 Weak Reference 추가로 다룰 예정)
        Map<Object, Object> newCache = new WeakHashMap<>();
        newCache.put(key1, value1); // WeakHashMap을 사용하면 key1이 WeakReference 로 들어감 (?)

        // Strong Reference
        Object object = new Object();
        // Weak Reference
        WeakReference weakReference = new WeakReference(object); // Strong Reference를 감싸서 만듬

        // GC 대상이 되려면 해당 대상을 가르키는 Reference가 전부 없어져야 가능.
        // Strong Reference 가 없다면 가능. Weak Reference 는 남아있어도 GC 처리 대상이 될 수 있음.
    }
}
