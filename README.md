# Regresión Lineal Simple y Múltiple

Este proyecto Java contiene implementaciones de regresión lineal simple y múltiple utilizando la biblioteca Apache Commons Math.

## Regresión Lineal Simple

La regresión lineal simple es un método para modelar la relación entre una variable independiente (X) y una variable dependiente (Y) mediante una línea recta.

En el archivo `Main.java`, se encuentra la implementación de la regresión lineal simple. Se calcula la pendiente, la intersección, el coeficiente de determinación (R^2), el error estándar de la estimación (SEE), el error cuadrático medio (ECM) y el error absoluto medio (EAM). También se proporciona una función para predecir valores dados nuevos datos de entrada.

## Regresión Lineal Múltiple

La regresión lineal múltiple es una extensión de la regresión lineal simple que modela la relación entre múltiples variables independientes (X) y una variable dependiente (Y) mediante un hiperplano.

En el archivo `MultipleLinearRegressionExample.java`, se encuentra la implementación de la regresión lineal múltiple utilizando la clase `OLSMultipleLinearRegression` de Apache Commons Math. Se calculan los coeficientes de regresión y se realiza una predicción utilizando los coeficientes obtenidos. También se calcula el error cuadrático medio (MSE) para evaluar la calidad de la predicción.

## Uso

Para ejecutar el proyecto, simplemente compile y ejecute el archivo `Main.java` o `MultipleLinearRegressionExample.java` en su entorno de desarrollo Java preferido.

Asegúrese de incluir las dependencias de Apache Commons Math en su proyecto Java. Si utiliza Maven, puede agregar la siguiente dependencia en su archivo `pom.xml`:

```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-math3</artifactId>
    <version>3.6.1</version>
</dependency>
