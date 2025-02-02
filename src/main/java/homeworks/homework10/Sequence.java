package homeworks.homework10;

import java.util.ArrayList;
import java.util.List;

public class Sequence {
    public static int[] filter(int[] array, ByCondition condition) {
        int[] resultArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (condition.isOk(array[i])) {
                resultArray[i] = array[i];
            }
        }
        return resultArray;
    }
}