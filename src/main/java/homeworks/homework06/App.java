package homeworks.homework06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите покупателей");
        String strPerson = scanner.nextLine();
        String [] arrayPerson =  strPerson.split(";");
        ArrayList<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < arrayPerson.length; i++) {
            String name = arrayPerson[i].substring(0,arrayPerson[i].indexOf("=")).trim();
            float balance = Float.parseFloat(arrayPerson[i].substring(arrayPerson[i].indexOf("=")+1).trim());
            persons.add(new Person(name, balance));

        };


        System.out.println("Введите продукты");
        String strProduct = scanner.nextLine();
        String [] arrayStrProduct =  strProduct.split(";");
        ArrayList<Product> products = new ArrayList<Product>();
        for (int i = 0; i < arrayStrProduct.length; i++) {
            String name = arrayStrProduct[i].substring(0,arrayStrProduct[i].indexOf("=")).trim();
            float price = Float.parseFloat((arrayStrProduct[i].substring(arrayStrProduct[i].indexOf("=")+1).trim()));
            products.add(new Product(name, price));
        };
        System.out.println("Введите кто и что покупает (формат ввода: Имя - Продукт)?");
        String buy = "";
        while (buy!="END") {

            buy = scanner.nextLine();
            if (buy.equals("END")) {
                break;
            };
            String name = buy.substring(0,buy.indexOf("-")).trim();
            String productname = buy.substring(buy.indexOf("-")+1).trim();

            Person bayer = null;
            Product product = null;

//Определяем покупателя
            for (int i = 0; i < persons.size(); i++ ) {
                 if (persons.get(i).getName().equals(name)) {
                     bayer = persons.get(i);
                 }
            }
//Определяем продукт
            for (int i = 0; i < products.size(); i++ ) {
                if (products.get(i).getName().equals(productname)) {
                    product = products.get(i);
                }
            }
//Добавляем в корзину
            bayer.addProductToBasket(product);

        }

        for (int i = 0; i < persons.size(); i++ ) {
            System.out.println(persons.get(i).getProductFromBasket());
        }
        //persons.get(0).getProductFromBasket();

    }
}


