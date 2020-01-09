package field;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Field {

    private int field[][] = new int[4][4];
    private final HashSet<Integer> check = new HashSet<Integer>();

    public HashSet<Integer> getCheck() {

        return check;
    }

    public int[][] getField() {

        return field;
    }

    public void setField(int[][] field) {

        this.field = field;
    }

    public Field(){

        random();
    }

    private void random(){
        int k;
        for(int i=0; i<field.length; i++)
            for(int j=0;j<field[0].length;j++){
                int random = (int)(Math.random()*(16)+1);// присваиваем рандомное число от 1 до 16
                while(check.contains(random)) random = (int)(Math.random()*(16)+1);//если такое число было, то ищем такое число,
                if(!check.contains(random)){                                       //которого нет в HashSet
                    field[i][j] = random;//добавляем это число в двумерный массив
                    check.add(random);//добавляем в HashSet число, которое только что добавили в массив, чтобы избежать повторений
                }
            }
    }

    public void moving(int number) {
        int in=-1,jn=-1,izero=-1,jzero=-1;
        for(int i=0; i<field.length; i++)
            for(int j=0; j<field[0].length; j++)
                if(field[i][j] == number){//ищем координаты числа, которые ввели в консоль
                    in=i;//присваиваем эти координаты
                    jn=j;
                }
        for(int i=0; i<field.length; i++)//ищем координаты пустой ячейки(цифры 16)
            for(int j=0; j<field[0].length; j++){
                if(field[i][j] == 16){
                    izero = i;//присваиваем эти координаты
                    jzero = j;
                }
            }
        if(in==izero && jn+1==jzero || in==izero && jn-1==jzero ||//если пустая ячейка находится находится над, под,
                in+1==izero && jn==jzero || in-1==izero && jn==jzero){   //слева или справа нашего числа, то можно менять их местами
            int num;
            num = field[izero][jzero];//ниже меняем местами
            field[izero][jzero] = field[in][jn];
            field[in][jn] = num;
            System.out.println("Успешно!");//говорим, что поменяли местами
        } else System.out.println("Вы не можете перемесить эту цифру! Вам мешают другие!");//если не получилось поменять,
    }                                                                                     //то сообщаем это в консоль

    public boolean finish(){
        //final ArrayList<Integer> check = new ArrayList<Integer>();
        // int result=1;//в Application идет игра, пока finish()=1
        int k=field[0][0];
        for(int i=0; i<field.length; i++)//добавляем в ArrayList все ячейки массива
            for(int j=0; j<field[0].length; j++) {
                //    check.add(field[i][j]);
                if(k<=field[i][j]){
                    k=field[i][j];
                } else return false;
            }
        return true;
        // int k=0;
        // for(int i=0;i<check.size()-1;i++)
        //   if(check.get(i) == check.get(i+1)-1) k++;//проверка на возрастание, таких успешных проверок должно быть 15,
        // if(k==15) result++;                     //так как у нас в массиве 16
        //return result;
    }
    public void printField(){
        for (int i = 0; i < field.length; i++) {//вывод массива на экран
            for (int j = 0; j < field[0].length; j++) {
                if(field[i][j] == 16) System.out.print(" " + "  " + " ");// массив 4 на 4, то есть число 16 - пустая ячейка
                else if(field[i][j]< 10) System.out.print(" "+field[i][j]+"  ");// для удобства, чтобы массив не сходил
                else System.out.print(" " + field[i][j] + " ");// просто выводим двухзначные числа
            }
            System.out.println();
        }
    }
}