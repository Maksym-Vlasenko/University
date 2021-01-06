package com.maksim.lab2;

public class Lab2 {
    public static void main(String[] args) {
        Lab2 lab2 = new Lab2();
        double leftBound = 1;
        double rightBound = 5;
        double step = 0.01;
        System.out.printf("Left bound = %.0f%nRight bound = %.0f%nStep = %.2f%n%n", leftBound, rightBound, step);

        double[] xValues = lab2.calculateXValues(leftBound, rightBound, step);
        double[] yValues = lab2.calculateYValues(xValues);
        System.out.println("X count: " + xValues.length);
        System.out.println("Y count: " + yValues.length);
        System.out.println();

        int maxYOrdinal = lab2.findMaxElementOrdinal(yValues);
        double maxY = yValues[maxYOrdinal];
        System.out.printf("Max Y = %.3f%n", maxY);
        System.out.println("Max Y ordinal = " + maxYOrdinal);
        System.out.println();

        int minYOrdinal = lab2.findMinElementOrdinal(yValues);
        double minY = yValues[minYOrdinal];
        System.out.printf("Min Y = %.3f%n", minY);
        System.out.println("Min Y ordinal = " + minYOrdinal);
        System.out.println();

        double sumY = lab2.sum(yValues);
        double averageY = sumY / yValues.length;
        System.out.printf("Sum Y = %.3f%n", sumY);
        System.out.printf("Average Y = %.3f%n", averageY);
    }

    public double calculateY(double x) {
        double y;
        double a = 2.4;
        if (DoubleUtils.greaterThan(x, a)) {
            y = x * Math.sqrt(x - a);
        } else if (DoubleUtils.equals(x, a)) {
            y = x * Math.sin(a * x);
        } else {
            y = Math.exp(-(a * x)) * Math.cos(a * x);
        }
        return y;
    }

    public int countSteps(double leftBound, double rightBound, double step) {
        return (int) ((rightBound - leftBound) / step) + 1;
    }

    public double[] calculateYValues(double[] xValues) {
        double[] yValues = new double[xValues.length];
        for (int i = 0; i < xValues.length; i++) {
            yValues[i] = calculateY(xValues[i]);
        }
        return yValues;
    }

    public double[] calculateXValues(double leftBound, double rightBound, double step) {
        int stepsCount = countSteps(leftBound, rightBound, step);
        double[] results = new double[stepsCount];
        for (int i = 0; i < stepsCount; i++) {
            results[i] = leftBound + (i * step);
        }
        return results;
    }

    public int findMaxElementOrdinal(double[] yValues) {
        double max = yValues[0];
        int maxElementOrdinal = 0;
        for (int i = 0; i < yValues.length; i++) {
            double actualYValue = yValues[i];
            if (DoubleUtils.greaterThan(actualYValue, max)) {
                max = actualYValue;
                maxElementOrdinal = i;
            }
        }
        return maxElementOrdinal;
    }

    public int findMinElementOrdinal(double[] yValues) {
        double min = yValues[0];
        int minElementOrdinal = 0;
        for (int i = 0; i < yValues.length; i++) {
            double actualYValue = yValues[i];
            if (DoubleUtils.lessThan(actualYValue, min)) {
                min = actualYValue;
                minElementOrdinal = i;
            }
        }
        return minElementOrdinal;
    }

    public double sum(double[] yValues) {
        double sum = 0;
        for (double y : yValues) {
            sum += y;
        }
        return sum;
    }
}
