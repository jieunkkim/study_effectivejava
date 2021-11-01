package me.study.effetivejava.item06;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 어댑터 예제 (어댑터 : 인퍼테이스를 통해 뒤에 있는 객체로 연결해주는 중간 객체. 여러 개 만들 필요없음. keyset() 이 그러한 경우..?)
public class UsingKeySet {
    public static void main(String[] args) {
        Map<String, Integer> menu = new HashMap<>();
        menu.put("Burger", 8);
        menu.put("Pizza", 9);

        // names1, names2 가 다른 인스턴스를 가질 것 같지만, 같은 menu의 keySet를 참조하고 있어 같은 곳을 바라보고 있다
        // keySet 이 신규 인스턴스를 생성하여 리턴해주는 것이 아닌, menu와 연결시켜주는 중간 역할(어댑터)만 해주고 있는 듯
        Set<String> names1 = menu.keySet();
        Set<String> names2 = menu.keySet();

        // 따라서, names1 에서 변경을 주면 names2 도 영향을 받는다
        names1.remove("Burger"); // names1, names2, map까지 모두 영향을 받는다
        System.out.println(names1 == names2);
        System.out.println(names2.size()); // 1
        System.out.println(menu.size()); // 1
    }
}
