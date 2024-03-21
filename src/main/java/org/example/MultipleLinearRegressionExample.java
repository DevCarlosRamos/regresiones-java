package org.example;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

public class MultipleLinearRegressionExample {

    public static void main(String[] args) {
        // Datos de entrada (variables independientes)
        double[][] x = {
                {1, 8},
                {2, 3},
                {3, 4},
                {4, 2},
                {5, 6}
        };

        // Datos de salida (variable dependiente)
        double[] y = {2, 4, 5, 4, 5};

        // Crear un objeto de regresión lineal múltiple
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();

        // Agregar datos
        regression.newSampleData(y, x);

        // Calcular los coeficientes de regresión
        double[] coefficients = regression.estimateRegressionParameters();

        // Nuevos datos de entrada
        double[] newX = {6, 7};

        // Realizar la predicción utilizando los coeficientes de regresión
        double prediction = coefficients[0]; // Intercepto
        for (int i = 0; i < x[0].length; i++) {
            prediction += coefficients[i + 1] * newX[i]; // Coeficientes de las variables independientes
        }

        // Calcular el error cuadrático medio (MSE)
        double mse = calculateMSE(regression, newX, y);

        // Imprimir la predicción y el MSE
        System.out.println("Predicción para nuevos datos: " + prediction);
        System.out.println("Error cuadrático medio (MSE): " + mse);
    }

    // Método para calcular el error cuadrático medio (MSE)
    public static double calculateMSE(OLSMultipleLinearRegression regression, double[] newX, double[] y) {
        double[] coefficients = regression.estimateRegressionParameters(); // Coeficientes de regresión
        double prediction = coefficients[0]; // Intercepto

        // Calcular la predicción manualmente
        for (int i = 0; i < newX.length; i++) {
            prediction += coefficients[i + 1] * newX[i]; // Coeficientes de las variables independientes
        }

        // Calcular el error
        double error = prediction - y[0]; // Error
        double mse = error * error; // Error cuadrático
        return mse;
    }
}