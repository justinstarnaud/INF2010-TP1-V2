package tp1;

public final class PointOperator {

    public static void translate(Double[] vector, Double[] translateVector) {
        for(int i=0; i<vector.length; i++) {
            vector[i] += translateVector[i];
        }
    }

    public static void rotate(Double[] vector, Double[][] rotationMatrix) {
        Double[] vector2 = vector.clone();
        for (int i = 0; i < vector.length; i++) {
            vector[i] = 0.0;
            for (int j = 0; j < rotationMatrix[i].length; j++) {
                vector[i] += vector2[j] * rotationMatrix[i][j];
            }
        }
    }

    public static void rotate(Double[] vector, Double angle) {
        Double[][] matriceMult = new Double[][]{{Math.cos(angle), Math.sin(angle)},{-Math.sin(angle), Math.cos(angle)}};
        rotate(vector, matriceMult);
    }

    public static void divide(Double[] vector, Double divider) {
        for (int i = 0; i < vector.length; ++i) {
            vector[i] /= divider;
        }
    }

    public static void multiply(Double[] vector, Double multiplier) {
        for (int i = 0; i < vector.length; ++i) {
            vector[i] *= multiplier;
        }
    }

    public static void add(Double[] vector, Double adder) {
        for (int i = 0; i < vector.length; ++i) {
            vector[i] += adder;
        }
    }
}
