package tp1;

import org.w3c.dom.css.Rect;

public final class LetterFactory {
    final static Double maxHeight = 200.0;
    final static Double maxWidth = maxHeight / 2.5;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 8;
    final static Double halfStripeThickness = stripeThickness / 2;

    public static BaseShape create_e() {
        Ellipse contour = new Ellipse(maxWidth, maxHeight);
        Ellipse centre = new Ellipse(maxWidth-stripeThickness, maxHeight-stripeThickness);
        Rectangle barreCentrale = new Rectangle(maxWidth, stripeThickness);
        Rectangle barreAEnlever = new Rectangle(halfMaxWidth, stripeThickness).translate(new Point2d(halfMaxWidth, stripeThickness));
        contour.remove(centre);
        contour.remove(barreAEnlever);
        contour.add(barreCentrale);
        return contour;
    }

    public static BaseShape create_a() {
        Ellipse contour = new Ellipse(maxWidth, maxHeight);
        Ellipse centre = new Ellipse(maxWidth-stripeThickness, maxHeight-stripeThickness);
        Rectangle barreVerticale = new Rectangle(halfStripeThickness, halfMaxHeight).translate(new Point2d(halfMaxWidth-halfStripeThickness/2, halfMaxHeight/2));
        contour.remove(centre);
        contour.add(barreVerticale);
        return contour;
    }

    public static BaseShape create_l() {
        return new Rectangle(halfStripeThickness, maxHeight);
    }

    public static BaseShape create_i() {
        Rectangle barre = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle aEnlever = new Rectangle(stripeThickness, stripeThickness * 2).translate(new Point2d(0.0, -((halfMaxHeight/2) + stripeThickness)));
        Ellipse point = new Ellipse(stripeThickness, stripeThickness).translate(new Point2d(0.0, -(halfMaxHeight-(stripeThickness/2))));
        barre.remove(aEnlever);
        barre.add(point);
        return barre;
    }

    public static BaseShape create_V() {
        Rectangle barreDroite = new Rectangle(halfStripeThickness , maxHeight).rotate(Math.toRadians(9)).translate(new Point2d(-halfMaxWidth/2.5,0.0));
        Rectangle barreGauche = new Rectangle(halfStripeThickness , maxHeight).rotate(-Math.toRadians(9)).translate(new Point2d(halfMaxWidth/2.5,0.0));
        barreDroite.add(barreGauche);
        return barreDroite;
    }

    public static BaseShape create_B() {
        Rectangle barreGauche = new Rectangle(halfStripeThickness, maxHeight).translate(new Point2d(-halfMaxWidth, 0.0));
        BaseShape rondHaut = petitRond().translate(new Point2d(-halfMaxWidth + halfStripeThickness, -halfMaxHeight/2));
        BaseShape rondBas = petitRond().translate(new Point2d(-halfMaxWidth + halfStripeThickness, halfMaxHeight/2));
        barreGauche.add(rondHaut);
        barreGauche.add(rondBas);
        return barreGauche;
    }

    private static BaseShape petitRond() {
        Rectangle aEnlever = new Rectangle(halfMaxWidth, maxHeight).translate(new Point2d(-halfMaxWidth/2, 0.0));
        Ellipse contour = new Ellipse(maxWidth, halfMaxHeight);
        Ellipse centre = new Ellipse(maxWidth - halfStripeThickness * 2, halfMaxHeight -halfStripeThickness);
        contour.remove(centre);
        contour.remove(aEnlever);
        return contour;
    }

}

