/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Circle {
    Point center;
    double radius;

    public Circle() {

    }

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public static boolean intersect(Circle c1, Circle c2) {
        double side_A = Math.abs(c1.center.x - c2.center.x);
        double side_B = Math.abs(c1.center.y - c2.center.y);

        double side_C = Math.sqrt(side_A * side_A + side_B * side_B);
        double sumRadiuses = Math.abs(c1.radius + c2.radius);

        if (side_C <= sumRadiuses) {
            return true;
        }

        return false;

    }
}
