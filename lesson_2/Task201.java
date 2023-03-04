package lesson_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Task201 {
    public static void main(String[] args) {
        int stap = menuUser();
        String res = readToString();
        String[][] resArr = stringToArray(res);
        String search = searchInf(resArr, stap);
        print(search);

    }
    private static int getNumb() {
        Scanner get = new Scanner(System.in);
        try{
            System.out.println("Введите число параметра: 1 - name, 2 - country, 3 - city, 4 - age, 5 - all base");
            int numb = get.nextInt();
            return numb - 1;
        } catch (Exception ex){
            System.out.println("Вы не ввели число");
        } finally {
            get.close();
        }
        return 0;
    }
    //метод взаимодействия с пользователем
    private static int menuUser() {
        int a = getNumb();
        String name = "name";
        String country = "country";
        String city = "city";
        String age = "age";
        int result = 0;
        if(a == 0){
            System.out.printf("select * from students where %s: ", name);
            result = a;
        } else if(a == 1){
            System.out.printf("select * from students where %s: ", country);
            result = a;
        } else if(a == 2){
            System.out.printf("select * from students where %s: ", city);
            result = a;
        } else if(a == 3){
            System.out.printf("select * from students where %s: ", age); 
            result = a;
        } else if(a == 4){
            System.out.printf("select * from students");
            System.out.println();
            result = a;
        }
        return result;
        
    }
    //Считывание из файла и освобождение от лишних подстрок
    private static String readToString() {
        StringBuilder raw = new StringBuilder();
        String temp;
        try(BufferedReader rw = new BufferedReader(new FileReader("file_201.txt"))){
            while ((temp = rw.readLine()) != null) {
                raw.append(temp);
            }
       } catch (IOException e){
            System.out.println(e.getMessage());
       }
       String remove = "{";
       String str = raw.toString();
       for (char c : remove.toCharArray()) {
            str = str.replace(String.valueOf(c), "");
       }

       return str;
    }
    //Преобразование строки в массив
    private static String[][] stringToArray(String input) {
        String[] tempArr = input.split("}");
        String[][] doubleArr = new String[3][0];
        String[] temp;
        for (int i = 0; i < tempArr.length; i++) {
            temp = tempArr[i].split(",");
            doubleArr[i] = temp;
        }
        return doubleArr;
    }
    //Поисковик по заданным параметрам
    private static String searchInf(String[][] arr, int a) {
        StringBuilder res = new StringBuilder();
        if(a >= 0 && a <= 3){
            for (int i = 0; i < arr.length; i++) {
                if(arr[i][a].contains("null")){
                    continue;
                } else {
                    res.append(arr[i][a]);
                }
            }
        } else if(a == 4){
            String res1 = readToString();
            String[] arr1 = res1.split("}");
            for (String string : arr1) {
                System.out.println(string);
            }
        }
            
        return res.toString();
    }
    //Печать
    private static void print(String res) {
        System.out.println(res);
    }
}