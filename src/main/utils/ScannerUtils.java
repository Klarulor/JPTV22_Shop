package main.utils;

import java.util.Scanner;

public class ScannerUtils {
    private static Scanner sc = new Scanner(System.in);
    public static boolean booleanInput(String text){
        System.out.print(text);
        return sc.next().equals("y");
    }

    public static String stringInput(String text){
        System.out.print(text);
        String inputText = sc.next();
        return inputText;
    }
    public static int integerInput(String text){
        System.out.print(text);
        int num = sc.nextInt();
        return num;
    }
}
