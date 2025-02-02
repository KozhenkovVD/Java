package homeworks.homework10;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        int[] Array1 = Sequence.filter(new int[]{5, 2, 8}, number-> number % 2 == 0);
        System.out.println(Arrays.toString(Array1));

        int[] Array2 = Sequence.filter(new int[]{53, 22, 85}, number -> {
            String[] str = String.valueOf(number).split("");
            Integer sum = 0;
            for (String i : str) {
                sum = sum + Integer.valueOf(i);
            }
            return sum % 2 == 0;
                });
        System.out.println(Arrays.toString(Array2));

    }
}
