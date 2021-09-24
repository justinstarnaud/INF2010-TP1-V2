package tp1;

public final class LetterFactory {
    final static Double maxHeight = 200.0;
    final static Double maxWidth = maxHeight / 2.5;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 8;
    final static Double halfStripeThickness = stripeThickness / 2;

    public static BaseShape create_e() {
        Ellipse exterieurLettre = new Ellipse(maxWidth, maxHeight);
        Ellipse milieuLettre = new Ellipse(maxWidth - stripeThickness, maxHeight - stripeThickness);
        Rectangle barreHorizontale = new Rectangle(maxWidth, stripeThickness);
        BaseShape barreEnleverDroite = new Rectangle(halfMaxWidth, halfMaxHeight / 2.0).translate(new Point2d(halfMaxWidth / 2.0, halfStripeThickness));
        exterieurLettre.remove(milieuLettre);
        exterieurLettre.remove(barreEnleverDroite);
        exterieurLettre.add(barreHorizontale);
        return exterieurLettre;
    }

    public static BaseShape create_a() {
        Ellipse lettreA = new Ellipse(maxWidth, maxHeight);
        Ellipse milieuLettre = new Ellipse(1.5 * halfMaxWidth, 1.5 * halfMaxHeight);
        Rectangle barreVerticale = new Rectangle(halfStripeThickness, maxHeight).translate(new Point2d(halfMaxWidth, 0.0));
        lettreA.remove(milieuLettre);
        lettreA.add(barreVerticale);
        return lettreA;
    }

    public static BaseShape create_l() {
        return new Rectangle(halfStripeThickness, maxHeight);
    }

    public static BaseShape create_i() {
        Rectangle barreVerticale = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle barreEnlever = new Rectangle(halfStripeThickness, 2.0 * stripeThickness).translate(new Point2d(0.0, -(halfMaxHeight - stripeThickness)));
        Ellipse pointI = new Circle(stripeThickness).translate(new Point2d(0.0, -(halfMaxHeight - halfStripeThickness)));
        barreVerticale.remove(barreEnlever);
        barreVerticale.add(pointI);
        return barreVerticale;
    }

    public static BaseShape create_V() {
        Rectangle barreDroite = new Rectangle(halfStripeThickness , maxHeight).rotate(Math.toRadians(9)).translate(new Point2d(-halfMaxWidth/2.5,0.0));
        Rectangle barreGauche = new Rectangle(halfStripeThickness , maxHeight).rotate(-Math.toRadians(9)).translate(new Point2d(halfMaxWidth/2.5,0.0));
        barreDroite.add(barreGauche);
        return barreDroite;
    }

    public static BaseShape create_B() {
        Rectangle lettreB = new Rectangle(halfStripeThickness, maxHeight).translate(new Point2d(1.5 * LetterFactory.halfStripeThickness, 0.0));

        BaseShape cercleInferieur = new Circle(maxHeight / 2.0).translate(new Point2d(halfMaxWidth / 2.0, -halfMaxHeight / 2.0));
        BaseShape interieurASupprimer = new Circle(maxHeight / 2.0 - stripeThickness).translate(new Point2d(halfMaxWidth / 2.0, -halfMaxHeight / 2.0));
        cercleInferieur.remove(interieurASupprimer);
        lettreB.add(cercleInferieur);

        BaseShape cercleSuperieur = new Circle(maxHeight / 2.0).translate(new Point2d(halfMaxWidth / 2.0, halfMaxHeight / 2.0));
        BaseShape interieurASupprimer2 = new Circle(maxHeight / 2.0 - stripeThickness).translate(new Point2d(halfMaxWidth / 2.0, halfMaxHeight / 2.0));
        cercleSuperieur.remove(interieurASupprimer2);
        lettreB.add(cercleSuperieur);

        Rectangle barreSupprimerGauche = new Rectangle(4.0 * LetterFactory.stripeThickness, maxHeight).translate(new Point2d(-1.5 * stripeThickness, 0.0));
        lettreB.remove(barreSupprimerGauche);
        
        return lettreB;
    }

}

