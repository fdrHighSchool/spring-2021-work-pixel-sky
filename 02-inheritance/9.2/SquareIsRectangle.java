class Rectangle {
    private int length;
    private int width;

    public Rectangle() {
        this.length = 1;
        this.width = 1;
    }

    public Rectangle(int l, int w) {
        this.length = l;
        this.width = w;
    }

    public int area() {
        return this.length * this.width;
    }

    public void draw() {
        for(int i=0; i < this.length; i++) {
            for(int j=0; j < this.width; j++)
                System.out.print("* ");
            System.out.println();
        }
        System.out.println();
    }
}

// 1. Make the class square inherit from Rectangle
class Square extends Rectangle {
    // 2. Add a Square no-argument constructor
    public Square() {
        super();
    }

    // 3. Add a Square constructor with 1 argument for a side
    public Square(int s) {
        super(s, s);
    }
}

class LongRectangle extends Rectangle {
    public LongRectangle() {
        super(1, 2);
    }

    public LongRectangle(int width) {
        super(width*2, width);
    }
}

public class SquareIsRectangle {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(3,5);
        System.out.printf("area: %d\n", r.area());
        r.draw();
        // 4. Uncomment these to test
        Square s1 = new Square();
        System.out.printf("area: %d\n", s1.area());
        s1.draw();
        Square s = new Square(3);
        System.out.printf("area: %d\n", s.area());
        s.draw();

        LongRectangle lr = new LongRectangle(2);
        System.out.printf("area: %d\n", lr.area());
        lr.draw();
    }
}