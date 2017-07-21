package task_06;

import java.util.ArrayList;
import java.util.Random;

/*
* Ввести 100 чисел через рандом от 0 до 1000
* Ввести в отдельном методе
* Сделать сортировку Вставкой Insertion Sort
* Покрыть Unit тестами*/
public class InsertionSort {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = createArrayList();
        arrayList.forEach(o -> System.out.print(o + " "));
        System.out.println();
        insertIntoSort(arrayList);
        arrayList.forEach(o -> System.out.print(o + " "));
    }

    private static ArrayList<Integer> createArrayList(){
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(random.nextInt(1001));
        }
        return arrayList;
    }
    private static void insertIntoSort(ArrayList<Integer> arrayList) {
        int temp;
        int j;
        for(int i = 0; i < arrayList.size() - 1; i++){
            if (arrayList.get(i) > arrayList.get(i + 1)) {
                temp = arrayList.get(i + 1);
                arrayList.set(i + 1, arrayList.get(i));
                j = i;
                while (j > 0 && temp < arrayList.get(j - 1)) {
                    arrayList.set(j, arrayList.get(j-1));
                    j--;
                }
                arrayList.set(j,temp);
            }
        }
    }
}
