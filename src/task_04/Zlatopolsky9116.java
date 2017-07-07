package task_04;

public class Zlatopolsky9116 {
    public static void main(String[] args) {
        String input = "А РОЗА УПАЛА НА ЛАПУ АЗОРА";
        System.out.println(isPalindrom(input));

    }

    public static boolean isPalindrom(String input) {
        char[] sChars = input.replace(" ", "").toCharArray();
        for (int i = 0; i < sChars.length/2 + 1; i++) {
            if (sChars[i] != sChars[sChars.length - i - 1]) return false;
        }
        return true;
    }
}
