package CalculatorMachine;

import java.util.ArrayList;
import java.util.List;

public class MathCal {


    //계산할때 변수가 2개이상인 경우 -> 배열로 받아서 넣어보기 ?
    public Double add (List<Double> typeDoubleArr) {
        Double result = 0.0;

        for (int i = 0 ; i < typeDoubleArr.size() ; i++) {
            result += typeDoubleArr.get(i);
        }

        return result;
    }

    public Double minus (List<Double> typeDoubleArr) {
        Double result = 0.0;

        for (int i = 0; i < typeDoubleArr.size() ; i++) {

            result -= typeDoubleArr.get(i);
        }

        return result;

    }

    public Double multi (List<Double> typeDoubleArr) {
        Double result = 0.0;

        for (int i = 0; i < typeDoubleArr.size() ; i++) {
            result *= typeDoubleArr.get(i);
        }

        return result;
    }

    public String devide (Double num1, Double num2) {
        String result = "";

        if (num2 != 0) {
            result = num1 / num2  + "";
        } else {
            result = "0으로 나눌수 없습니다.";
        }

        return result;
    }






}
