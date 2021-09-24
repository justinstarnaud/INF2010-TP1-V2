package tp1;

import java.util.*;

public final class PointOperator {

    public static void translate(Double[] vector, Double[] translateVector) {
        for(int i=0; i<vector.length; i++) {
            vector[i] += translateVector[i];
        }
    }

    public static void rotate(Double[] vector, Double[][] rotationMatrix) {
        final Double[] vector2 = new Double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            vector2[i] = vector[i];
        }
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < rotationMatrix[i].length; j++) {
                vector[i] = vector2[j] * rotationMatrix[i][j];
            }
        }
    }

    public static void rotate(Double[] vector, Double angle) {
        Double[][] matriceMult = new Double[][]{{Math.cos(angle), Math.sin(angle)},{-Math.sin(angle), Math.cos(angle)}};
        rotate(vector, matriceMult);
    }

    public static void divide(Double[] vector, Double divider) {
        for (double vec: vector) {
            vec /= divider;
        }
    }

    public static void multiply(Double[] vector, Double multiplier) {
        for (double vec: vector) {
            vec *= multiplier;
        }
    }

    public static void add(Double[] vector, Double adder) {
        for (double vec: vector) {
            vec += adder;
        }
    }
}
