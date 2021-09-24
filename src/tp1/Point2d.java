package tp1;

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;


    public Point2d(Double x, Double y) {
        super(new Double[]{x, y});
    }


    public Point2d(Double[] vector) {
        super(vector);
    }

    public Double X() { return vector[X];}
    public Double Y() { return vector[Y];}

    @Override
    public Point2d translate(Double[] translateVector) {
        PointOperator.translate(this.vector, translateVector);
        return this;
    }

    public Point2d translate(Point2d translateVector) {
        PointOperator.translate(this.vector, translateVector.vector);
        return this;
    }

    @Override
    public Point2d rotate(Double[][] rotationMatrix) {
        PointOperator.rotate(this.vector, rotationMatrix);
        return this;
    }

    public Point2d rotate(Double angle) {
        PointOperator.rotate(this.vector, angle);
        return this;
    }

    @Override
    public Point2d divide(Double divider) {
        PointOperator.divide(this.vector, divider);
        return this;
    }

    @Override
    public Point2d multiply(Double multiplier) {
        PointOperator.multiply(this.vector, multiplier);
        return this;
    }

    @Override
    public Point2d add(Double adder) {
        PointOperator.add(this.vector, adder);
        return this;
    }

    @Override
    public Point2d clone() {
        return new Point2d(this.vector);
    }
}
