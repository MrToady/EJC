package task_04.zlatopolsky_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(main.getOddLetters(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    private boolean isPalindrome(String checkedString) {
        char[] checkedStringChars = checkedString.replace(" ", "").toCharArray();
        for (int i = 0; i < checkedStringChars.length / 2 + 1; i++) {
            if (checkedStringChars[i] != checkedStringChars[checkedStringChars.length - i - 1]) return false;
        }
        return true;
    }
}