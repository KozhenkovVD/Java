package homeworks.homework07Addition;

import homeworks.homework07Addition.person.Adult;
import homeworks.homework07Addition.person.Pensioner;
import homeworks.homework07Addition.person.Person;
import homeworks.homework07Addition.product.DiscountProduct;
import homeworks.homework07Addition.product.Product;
import homeworks.homework07Addition.person.Child;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//СЕКЦИЯ ВВОДА ПОКУПАТЕЛЕЙ

        System.out.println("Введите покупателей");
        String strPerson = scanner.nextLine();
        String [] arrayPerson =  strPerson.split(";");
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < arrayPerson.length; i++) {
            String name = arrayPerson[i].substring(0,arrayPerson[i].indexOf("=")).trim();
            Double balance = Double.parseDouble(arrayPerson[i].substring(arrayPerson[i].indexOf("=")+1, arrayPerson[i].indexOf(",")).trim());
            Integer age = Integer.parseInt(arrayPerson[i].substring(arrayPerson[i].indexOf(",")+1).trim());


            if (age <= 17) {
                persons.add(new Child(name, balance, age));
            } else if (age > 17 & age < 65) {
                persons.add(new Adult(name, balance, age, 0.00));
            } else {
                persons.add(new Pensioner(name, balance, age));
            }
        };

        for (Person i : persons) {
            System.out.println(i);
        }



 //СЕКЦИЯ ВВОДА ПРОДУКТОВ

        System.out.println("Введите продукты. Для окончания ввода укажите \"END\"");
        String strProduct = "";
        List<Product> products = new ArrayList<Product>();
        while (!strProduct.equals("END")) {
            strProduct = scanner.nextLine();
            if (strProduct.equals("END")) {
                break;
            };
            String[] arrayStrProduct = strProduct.split("[;]");
            for (int i = 0; i < arrayStrProduct.length; i++) {
                String name = arrayStrProduct[i].substring(0, arrayStrProduct[i].indexOf("=")).trim();
                String priceStr = arrayStrProduct[i].substring(arrayStrProduct[i].indexOf("=") + 1).trim();
                Boolean isDiscountProduct = false;
                Float price;
                Integer discount = 0;

                if (priceStr.contains("%") == true) {
                    isDiscountProduct = true;
                    price = Float.valueOf(priceStr.substring(0, priceStr.indexOf(",")).trim());
                    discount = Integer.valueOf(priceStr.substring(priceStr.indexOf(",") + 1,priceStr.indexOf("%")).trim());
                } else {
                    price = Float.parseFloat(priceStr);
                }

                if (name.isEmpty() || name.length() < 3 || name.matches("\\d+")) {
                    System.out.println("Недопустимое имя продукта!");
                } else if (price <= 0) {
                    System.out.println("Недопустимая стоимость продукта!");
                } else if (isDiscountProduct == false) {
                    products.add(new Product(name, price));
                } else {
                    products.add(new DiscountProduct(name, price, discount, LocalDate.of(2025, 01, 30)));
                }
            }
        }
        StringJoiner str1 = new StringJoiner(", ");
        StringJoiner str2 = new StringJoiner(", ");
        for (Product i : products) {
            if (i instanceof DiscountProduct) {
                str2.add(i.getName());
            } else {
                str1.add(i.getName());
            }


        }
        System.out.println("Обыные продукты: " + str1);
        System.out.println("Акционные продукты: " + str2);

//СЕКЦИЯ ВВОДА ПОКУПОК

        System.out.println("Введите кто и что покупает (формат ввода: Имя - Продукт)?");
        String buy = "";
        while (!buy.equals("END")) {

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



    }
}


