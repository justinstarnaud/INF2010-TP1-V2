package tp1;

import java.util.ArrayList;
import java.util.Collection;

public class Rectangle extends BaseShape {
    public Rectangle(Double width, Double height) {
        super(new ArrayList());
        double largeur = width / 2;
        double hauteur = height / 2;
        for (double i = -largeur; i < largeur; i++) {
            for (double j = -hauteur; j < hauteur; j++) {
                add(new Point2d(i, j));
            }
        }
    }

    public Rectangle(Point2d dimensions) {
        this(dimensions.X(), dimensions.Y());
    }

    private Rectangle(Collection<Point2d> coords) {
        super(coords);
    }

    @Override
    public Rectangle translate(Point2d point) {
        super.translate(point);
        return this;
    }

    @Override
    public Rectangle rotate(Double angle) {
        super.rotate(angle);
        return this;
    }

    @Override
    public Rectangle clone() {
        return new Rectangle(this.getCoordsDeepCopy());
    }
}
