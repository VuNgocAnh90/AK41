package org.example;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.json.JsonOutput;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {

        StartWar person1 = new StartWar("Luke Skywalker", 172,77,
                    "blond", "white","yellow","41.9BBY","male");
        StartWar person2 = new StartWar("Darth Vader", 202,136,
                    "none", "fair","blue","19BBY","male");
        StartWar person3 = new StartWar("Leia Organa", 150,49,
                    "brown", "light","brown","19BBY","female");
        StartWar person4 = new StartWar("Owen Lars", 178,120,
                    "brown, grey", "light","blue","52BBY","male");
        StartWar person5 = new StartWar("Beru Whitesun lars", 165,75,
                    "brown", "light","blue","47BBY","female");
        StartWar person6 = new StartWar("Biggs Darklighter", 183,84,
                    "black", "light","brown","24BBY","male");
        StartWar person7 = new StartWar("Obi-Wan Kenobi", 182,77,
                "auburn, white", "fair","blue-gray","57BBY","male");


        //Convert Json to Object use Array list
        List<StartWar> characters = Arrays.asList(person1,person2,person3,person4,person5,person6,person7);
            characters.forEach(StartWar::info);

        /**
         * TODO:find person that has mass >100
         */
        List<StartWar> personHasMassGreater100 = characters
                .stream()
                .filter(person -> person.getMass()>100)
                .collect(Collectors.toList());

        personHasMassGreater100.forEach(StartWar::info);

        /**
         * total mass of characters
         */
        Integer totalMass = characters
                .stream()
                .mapToInt(StartWar::getMass)
                .sum();

        System.out.println("Total Mass: " + totalMass);

//        /**
//         * otal height of characters
//         */
//        Integer totalHeight = characters
//                .stream()
//                .mapToInt(StartWar::getHeight)
//                .sum();
//
//        System.out.println("Total Height: " + totalHeight);

        //use reduce
        Integer heightSum = characters
                .stream()
                .reduce(0,(height,person)->height+person.getHeight(),Integer::sum);

        System.out.printf("total height %d\n",heightSum);

        /**
         *get list name of person
         */
        List<String> name = characters
                .stream()
                .map(StartWar::getName)
                .collect(Collectors.toList());

        System.out.printf("name %s\n", name);

        /**
         * find max mass person
         */

        StartWar maxMassPerson = characters
                .stream()
                .max(Comparator.comparingInt(StartWar::getMass))
                .get();

        maxMassPerson.info();

        /**
         * find smallest person
         */

        StartWar heightSmallestPerson = characters
                .stream()
                .min(Comparator.comparingInt(StartWar::getHeight))
                .get();

        heightSmallestPerson.info();

        /**
         * sort by name
         */

        List<StartWar> sortName = characters
                .stream()
                .sorted(Comparator.comparing(StartWar::getName).reversed())
                .collect(Collectors.toList());

        sortName.forEach(StartWar::info);

        /**
         * sort by mass
         */

        List<StartWar> maxMass = characters
                .stream()
                .sorted(Comparator.comparingInt(StartWar::getMass).reversed())
                .collect(Collectors.toList());

        maxMass.forEach(StartWar::info);


    };



    };

//    public static void main(String[] args) {
//        //Viet chuong trinh kiem tra so nguyen nhp vao co phai la so chan ko?
//        int n =-5;
//        if(n <=0){
//            throw new IllegalArgumentException(n + "n phai lon hon 0");
//        }
//        if(n%2==0){
//            System.out.println(n + "so chan");
//        }else{
//            System.out.println(n + "so le");
//        }
//    }
//
//    public static void main(String[] args) {
//        //check chu nhap vao co phai la nguyen am ko?
//        //nguyen am: ueaoi
//        //chu hoa va thuong
//        //check do dai cua ky tu
//
//        String letter = "aa";
//        String nguyenAm = "ueoai";
//        if (letter.length() != 1){
//            throw new IllegalArgumentException(letter + " phai la 1 ky tu");
//        }
//        if (nguyenAm.contains(letter.toLowerCase())){
//            System.out.println(letter +  " la nguyen am");
//        }else {
//            System.out.println(letter + " la phu am");
//        }
//    }
//
//    public static void main(String[] args) {
//        //viet ham check co phai nam nhuan hay ko?
//        //Nam nhuan la nam chia het cho 4 va ko chia het cho 100
//        //Nam nhuan cung chia het chia het cho 400
//
//        int year = 401;
//        kiemTraNamNhuan(year);
//        kiemTraNamNhuan(2023);
//        kiemTraNamNhuan(2024);
//
//    }
//    public static boolean kiemTraNamNhuan(int year){
//        if ((year%4 == 0) && (year % 100 !=0) || (year % 400 == 0)){
//            System.out.println(year + " nam nhuan");
//            return true;
//        }else {
//            System.out.println(year + " ko phai nam nhuan");
//            return false;
//        }
//    }
//
//    public static void main(String[] args) {
//        //Tim phan tu lon nhat o 1 mang so nguyen cho truoc [1,8,3,7-9,10]
//
//        int[] arr = new int[] {1,8,3,7,-9};
//        int max = arr[0];
//        for (int i = 1; i<arr.length; i++){
//            if(arr[i]>max){
//                max = arr[i];
//            }
//        }
//        System.out.println(max);
//    }


//        Fruit apple = new Fruit("Apple", "red");
//        Fruit mango = new Fruit("Mango", "yellow");
//        Fruit banana = new Fruit("Banana", "green");
//
//        ArrayList<Fruit> cart = new ArrayList<>();
//        cart.add(apple);
//        cart.add(mango);
//        cart.add(banana);
//
//        cart.stream().forEach(Fruit::info);

//    }
//        //Cho môt mảng số nguyên int[] A, Viết một chương trình xuất ra mảng B = A + 1
//        //ví dụ: A = {1,3,2,4} ==> B = {1,3,2,5} A = {9,9,9} ==> B = {1,0,0,0}
//        //==> "1324" ==> int 1324 +1 ==> String ==> String[] ==> int[]
//
//        int[] arrA = {0, 9, 9, 9 };
//        System.out.println("Initialize A array: " + Arrays.toString(arrA));
//
//        int firstNum = arrA[0];
//        System.out.println("Value of first element: " + firstNum);
//
//        boolean flag = false;
//        if (firstNum == 0) {
//            flag = true;
//        }
//
//        String toStr = Arrays.toString(arrA).replaceAll("\\[|\\]|,|\\s", "");
//        System.out.println("Convert A array to string: " + toStr);
//
//        Integer toInt = Integer.parseInt(toStr) + 1;
//
//        System.out.println("Convert string to int number and increase: " + toInt);
//
//        String toStr2 = Integer.toString(toInt);
//        System.out.println("Convert number to string: " + toStr2);
//
//        if (flag == true && toStr2.length() == String.valueOf(Integer.parseInt(toStr)).length()) {
//            toStr2 = 0 + toStr2;
//        }
//
//        String[] strArray = toStr2.split("");
//        System.out.println("Convert string to string array: " + Arrays.toString(strArray));
//
//        int[] arrB = new int[strArray.length];
//        for (int i = 0; i < strArray.length; i++) {
//            arrB[i] = Integer.parseInt(strArray[i]);
//        }
//        System.out.println("Initialize B array with length of string array\n" +
//                "Loop string array for convert to Int\n" +
//                "And add elements to B array\n" +
//                Arrays.toString(arrB));
//
//
//
//    }

//}

