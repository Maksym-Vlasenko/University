package com.maksim.lab1;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.*;

public class Lab1 {
    public static void main(String[] args) {
        calculate();
        printDateInOldFormat();
        printDateInNewFormat();
    }

    private static void printDateInNewFormat() {
        System.out.println("---------------------");
        System.out.println("New format");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.getDefault());
        LocalDateTime now = LocalDateTime.now();
        System.out.println(formatter.format(now));
    }

    private static void printDateInOldFormat() {
        System.out.println("---------------------");
        System.out.println("Old format");
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
        Date now = new Date();
        System.out.println(formatter.format(now));
    }

    /*private static void printDateInOldFormat() {
        System.out.printf("%1$td %1$tB %1$tY", new Date());
    }*/

    private static void calculate() {
        System.out.print("Пожалуйста, введите цифру a: ");
        float a = readNumber();
        System.out.print("Пожалуйста, введите цифру b: ");
        float b = readNumber();
        System.out.print("Пожалуйста, введите цифру t: ");
        float t = readNumber();
        double y = pow(E, -(b * t)) * sin(a * t + b) - sqrt(abs(b * t + a));
        double s = b * sin(a * pow(t, 2) * cos(2 * t)) - 1;
        print(a, b, t, y, s);
    }

    private static float readNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextFloat();
    }

    private static void print(float a, float b, float t, double y, double s) {
        System.out.printf("a = %.2f%nb = %.2f%nt = %.2f%ny = %.2f%ns = %.2f%n", a, b, t, y, s);
    }
}