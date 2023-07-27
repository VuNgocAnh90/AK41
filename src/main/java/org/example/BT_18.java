package org.example;

import java.util.Arrays;

public class BT_18 {

    public static int[] addArrayWith1(int[] arrA) {

        int firstNum = arrA[0];

        boolean flag = false;
        if (firstNum == 0) {
            flag = true;
        }
        for(int i:arrA){
            if (i >=10 || i <0){
                throw new IllegalArgumentException(("invalid array"));
            }
        }

        String toStr = Arrays.toString(arrA).replaceAll("\\[|\\]|,|\\s", "");

        int toInt = Integer.parseInt(toStr) + 1;

        String toStr2 = Integer.toString(toInt);

        if (flag == true && toStr2.length() == String.valueOf(Integer.parseInt(toStr)).length()) {
            toStr2 = 0 + toStr2;
        }

        String[] toStrArr = toStr2.split("");

        int[] arrB = new int[toStrArr.length];
        for (int i = 0; i < toStrArr.length; i++) {
            arrB[i] = Integer.parseInt(toStrArr[i]);
        }
        //System.out.println(Arrays.toString(arrB));

        return arrB;
    }
}

