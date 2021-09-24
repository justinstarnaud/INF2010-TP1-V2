package tp1;

import java.util.ArrayList;
import java.util.Collection;

public class Ellipse extends BaseShape {
    // TODO creer une ellipse avec une largeur et une longueur.
    public Ellipse(Double widthRadius, Double heightRadius) {
        super(new ArrayList());
        final double largeur = -widthRadius / 2.0;
        final double hauteur = -heightRadius / 2.0;
        for (double i = largeur; i < -1.0 * largeur; ++i) {
            for (double j = hauteur; j < -1.0 * hauteur; ++j) {
                final double evolutionX = Math.pow(i, 2.0) / Math.pow(largeur, 2.0);
                final double evolutionY = Math.pow(j, 2.0) / Math.pow(hauteur, 2.0);
                final double Xy = evolutionX + evolutionY;
                if (Xy <= 1.0) {
                    this.add(new Point2d(i, j));
                }
            }
        }
    }

    // TODO creer une ellipse avec les dimensions contenu dans un Point.
    public Ellipse(Point2d dimensions) {
        this(dimensions.X(), dimensions.Y());
    }

    // TODO initialiser le parent.
    private Ellipse(Collection<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Ellipse translate(Point2d point) {
        super.translate(point);
        return this;
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Ellipse rotate(Double angle) {
        super.rotate(angle);
        return this;
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Ellipse clone() {
        return new Ellipse(this.getCoordsDeepCopy());
    }
}
