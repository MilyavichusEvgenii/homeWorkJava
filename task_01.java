
import java.util.InputMismatchException;
import java.util.Scanner;


public class task_01 {
    
    public static void main(String[] args) {
        int numb = GetNumb();
        String[] arr = InitArr(numb);
        String[] resArr = MathMethod(arr);
        PrintArr(resArr);


    }
    //Ввод числа
    public static int GetNumb() {
        Scanner get = new Scanner(System.in);
        System.out.println("Введите число: "); 
        try{
            int a = get.nextInt();
            get.close();
            return a;
        
        } catch(InputMismatchException ex) {
            get.close();
            System.out.println("Вы не ввели число");
        }
        return 0;
    }
    //Инициализация массива
    public static String[] InitArr(int a) { 
        String[] temp = new String[a];
        return temp;
    }
    //Заполнение массива
    public static String[] MathMethod(String[] arr) {
        String buffer = "";
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                buffer = buffer + (i + 1);
                arr[i] = buffer;
            } else {
                buffer = buffer + "+" + (i + 1);
                arr[i] = buffer;
            }
                
        }
        return arr;
    }
    //Печать массива
    public static void PrintArr(String[] arr) {
        for (String i : arr) {
            System.out.println(i);
        }
        
    }
}
