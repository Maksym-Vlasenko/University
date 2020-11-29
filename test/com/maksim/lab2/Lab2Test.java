package com.maksim.lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lab2Test {
    private final Lab2 lab2 = new Lab2();

    @Test
    void testCalculateYFirstCondition() {
        double x = 3.1;
        double expected = 2.5936;
        double actual = lab2.calculateY(x);
        assertEquals(expected, actual, 0.0001, "incorrect values");
    }

    @Test
    void testCalculateYSecondCondition () {
        double x = 2.4;
        double expected = -1.19914;
        double actual = lab2.calculateY(x);
        assertEquals(expected, actual, 0.0001, "incorrect values");
    }

    @Test
    void testCalculateYThirdCondition () {
        double x = 1.2;
        double expected = -0.05422;
        double actual = lab2.calculateY(x);
        assertEquals(expected, actual, 0.0001, "incorrect values");
    }

    @Test
    void testStepsCount() {
        double leftBound = 1;
        double rightBound = 5;
        double step = 0.01;
        int expected = 401;
        int actual = lab2.countSteps(leftBound, rightBound, step);
        assertEquals(expected, actual, "steps count must be equal");
    }

    @Test
    void testCalculateXValues () {
        double leftBound = 1;
        double rightBound = 5;
        double step = 0.01;
        int expectedXValuesCount = 401;
        double[] actualXValues = lab2.calculateXValues(leftBound, rightBound, step);
        assertEquals(expectedXValuesCount, actualXValues.length);
    }

    @Test
    void testCalculateYValues() {
        double leftBound = 1;
        double rightBound = 5;
        double step = 0.01;
        int expectedYValuesCount = 401;
        double[] xValues = lab2.calculateXValues(leftBound, rightBound, step);
        double[] actualYValues = lab2.calculateYValues(xValues);
        assertEquals(expectedYValuesCount, actualYValues.length);
    }

    @Test
    void testFindMaxY() {
        double leftBound = 1;
        double rightBound = 5;
        double step = 0.01;
        double[] xValues = lab2.calculateXValues(leftBound, rightBound, step);
        double[] actualYValues = lab2.calculateYValues(xValues);
        double maxY = lab2.findMaxY(actualYValues);
        assertEquals(maxY, 8.06225774829835);
    }

    @Test
    void testFindMinY() {
        double leftBound = 1;
        double rightBound = 5;
        double step = 0.01;
        double[] xValues = lab2.calculateXValues(leftBound, rightBound, step);
        double[] actualYValues = lab2.calculateYValues(xValues);
        double minY = lab2.findMinY(actualYValues);
        assertEquals(minY, -0.06689484864237705);
    }

    @Test
    void testFindMaxYOrdinal() {
        double leftBound = 1;
        double rightBound = 5;
        double step = 0.01;
        double[] xValues = lab2.calculateXValues(leftBound, rightBound, step);
        double[] actualYValues = lab2.calculateYValues(xValues);
        double maxY = lab2.findMaxY(actualYValues);
        int maxYOrdinal = lab2.findElementOrdinal(actualYValues, maxY);
        assertEquals(maxYOrdinal, 400);
    }

    @Test
    void testFindMinYOrdinal() {
        double leftBound = 1;
        double rightBound = 5;
        double step = 0.01;
        double[] xValues = lab2.calculateXValues(leftBound, rightBound, step);
        double[] actualYValues = lab2.calculateYValues(xValues);
        double minY = lab2.findMinY(actualYValues);
        int minYOrdinal = lab2.findElementOrdinal(actualYValues, minY);
        assertEquals(minYOrdinal, 0);
    }

    @Test
    void testSumY() {
        double leftBound = 1;
        double rightBound = 5;
        double step = 0.01;
        double[] xValues = lab2.calculateXValues(leftBound, rightBound, step);
        double[] actualYValues = lab2.calculateYValues(xValues);
        double sumY = lab2.sum(actualYValues);
        assertEquals(sumY, 1107.9785875414868);
    }

    @Test
    void testAverageY() {
        double leftBound = 1;
        double rightBound = 5;
        double step = 0.01;
        double[] xValues = lab2.calculateXValues(leftBound, rightBound, step);
        double[] actualYValues = lab2.calculateYValues(xValues);
        double sumY = lab2.sum(actualYValues);
        double average = sumY / actualYValues.length;
        assertEquals(average, 2.7630388716745307);
    }
}