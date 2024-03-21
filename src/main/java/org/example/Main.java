package org.example;

public class Main {

    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4, 5}; // Datos de entrada
        double[] y = {4, 8, 12, 16, 20}; // Datos de salida

        // Calcular la pendiente y la intersección de la línea de regresión
        double pendiente = calcularPendiente(x, y);
        double interseccion = calcularInterseccion(x, y, pendiente);

        // Imprimir la ecuación de la línea de regresión
        System.out.println("La ecuación de la línea de regresión es: y = " + pendiente + "x + " + interseccion);

        // Calcular el coeficiente de determinación (R^2)
        double r2 = calcularR2(x, y, pendiente, interseccion);
        System.out.println("Coeficiente de determinación (R^2): " + r2);

        // Calcular el error estándar de la estimación (SEE)
        double see = calcularSEE(x, y, pendiente, interseccion);
        System.out.println("Error estándar de la estimación (SEE): " + see);

        // Calcular el error cuadrático medio (ECM)
        double ecm = calcularECM(x, y, pendiente, interseccion);
        System.out.println("Error cuadrático medio (ECM): " + ecm);

        // Calcular el error absoluto medio (EAM)
        double eam = calcularEAM(x, y, pendiente, interseccion);
        System.out.println("Error absoluto medio (EAM): " + eam);

        // Hacer una predicción
        double nuevaX = 6;
        double prediccion = predecirValor(nuevaX, pendiente, interseccion);
        System.out.println("Predicción para x = " + nuevaX + ": y = " + prediccion);
    }

    // Función para calcular la pendiente de la línea de regresión
    public static double calcularPendiente(double[] x, double[] y) {
        double sumXY = 0, sumX = 0, sumY = 0, sumXSquare = 0;
        int n = x.length;

        for (int i = 0; i < n; i++) {
            sumXY += x[i] * y[i];
            sumX += x[i];
            sumY += y[i];
            sumXSquare += x[i] * x[i];
        }

        return (n * sumXY - sumX * sumY) / (n * sumXSquare - sumX * sumX);
    }

    // Función para calcular la intersección de la línea de regresión
    public static double calcularInterseccion(double[] x, double[] y, double m) {
        int n = x.length;
        double sumY = 0, sumX = 0;

        for (int i = 0; i < n; i++) {
            sumY += y[i];
            sumX += x[i];
        }

        return (sumY - m * sumX) / n;
    }

    // Función para predecir un valor dado x
    public static double predecirValor(double x, double pendiente, double interseccion) {
        return pendiente * x + interseccion;
    }

    // Función para calcular el coeficiente de determinación (R^2)
    public static double calcularR2(double[] x, double[] y, double pendiente, double interseccion) {
        int n = x.length;
        double sumY = 0;
        double sumYhat = 0;

        // Calcular la media de y
        for (int i = 0; i < n; i++) {
            sumY += y[i];
        }
        double meanY = sumY / n;

        // Calcular la suma de los cuadrados totales
        double SST = 0;
        for (int i = 0; i < n; i++) {
            SST += Math.pow(y[i] - meanY, 2);
        }

        // Calcular la suma de los cuadrados de la regresión (SSR)
        double SSR = 0;
        for (int i = 0; i < n; i++) {
            double yhat = pendiente * x[i] + interseccion;
            sumYhat += yhat;
            SSR += Math.pow(yhat - meanY, 2);
        }

        // Calcular R^2
        double R2 = SSR / SST;
        return R2;
    }

    // Función para calcular el error estándar de la estimación (SEE)
    public static double calcularSEE(double[] x, double[] y, double pendiente, double interseccion) {
        int n = x.length;
        double sumSquaredErrors = 0;

        for (int i = 0; i < n; i++) {
            double predictedY = pendiente * x[i] + interseccion;
            double error = y[i] - predictedY;
            sumSquaredErrors += Math.pow(error, 2);
        }

        double SEE = Math.sqrt(sumSquaredErrors / (n - 2)); // Se resta 2 por los dos parámetros estimados (pendiente e intersección)
        return SEE;
    }

    // Función para calcular el error cuadrático medio (ECM)
    public static double calcularECM(double[] x, double[] y, double pendiente, double interseccion) {
        int n = x.length;
        double sumSquaredErrors = 0;

        for (int i = 0; i < n; i++) {
            double predictedY = pendiente * x[i] + interseccion;
            double error = y[i] - predictedY;
            sumSquaredErrors += Math.pow(error, 2);
        }

        double ECM = sumSquaredErrors / n;
        return ECM;
    }

    // Función para calcular el error absoluto medio (EAM)
    public static double calcularEAM(double[] x, double[] y, double pendiente, double interseccion) {
        int n = x.length;
        double sumAbsoluteErrors = 0;

        for (int i = 0; i < n; i++) {
            double predictedY = pendiente * x[i] + interseccion;
            double error = Math.abs(y[i] - predictedY);
            sumAbsoluteErrors += error;
        }

        double EAM = sumAbsoluteErrors / n;
        return EAM;
    }
}

