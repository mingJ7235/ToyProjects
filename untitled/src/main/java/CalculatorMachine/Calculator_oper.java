package CalculatorMachine;

import java.sql.SQLSyntaxErrorException;
import java.util.Scanner;

public class Calculator_oper {
    public static void main(String[] args) {
        boolean loopCheck = true;
        Scanner sc = new Scanner(System.in);
        String data = "";

        System.out.println("계산하고 싶은 수식을 자유롭게 써주세요 (ex> 4.5 * 13 + 23");
        String equation = sc.nextLine();

        for (int i = 0 ; i < equation.length(); i ++) {
            char letter = equation.charAt(i);
            if (letter == ' ') {

            } else {
                data += letter;
            }
        }
        System.out.println(data);
    }


}
