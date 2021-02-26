import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(0, 0));
        points.add(new Point(2, 4));
        points.add(new Point(-6, 8));

        print(points.get(0).midpoint(points.get(1)).toString());
        print(points.get(0).distance(points.get(2)));
        print(points.get(0).isCollinear(points.get(1), points.get(2)));
    }

    public static void print(Object obj) {
        System.out.println(obj);
    }
}
