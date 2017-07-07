package task_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zlatopolsky943 {
    public static void main(String[] args) {

        String s1;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            s1 = reader.readLine();
            for (int i = 0; i < s1.toCharArray().length; i += 2) {
                System.out.print(s1.toCharArray()[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
