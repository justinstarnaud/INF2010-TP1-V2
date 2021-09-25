package tp1;

import java.util.*;

public class BaseShape implements Cloneable {
    private final Collection<Point2d> coords;

    public BaseShape() {
        this.coords = new LinkedList<>();
    }

    public BaseShape(Collection<Point2d> coords) {
        this.coords = new ArrayList<>();
        this.addAll(coords);
    }

    public BaseShape add(Point2d coord) {
        this.coords.add(coord);
        return this;
    }
    public BaseShape add(BaseShape shape) {
        this.coords.addAll(shape.coords);
        return this;
    }
    public BaseShape addAll(Collection<Point2d> coords) {
        this.coords.addAll(coords);
        return this;
    }
    public BaseShape remove(Point2d coord) {
        this.coords.remove(coord);
        return this;
    }
    public BaseShape remove(BaseShape shape) {
        this.coords.removeAll(shape.coords);
        return this;
    }
    public BaseShape removeAll(Collection<Point2d> coords) {
        this.coords.removeAll(coords);
        return this;
    }

    public Collection<Point2d> getCoords() {
        return new ArrayList<>(this.coords);
    }

    public Collection<Point2d> getCoordsDeepCopy() {
        Collection<Point2d> newCoords = new LinkedList<>();
        for (Point2d elem :this.coords) {
            newCoords.add(elem.clone());
        }
        return newCoords;
    }

    public BaseShape translate(Point2d point) {
        for(Point2d pt2d: this.coords) {
            PointOperator.translate(pt2d.vector, point.vector);
        }
        return this;
    }

    public BaseShape rotate(Double angle) {
        for(Point2d pt2d: this.coords) {
            pt2d.rotate(angle);
        }
        return this;
    }

    public Double getMaxX() {
        final int X = 0;
        Double max = 0.0;
        for(Point2d pt2d : this.coords) {
            if (max == 0.0)
                max = pt2d.vector[X];
            else if(pt2d.vector[X] > max)
                max = pt2d.vector[X];
        }
        return max;
    }

    public Double getMaxY() {
        final int Y = 1;
        Double max = 0.0;
        for(Point2d pt2d : this.coords) {
            if (max == 0.0)
                max = pt2d.vector[Y];
            else if(pt2d.vector[Y] > max)
                max = pt2d.vector[Y];
        }
        return max;
    }

    public Point2d getMaxCoord() {
        Double maxX = getMaxX();
        Double maxY = getMaxY();
        return new Point2d(maxX, maxY);
    }

    public Double getMinX() {
        final int X = 0;
        Double min = null;
        for(Point2d pt2d : this.coords) {
            if (min == null)
                min= pt2d.vector[X];
            else if(pt2d.vector[X] < min)
                min = pt2d.vector[X];
        }
        return min;
    }

    public Double getMinY() {
        final int Y = 1;
        Double min = null;
        for(Point2d pt2d : this.coords) {
            if (min == null)
                min= pt2d.vector[Y];
            else if(pt2d.vector[Y] < min)
                min = pt2d.vector[Y];
        }
        return min;
    }

    public Point2d getMinCoord() {
        Double minX = getMinX();
        Double minY = getMinY();
        return new Point2d(minX, minY);
    }

    public BaseShape clone() {
        return new BaseShape(this.getCoordsDeepCopy());
    }
}
