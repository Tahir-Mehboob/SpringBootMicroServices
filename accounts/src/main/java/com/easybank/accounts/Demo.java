package com.easybank.accounts;

public class Demo {

    public static void main(String[] args) {
        System.out.println("Hello !");
    }

    /**
     * @param a first number
     * @param b second number
     * @return the sum of a and b
     */
    public static int add(int a, int b) {
        System.out.println("sum : "+(a+b));
        return a + b;
    }

    /**
     * @param a first number
     * @param b second number
     * @return the difference of a and b
     */
    public static int subtract(int a, int b) {
        System.out.println("difference : "+(a-b));
        return a - b;
    }

    /**
     * @param a first number
     * @param b second number
     * @return the product of a and b
     */
    public static int multiply(int a, int b) {
        System.out.println("product : "+(a*b));
        return a * b;
    }

    /**
     * @param a first number
     * @param b second number
     * @return the division of a and b
     */
    public static double divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return (double) a / b;
    }

}
