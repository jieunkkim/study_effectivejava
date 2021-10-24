package me.study.effetivejava.item01.factoryexample;

public class ComponentFactory {

    // Factory 역할을 하는 메소드로, 로직에서 Component 타입으로 객체를 선언하고, 실제 인스턴스를 생성하는건 이 메소드.
    // 로직에서 Button, Switch 등을 직접 생성시킬 수도 있지만, 해당 클래스들의 매개변수 등이 수정 되었을 때 변경 범위가 커짐
    // Factory method 를 사용할 경우, 이 메소드만 고쳐주면 됨.
    public Component getComp(Usage usage) {
        if(Usage.PRESS.equals(usage)){
            return new Button();
        } else if (Usage.TOGGLE.equals(usage)) {
            return new Switch();
        } else {
            return new Dropdown();
        }
    }
}
