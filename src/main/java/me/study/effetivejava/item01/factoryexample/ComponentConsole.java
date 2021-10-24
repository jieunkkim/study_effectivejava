package me.study.effetivejava.item01.factoryexample;

public class ComponentConsole {

    private ComponentFactory compFactory = new ComponentFactory();
    Component component;
    Component component1;
    Component component2;

    // 팩토리를 사용하지 않는 경우, 각 구현체를 직접 명시하며 객체 생성. 만약 구현체 spec 변경이 있을 시 직접 명시한 모든 곳을 수정해줘야 함
    public void withoutFactory() {
        component = new Button();
        component1 = new Switch();
        component2 = new Dropdown();
    }

    // 팩토리를 사용한 경우, getComp라는 팩토리 메소드가 전달받은 매개변수에 따라 알아서 구현체들을 넘겨주기 때문에
    // 로직에선 Component가 abstract이건, interface이건 그 포맷만 알면됨. (구현내용 자세히 알 필요 없음)
    // 각 구현체들의 생성자 매개변수 타입 등 spec 을 수정할 때에도 getComp만 수정해주면 됨.
    public void withFactory() {
        component = compFactory.getComp(Usage.PRESS);
        component = compFactory.getComp(Usage.TOGGLE);
        component = compFactory.getComp(Usage.EXPAND);
    }
}
