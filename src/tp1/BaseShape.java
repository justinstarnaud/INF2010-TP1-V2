package tp1;

import java.util.*;
import java.util.stream.Collectors;

public class BaseShape implements Cloneable {
    private Collection<Point2d> coords;

    // TODO Initialiser la liste de points.
    public BaseShape() {
        this.coords = new LinkedList<Point2d>();
    }

    // TODO prendre une liste de points et creer une nouvelle forme.
    public BaseShape(Collection<Point2d> coords) {
        this.coords = new ArrayList<Point2d>();
        this.addAll(coords);
    }

    // TODO ajouter ou retirer des coordonnees a la liste de points.
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

    // TODO retourner les coordonnees de la liste.
    public Collection<Point2d> getCoords() {
        return this.coords;
    }

    // TODO retourner une nouvelle liste ou tous les points sont des copy
    public Collection<Point2d> getCoordsDeepCopy() {
        return this.clone().coords;
    }

    // TODO appliquer la translation sur la forme.
    public BaseShape translate(Point2d point) {
        for(Point2d pt2d: this.coords) {
            PointOperator.translate(pt2d.vector, point.vector);
        }
        return this;
    }

    // TODO appliquer la rotation sur la forme.
    public BaseShape rotate(Double angle) {
        for(Point2d pt2d: this.coords) {
            PointOperator.rotate(pt2d.vector, angle);
        }
        return this;
    }

    // TODO donner la plus grande valeur en X
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

    // TODO donner la plus grande valeur en Y
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

    // TODO donner les plus grandes valeurs en X et Y
    public Point2d getMaxCoord() {
        Double maxX = getMaxX();
        Double maxY = getMaxY();
        return new Point2d(maxX, maxY);
    }

    // TODO donner la plus petite valeur en X
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
    // TODO donner la plus petite valeur en Y
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

    // TODO donner les plus petites valeurs en X et Y
    public Point2d getMinCoord() {
        Double minX = getMinX();
        Double minY = getMinY();
        return new Point2d(minX, minY);
    }

    // TODO retourner une nouvelle forme.
    public BaseShape clone() {
        return this.clone();
    }
}