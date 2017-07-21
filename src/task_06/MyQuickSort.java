package task_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
* Создать коллекцию из чисел через бафф реадер
* ввести с клавиатуры 25 чисел
* Вывести коллекцию на экран без сортировки
* Сделать Quick Sort
* Вывести после сортировки
*
* Ввести 100 чисел через рандом от 0 до 1000
* Ввести в отдельном методе
* Сделать сортировку Вставкой Insertion Sort
*
* Покрыть Unit тестами
* */
public class MyQuickSort {
    public static void main(String[] args) {
        ArrayList<Integer> array = createNewCollection();
        array.forEach(o -> System.out.print(o + " "));
        System.out.println();
        quickSort(array, 0, array.size() - 1);
        array.forEach(o -> System.out.print(o + " "));
    }

    private static ArrayList<Integer> createNewCollection() {
        ArrayList<Integer> resultCollection = new ArrayList<>(25);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            while (resultCollection.size() < 25) {
                input = reader.readLine();
                if (input.matches("[-+]?\\d+")) {
                    resultCollection.add(Integer.parseInt(input));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultCollection;
    }

    public static void quickSort(ArrayList<Integer> arrayList, int low, int high) {
        if ((arrayList.size() == 0) || (arrayList == null)) {
            return;
        }
        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int i = low;
        int j = high;
        while (i <= j) {
            while (arrayList.get(i) < arrayList.get(middle)) {
                i++;
            }
            while (arrayList.get(middle) < arrayList.get(j)) {
                j--;
            }
            if (i <= j) {
                Collections.swap(arrayList, i, j);
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(arrayList, low, j);
        }
        if (high > i) {
            quickSort(arrayList, i, high);
        }
    }
}