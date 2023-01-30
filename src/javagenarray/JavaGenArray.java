package javagenarray;

import java.util.Arrays;

import static java.lang.Math.random;

/**
 * @author Andrey Tynyanyi
 * @version 1.0
 */

public class JavaGenArray {

    static final int K = 150; //Ограничивающий диапазон
    static final int N = 100; //количество элементов в массиве

    static int[] numArray = new int[N];

    public static void main(String[] args) {
        generatorArray(); // 1) генерируем массив
        System.out.println("Простых чисел в массиве: " + countSimple());
        System.out.println("Кратных трем в массиве: " + multipleOfThree());
        viewArray();
        Arrays.sort(numArray);
        viewArray();
    }

    /**
     * Заполняет массив
     * сгенерированными целыми числами
     */
    private static void generatorArray(){
        for(int i=0; i<N; i++) numArray[i] = getRandom();
    }

    /**
     * Генерирует целое число
     * в диапазоне [0;K]
     * @return int
     */
    private static int getRandom(){
        int a = 0;
        return a + (int) (random() * K);
    }

    /**
     * Проверка является ли число простым
     * @param num int
     * @return boolean
     */
    private static boolean testNum(int num){
        if( num > 1){
            for (int i = 2; i < num; i++){
                if(num % i == 0) return false;
            }
            return true;
        }
        return false;
    }

    /**
     * Подсчет количества элементов кратных трем
     * @return int
     */
    private static int multipleOfThree(){
        int qnt = 0;
        for(int i = 0; i < N; i++){
            if(numArray[i] % 3 == 0){
                qnt++;
            }
        }
        return qnt;
    }

    /**
     * Подсчет количества простых чисел
     * @return int
     */
    private static int countSimple(){
        int  qnt = 0;
        for(int i=0; i<N; i++){
            if(testNum(numArray[i])) qnt++;
        }
        return qnt;
    }

    /**
     * Вывод массива на экран
     */
    private static void viewArray(){
        for(int i=0; i<N; i++){
            if(i == N-1){
                System.out.println(numArray[i]);
            }else {
                System.out.print(numArray[i] + ", ");
            }
        }
    }
}
