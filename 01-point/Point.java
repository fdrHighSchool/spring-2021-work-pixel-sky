public class Point {
    private int x;
    private int y;

    // constructs a new point at the origin, (0, 0)
    public Point() {
        this(0, 0); // calls Point(int, int) constructor
    }
    
    // constructs a new point with the given (x, y) location
    public Point(int x, int y) {
        setLocation(x, y);
    }

    // sets this point's (x, y) location to the given values
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    // returns the x-coordinate of this point
    public int getX() {
        return this.x;
    }

    // returns the y-coordinate of this point
    public int getY() {
        return this.y;
    }
    
    // returns the distance between this Point and (0, 0)
    public double distanceFromOrigin() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
    
    // shifts this point's location by the given amount
    public void translate(int dx, int dy) {
        setLocation(this.x + dx, this.y + dy);
    }

    // method that takes in another Point object as a parameter and returns the distance (double) between the two points.
    public double distance(Point point) {
        return Math.sqrt(Math.pow(this.x - point.getX(), 2) + Math.pow(this.y - point.getY(), 2));
    }

    // method that takes in another Point object as a parameter and returns a Point object that is the midpoint of the two points.
    public Point midpoint(Point point) {
        return new Point((this.x + point.getX()) / 2, (this.y + point.getY()) / 2);
    }

    // method that takes in another Point abject as a parameter and returns the slope (double) of the line that would connect the two points.
    public double slope(Point point) {
        return (point.getY() -  this.y) / (point.getX() - this.x);
    }

    // method that takes in two Point objects as parameters and returns whether or not the three points could be connected by a straight line.
    public boolean isCollinear(Point point1, Point point2) {
        return this.slope(point1) == this.slope(point2);
    }
    
    // returns a String representation of this point
    @Override
    public String toString() {
        return String.format("(%d, %d)", this.x, this.y);
    }
}