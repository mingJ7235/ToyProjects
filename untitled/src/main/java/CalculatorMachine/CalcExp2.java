package CalculatorMachine;

import java.util.*;

public class CalcExp2 {
    public static void main(String[] args) {
        int cnt = 0, cnt_op = 0, i ;
        List<String> scumNums = new ArrayList<>();
        List<String> op = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String pre_equation = "";
        String arrNum = "0123456789";
        String arrOper = "+-*/";

        //사용자에게 공백 분리 요청말고 할수있는 방법 찾아보기
        //두번처리해야함. 우선 사용자에게 받은 데이터를 공백없이 하나 가공하고
        //다시 이 데이터를 " " 을 주어서 나중에 토큰으로 잘라야함. -> 공백을 내가 주는 건데, 이것에 대한 로직이필요함
        System.out.println("수식을 입력해주세요 (ex : 1 * 3 - 2");

        String pre_exp = sc.nextLine();

        for (i = 0; i < pre_exp.length(); i ++) {
            if(pre_exp.charAt(i) == ' ') {

            } else {
                pre_equation += pre_exp.charAt(i);
            }

            System.out.println("입력하신 수식 '" + pre_equation +"'을 계산합니다.");
        }

        for (i = 0; i < pre_equation.length(); i ++) {
            //자른 숫자를 넣을 String변수
            String scumNum = "";
            for (int j = 0; j < arrNum.length(); j ++) {
                //숫자 검사 (반복 돌려서 숫자 배열에 하나라도 일치할 경우)
                if (pre_equation.charAt(i) == arrNum.charAt(j)) {
                    if (pre_equation.charAt(i+1) == arrNum.charAt(j)){
                        scumNum += pre_equation.charAt(i);
                    }else {
                        //pre_equation 다음 문자가 숫자가 아닌경우
                    }
                    scumNum += " "; //공백 추가 (나중의 구분점)
                    scumNums.add(scumNum); //문자 하나 넣기
                }
            }

            for (int j = 0; j < arrOper.length(); j ++) {
                if(pre_equation.charAt(i) == arrOper.charAt(j)) {
                    //oper 인경우
                }
            }
        }


        StringTokenizer st = new StringTokenizer(pre_exp, " ");


    }

}
