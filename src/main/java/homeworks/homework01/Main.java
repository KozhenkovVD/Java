import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        System.out.println("1   2   3   4");

        System.out.println("0 - камень, 1 - ножницы, 2 - бумага");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Что показал Вася");
        int vasya = scanner.nextInt();

        System.out.println("Что показал Петя");
        int petya = scanner.nextInt();

        if (vasya == petya)
            {System.out.println("Ничья");}
        else if ((vasya == 0 && petya ==1) || (vasya == 1 && petya ==2) || (vasya == 2 && petya ==0))
            {System.out.println("Вася победил");}
        else
            {System.out.println("Петя победил");}

    }
}