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
        int maxYOrdinal = lab2.findMaxElementOrdinal(actualYValues);
        double maxY = actualYValues[maxYOrdinal];
        assertEquals(maxY, 8.062257748298551);
    }

    @Test
    void testFindMinY() {
        double leftBound = 1;
        double rightBound = 5;
        double step = 0.01;
        double[] xValues = lab2.calculateXValues(leftBound, rightBound, step);
        double[] actualYValues = lab2.calculateYValues(xValues);
        int minYOrdinal = lab2.findMinElementOrdinal(actualYValues);
        double minY = actualYValues[minYOrdinal];
        assertEquals(minY, -1.1991405194805642);
    }

    @Test
    void testFindMaxYOrdinal() {
        double leftBound = 1;
        double rightBound = 5;
        double step = 0.01;
        double[] xValues = lab2.calculateXValues(leftBound, rightBound, step);
        double[] actualYValues = lab2.calculateYValues(xValues);
        int maxYOrdinal = lab2.findMaxElementOrdinal(actualYValues);
        assertEquals(maxYOrdinal, 400);
    }

    @Test
    void testFindMinYOrdinal() {
        double leftBound = 1;
        double rightBound = 5;
        double step = 0.01;
        double[] xValues = lab2.calculateXValues(leftBound, rightBound, step);
        double[] actualYValues = lab2.calculateYValues(xValues);
        int minYOrdinal = lab2.findMinElementOrdinal(actualYValues);
        assertEquals(minYOrdinal, 140);
    }

    @Test
    void testSumY() {
        double leftBound = 1;
        double rightBound = 5;
        double step = 0.01;
        double[] xValues = lab2.calculateXValues(leftBound, rightBound, step);
        double[] actualYValues = lab2.calculateYValues(xValues);
        double sumY = lab2.sum(actualYValues);
        assertEquals(sumY, 1106.7767174281307);
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
        assertEquals(average, 2.7600416893469593);
    }
}