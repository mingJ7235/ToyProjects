package CalculatorMachine;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        CalFunctions cf = new CalFunctions();
        Scanner sc = new Scanner(System.in);
        boolean loopCheck = true;
        int choice = 0;

        while (loopCheck) {
            System.out.println("계산기 머신입니다. 하고 싶은 계산을 선택해주세요 \n" +
                    "1. 덧셈 \n" +
                    "2. 뺄셈 \n" +
                    "3. 곱셈\n" +
                    "4. 나눗셈\n" +
                    "5. 계산기 나가기\n");

            choice = Integer.parseInt(sc.next());
            switch (choice) {
                case 1 :
                    cf.add();
                    break;
                case 2:
                    cf.minus();
                    break;
                case 3:
                    cf.multi();
                    break;
                case 4:
                    cf.divide();
                    break;

                case 5 :
                    System.out.println("계산기를 종료합니다. ");
                    loopCheck = false;
                    break;
            }
        }

    }
}
