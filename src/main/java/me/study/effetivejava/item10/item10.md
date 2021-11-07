# equals는 일반 규약을 지켜 재정의하라

Object의 equals는 객체 식별성(Object identity:두 물체가 물리적으로 같은가)이 아니라 
논리적 동치성을 확인해야 하는데, 상위 클래스의 equals가 논리적 동치성을 비교하도록 재정의되지
않았을 때이다.

equals 메서드는 동치 관계(equivalence relation)을 구현하며, 다음을 만족해야 한다.
1. 반사성(reflexivity) : null이 아닌 모든 참조 값 x에 대해, x.equals(x)는 true다.
2. 대칭성(symmetry) : null이 아닌 모든 참조값 x, y에 대해, x.equals(y)가 true면, y.equals(x)도 true다.
3. 추이성(transitivity) : null이 아닌 모든 참조 값 x, y, z에 대해, x.equals(y)가 true이고, y.equals(z)가 true이면 x.equals(z)도 true다.
4. 일관성(consistency) : null이 아닌 모든 참조 값 x, y에 대해, x.equals(y)를 반복해서 호출하면 항상 true를 반환하거나 항상 false를 반환한다.
5. null 아님 : null이 아닌 모든 참조 값 x에 대해, x.equals(null)은 false다
   