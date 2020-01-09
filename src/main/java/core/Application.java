package core;
import field.Field;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру Пятняшки!");
        System.out.println("Вам нужно расставить цифры в порядке возрастания.");
        System.out.println("Удачи!");
        Field field = new Field();
        while (!field.finish()) {// игра идет, пока не сработает финиш

            field.printField();

            System.out.println("Введите цифру, которую хотите переместить на пустую ячейку: ");
            Scanner in = new Scanner(System.in);
            int number = in.nextInt();
            field.moving(number);
        }
        System.out.println("Вы победили!");//если закончился цикл, сообщаем о победе
    }
}