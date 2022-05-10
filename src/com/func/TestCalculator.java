package com.func;

public class TestCalculator {

    public static void main(String[] args) {

        CalculatorInterface calculatoradd = (a, b) -> a + b;
        CalculatorInterface calculatorsub = (a, b) -> a - b;
        CalculatorInterface calculatormul = (a, b) -> a * b;
        CalculatorInterface calculatordiv = (a, b) -> a / b;

        CalculatorInterface calculatorInterface = new CalculatorInterfaceImpl();
        System.out.println("calculatorInterface : " + calculatorInterface.test("s", "ad"));

        System.out.println("calculatoradd : " + calculatordiv.test("s", "ad"));
        System.out.println("calculatorsub : " + CalculatorInterface.stat());
        System.out.println("calculatormul : " + calculatormul.calculate(10, 2));
        System.out.println("calculatordiv : " + calculatordiv.calculate(10, 2));

    }

}
