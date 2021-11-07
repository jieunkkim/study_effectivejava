package me.study.effetivejava.item10;

import java.awt.*;

public class ColorPoint extends Point{
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    // 대칭성 위배
    /*
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof ColorPoint)) return false;
        return super.equals(o) && ((ColorPoint) o).color == color;
        // Point의 x,y 일치여부 확인 + color 일치여부 확인을 의도한 구현
        // point.equals 는 색상비교를 하지 않지만 color.equals는 색상비교를 함
    }
*/

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Point)) return false;
        if(!(o instanceof ColorPoint)) return o.equals(this);
        return super.equals(o) && ((ColorPoint) o).color == color;
        // Point의 x,y 일치여부 확인 + color 일치여부 확인을 의도한 구현
        // point.equals 는 색상비교를 하지 않지만 color.equals는 색상비교를 함
    }


    public static void main(String[] args) {
        // 대칭성 위배 p.equals(cp) != cp.equals(p)
        Point p = new Point(1,2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);

        System.out.println(     p.equals(cp)    );
        System.out.println(     cp.equals(p)    );
        System.out.println(     p instanceof ColorPoint     );
        System.out.println(     cp instanceof Point     );

        // 추이성 위배 p1.equals(p2) true, p2.equals(p3) true, p1.equals(p3) false
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1,2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLACK);

        System.out.println(     p1.equals(p2)    );
        System.out.println(     p2.equals(p3)    );
        System.out.println(     p1.equals(p3)    );


    }
}
