package CalculatorMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class CalFunctions {
    MathCal mc = new MathCal();
    Scanner sc = new Scanner(System.in);


    public void add () {

        ArrayList<Double> addArray = new ArrayList<>();
        System.out.println("덧셈입니다.\n" +
                "최소 2가지의 숫자를 순서대로 적어주세요");
        System.out.print("첫번째 숫자 :");
        Double num1 = Double.parseDouble(sc.next());
        System.out.print("두번째 숫자 :");
        double num2 = Double.parseDouble(sc.next());

        System.out.println("연산을 계속 하실 건가요? (y/n)");
        String answerLoop = "";
        answerLoop = sc.next();
        if (answerLoop.equals("y") || answerLoop.equals("Y")) {
            System.out.println("몇개의 숫자를 더 연산 할 건가요?");
            int addNum = Integer.parseInt(sc.next());
            System.out.println(addNum + "개의 숫자를 차례대로 입력해주세요");
            Double num3 = 0.0;
            for (int i = 0 ; i < addNum ; i ++) {
                System.out.println((i + 3) + "번째 숫자 : ");
                num3 += Double.parseDouble(sc.next());
            }
            addArray.add(num1);
            addArray.add(num2);
            addArray.add(num3);
            System.out.println("계산결과 : " + mc.add(addArray));

        } else {
            addArray.add(num1);
            addArray.add(num2);
            System.out.println("계산결과 : " + mc.add(addArray));
        }
    }

    public void minus () {
        ArrayList<Double> minusArray = new ArrayList<>();
        System.out.println("뺄셈입니다.\n" +
                "최소 2가지의 숫자를 순서대로 적어주세요");
        System.out.print("첫번째 숫자 :");
        Double num1 = Double.parseDouble(sc.next());
        System.out.print("두번째 숫자 :");
        double num2 = Double.parseDouble(sc.next());

        System.out.println("연산을 계속 하실 건가요? (y/n)");
        String answerLoop = "";
        answerLoop = sc.next();
        if (answerLoop.equals("y") || answerLoop.equals("Y")) {
            System.out.println("몇개의 숫자를 더 연산 할 건가요?");
            int addNum = Integer.parseInt(sc.next());
            System.out.println(addNum + "개의 숫자를 차례대로 입력해주세요");
            Double num3 = 0.0;
            for (int i = 0 ; i < addNum ; i ++) {
                System.out.println((i + 3) + "번째 숫자 : ");
                num3 += Double.parseDouble(sc.next());
            }
            minusArray.add(num1);
            minusArray.add(num2);
            minusArray.add(num3);
            System.out.println("계산결과 : " + mc.minus(minusArray));

        } else {
            minusArray.add(num1);
            minusArray.add(num2);
            System.out.println("계산결과 : " + mc.minus(minusArray));
        }
    }

    public void multi () {
        ArrayList<Double> multiArray = new ArrayList<>();
        System.out.println("곱셈입니다.\n" +
                "최소 2가지의 숫자를 순서대로 적어주세요");
        System.out.print("첫번째 숫자 :");
        Double num1 = Double.parseDouble(sc.next());
        System.out.print("두번째 숫자 :");
        double num2 = Double.parseDouble(sc.next());

        System.out.println("연산을 계속 하실 건가요? (y/n)");
        String answerLoop = "";
        answerLoop = sc.next();
        if (answerLoop.equals("y") || answerLoop.equals("Y")) {
            System.out.println("몇개의 숫자를 더 연산 할 건가요?");
            int addNum = Integer.parseInt(sc.next());
            System.out.println(addNum + "개의 숫자를 차례대로 입력해주세요");
            Double num3 = 0.0;
            for (int i = 0 ; i < addNum ; i ++) {
                System.out.println((i + 3) + "번째 숫자 : ");
                num3 += Double.parseDouble(sc.next());
            }
            multiArray.add(num1);
            multiArray.add(num2);
            multiArray.add(num3);
            System.out.println("계산결과 : " + mc.multi(multiArray));

        } else {
            multiArray.add(num1);
            multiArray.add(num2);
            System.out.println("계산결과 : " + mc.multi(multiArray));
        }
    }

    public void divide () {
        System.out.println("나눗셈입니다. (나눗셈은 2개의 숫자 연산만 제공됩니다)\n" +
                "최소 2가지의 숫자를 순서대로 적어주세요");
        System.out.print("첫번째 숫자 :");
        Double num1 = Double.parseDouble(sc.next());
        System.out.print("두번째 숫자 :");
        double num2 = Double.parseDouble(sc.next());

        System.out.println("계산결과 : " + mc.divide(num1, num2));

    }
}
