package tp1;

import java.util.*;

public final class PointOperator {

    // TODO appliquer la translation sur le vecteur d'entree.
    public static void translate(Double[] vector, Double[] translateVector) {
        for(int i=0; i<vector.length; i++) {
            vector[i] += translateVector[i];
        }
    }

    // TODO appliquer la translation sur le vecteur d'entree.
    public static void rotate(Double[] vector, Double[][] rotationMatrix) {
//        final Double[] vector2 = new Double[vector.length];
//        for(int i = 0; i<vector.length; i++) {
//            for (int j =0; j< rotationMatrix[i].length; j++) {
//                vector2[i] = vector[j] * rotationMatrix[i][j];
//            }
//        }
//
//        for (int i = 0; i < vector.length; ++i) {
//             vector[i] = vector2[i] ;
//        }

        final Double[] newVector = new Double[vector.length];
        for (int i = 0; i < vector.length; ++i) {
            newVector[i] = vector[i];
        }
        for (int i = 0; i < vector.length; ++i) {
            vector[i] = 0.0;
            for (int j = 0; j < rotationMatrix[i].length; ++j) {
                final int n = i;
                vector[n] += newVector[j] * rotationMatrix[i][j];
            }
        }
    }

    public static void rotate(Double[] vector, Double angle) {
        Double[][] matriceMult = new Double[][]{{Math.cos(angle), Math.sin(angle)},{-1 * Math.sin(angle), Math.cos(angle)}};
        rotate(vector, matriceMult);
    }

    // TODO appliquer la translation sur le vecteur d'entree.
    public static void divide(Double[] vector, Double divider) {
        for (double vec: vector) {
            vec /= divider;
        }
    }

    // TODO appliquer la translation sur le vecteur d'entree.
    public static void multiply(Double[] vector, Double multiplier) {
        for (double vec: vector) {
            vec *= multiplier;
        }
    }

    // TODO appliquer la translation sur le vecteur d'entree.
    public static void add(Double[] vector, Double adder) {
        for (double vec: vector) {
            vec += adder;
        }
    }
}
