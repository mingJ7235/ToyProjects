package CalculatorMachine;

import java.util.Scanner;

public class Calculator_oper {
    public static void main(String[] args) {
        boolean loopCheck = true;
        Scanner sc = new Scanner(System.in);
        String oper = "";
        while (loopCheck) {
            System.out.println("계산기 입니다.\n" +
                    "1번째 숫자 : ");
            double num1 = Double.parseDouble(sc.next());
            System.out.println("연산자 : (+, -, *, /)");
            oper = sc.next();
            System.out.println("2번째 숫자 : ");
            double num2 = Double.parseDouble(sc.next());

            System.out.println("연산을 계속 하시겠습니까? (y/n)");
            String calCheck = sc.next();

            if(calCheck.equals("y") || calCheck.equals("Y")) {
                while (loopCheck) {

                }
            }
        }
    }


}
