package CalculatorMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class CalcExp2 {
    public static void main(String[] args) {
        int cnt = 0, cnt_op = 0, i ;
        List<Integer> v = new ArrayList<>();
        List<String> op = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        //사용자에게 공백 분리 요청말고 할수있는 방법 찾아보기
        //두번처리해야함. 우선 사용자에게 받은 데이터를 공백없이 하나 가공하고
        //다시 이 데이터를 " " 을 주어서 나중에 토큰으로 잘라야함. -> 공백을 내가 주는 건데, 이것에 대한 로직이필요함
        System.out.println("수식을 입력해주세요 (단, 숫자와 연산자는 공백으로 분리해주세요");

    }

}
