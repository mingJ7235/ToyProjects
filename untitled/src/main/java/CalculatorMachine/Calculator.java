package CalculatorMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        MathCal mc = new MathCal();
        Scanner sc = new Scanner(System.in);
        int choice = 0;


        while (true) {
            System.out.println("계산기 머신입니다. 하고 싶은 계산을 선택해주세요" +
                    "1. 덧셈 \n" +
                    "2. 뺄셈 \n" +
                    "3. 곱셈\n" +
                    "4. 나눗셈\n" +
                    "5. 계산기 나가기\n");

            choice = Integer.parseInt(sc.next());

            switch (choice) {
                case 1 :
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

                    } else {
                        addArray.add(num1);

                    }
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;
            }





            //덧셈 위한 어레이리스트


        }

    }
}
