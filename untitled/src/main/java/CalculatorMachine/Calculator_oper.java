package CalculatorMachine;

import java.util.Scanner;

public class Calculator_oper {
    public static void main(String[] args) {
        boolean loopCheck = true;
        Scanner sc = new Scanner(System.in);
        String user_data = "";

        System.out.println("계산하고 싶은 수식을 자유롭게 써주세요 (ex> 4.5 * 13 + 23");
        String equation = sc.nextLine();

        //사용자의 공식 정제 (띄어쓰기 없이 정제하기)
        for (int i = 0 ; i < equation.length(); i ++) {
            char letter = equation.charAt(i);
            if (letter == ' ') {

            } else {
                user_data += letter;
            }
        }

        System.out.println("요청하신 공식 '" + user_data + "'의 계산을 실시하겠습니다. 헤헤");

        //정제된 공식을 세분화 시킬것

        for (int i = 0; i < user_data.length();  i ++) {
            char letter = user_data.charAt(i);
            String compare_number = "1234567890";
            String compare_oper = "+-*/";
            // 1+2+3
            for (int j = 0; j < compare_number.length(); j ++) {
                //letter가 숫자인지 아닌지 검사
                if (letter == compare_number.charAt(j)){

                } else if (letter == compare_oper.charAt(j)) {
                    if (letter == user_data.charAt(0)) {
                        //수식의 첫 부분이 oper일경우
                        System.out.println("'" + user_data +"' 는 잘못된 수식입니다. 프로그램을 종료합니다.");
                        break;
                    }



                } else if (letter == '.'){
                    if (letter == user_data.charAt(0)) {
                        //수식의 첫 부분이 .일경우
                        System.out.println("'" + user_data +"' 는 잘못된 수식입니다. 프로그램을 종료합니다.");
                        break;
                    }

                } else {
                    System.out.println("'" + user_data +"' 는 잘못된 수식입니다. 프로그램을 종료합니다.");
                    break;
                }
            }
        }

    }


}
