package lesson_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


class Task203 {
    public static void main(String[] args) {
        
        String str = readFrom();
        String[][] arr = stringtoArray(str);
        String result = readInput(arr);
        print(result);

    }
    //Считывание из файла
    private static String readFrom() {
        StringBuilder raw = new StringBuilder();
        String temp;
        try(BufferedReader rf = new BufferedReader(new InputStreamReader(new FileInputStream(new File("file203.txt")), "UTF-8"))){
            while ((temp = rf.readLine()) != null) {
                raw.append(temp);
            }
            rf.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        String result = raw.toString();
        String charsToRemove = "[]{";
        for (char c : charsToRemove.toCharArray()) {
            result = result.replace(String.valueOf(c), "");
        }
        return result;
    }
    //Преобразование в массив и освобождение от лишних подстрок
    private static String[][] stringtoArray(String str) {
        String[] arr = str.split("},");
        String[][] res = new String[arr.length][0];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i].split(",");
        }
        String[] a = new String[] {"фамилия", "оценка", "предмет", "}", ":", "\"\""}; 
        String tempStr;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                for (int k = 0; k < a.length; k++) {
                    tempStr = res[i][j];
                    tempStr = stringClear(tempStr, a[k]);
                    res[i][j] = tempStr;
                }
            }
                
        }
        return res;
    }
    //метод убирающий лишнее из строк
    private static String stringClear(String str, String target) {
        str = str.replaceAll(target, "");
        return str;
    }
    //Формирование новой строки
    private static String readInput(String[][] array) {
        StringBuilder mes = new StringBuilder();
        String temp;
        for (int i = 0; i < array.length; i++){
            temp = "Студент " + array[i][0] + " получил " + array[i][1] + " по предмету " + array[i][2] + ".";
            mes.append(temp + "\n");
        }
        
        return mes.toString();
    }

    private static void print(String a) {
        System.out.println(a); 
    }
}