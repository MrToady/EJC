package task_04.zlatopolsky_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//          Task 9.43 test
            System.out.println(main.getOddLetters(reader));
//          Task 9.153 test
            System.out.println(main.maxSequenceOfIdenticalSymbols(reader));
//          Task 9.154 test
            System.out.println(main.identicalLettersCounter(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
//      Task 9.116 test
        System.out.println(main.isPalindrome("АРГЕНТИНА МАНИТ НЕГРА"));
        System.out.println(main.isPalindrome("ПОТ КАК ПОТОП"));
        System.out.println(main.isPalindrome("А РОЗА УПАЛА НА ЛАПУ АЗОРА"));
    }

    /*Задача 9.43
    * Дано слово s1. Получить слово s2, образованное нечетными буквами слова s1.*/
    private String getOddLetters(BufferedReader reader) throws IOException {
        char[] inputStringChars = reader.readLine().toCharArray();
        StringBuilder oddLettersBuilder = new StringBuilder();
        for (int i = 0; i < inputStringChars.length; i += 2) {
            oddLettersBuilder.append(inputStringChars[i]);
        }
        return oddLettersBuilder.toString();
    }

    /*Задача 9.116
    * Проверить, является ли "перевертышем" (см. задачу 9.78) следующая
    * символьная строка после удаления из нее всех пробелов:
    *а) АРГЕНТИНА МАНИТ НЕГРА;
    *б) ПОТ КАК ПОТОП;
    *в) А РОЗА УПАЛА НА ЛАПУ АЗОРА.
    *Во всех задачах последние символы "_", полученные после удаления пробелов, не учитывать.*/
    private boolean isPalindrome(String testString) {
        char[] testStringChars = testString.replace(" ", "").toCharArray();
        for (int i = 0; i < testStringChars.length / 2 + 1; i++) {
            if (testStringChars[i] != testStringChars[testStringChars.length - i - 1]) return false;
        }
        return true;
    }

    /*Задача 9.153
    * Дан текст. Найти наибольшее количество идущих подряд одинаковых символов.*/
    private int maxSequenceOfIdenticalSymbols(BufferedReader reader) {
        String inputString;
        while (true) {
            try {
                inputString = reader.readLine();
                if (!inputString.matches("[A-z]*")) {
                    System.out.println("Wrong input");
                } else {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int maxSequence = 0;
        int countOfIdenticalSymbols = 0;
        for (int i = 0; i < inputString.length() - 1; i++) {
            if (inputString.toCharArray()[i] == inputString.toCharArray()[i + 1]) {
                countOfIdenticalSymbols++;
            } else {
                maxSequence = Math.max(countOfIdenticalSymbols + 1, maxSequence);
                countOfIdenticalSymbols = 0;
            }
        }
        maxSequence = Math.max(countOfIdenticalSymbols + 1, maxSequence);
        return maxSequence;
    }

    /*Задача 9.154
    * Дано слово. Определить сколько различных букв в нем.*/
    private int identicalLettersCounter(BufferedReader reader) {
        String inputString;
        while (true) {
            try {
                inputString = reader.readLine();
                if (!inputString.matches("[A-z]*")) {
                    System.out.println("Wrong input");
                } else {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Set<Character> charSet = new HashSet<>();
        for (Character character : inputString.toCharArray()) {
            charSet.add(character);
        }
        return charSet.size();
    }
}

