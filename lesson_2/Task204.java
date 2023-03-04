package lesson_2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task204 {
    public static void main(String[] args) throws SecurityException, IOException {
        Logger logger = Logger.getLogger(Task204.class.getName());
        FileHandler fh = new FileHandler("log204.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.log(Level.WARNING, "Логирование 1");
        logger.info("Логирование 2");
        mathMethod();
       

    }
    private static void mathMethod() {
        Scanner get = new Scanner(System.in);
        System.out.println("Введите первое значение: ");
        double a = get.nextDouble();
        System.out.println("Введите второе значение: ");
        double b = get.nextDouble();
        System.out.println("Введите математическую операцию: +, -, *, " + "/");
        char c = get.next().charAt(0);
        get.close();
        double result = 0;
        if (c == '+'){
            result = a + b;
        }else if(c == '-'){
            result = a - b;
        }else if(c == '*'){
            result = a * b; 
        }else if(c == '/'){
            result = a / b;
        }
        System.out.printf("равняетс %f", result);
    }
    
    
}