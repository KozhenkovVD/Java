package homeworks.homework13;
import homeworks.homework13.utils.Parser;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("src/main/java/homeworks/homework13/input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("src/main/java/homeworks/homework13/output.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Parser parser = new Parser();
            String[] arrayPerson = bufferedReader.readLine().split(";");
            List<Person> persons = new ArrayList<Person>();
            for (int i = 0; i < arrayPerson.length; i++) {
                String name = arrayPerson[i].substring(0, arrayPerson[i].indexOf("=")).trim();
                Double balance = parser.parseNumber(arrayPerson[i].substring(arrayPerson[i].indexOf("=") + 1).trim());
                persons.add(new Person(name, balance));
            }

            String[] arrayStrProduct = bufferedReader.readLine().split(";");
            List<Product> products = new ArrayList<Product>();
            for (int i = 0; i < arrayStrProduct.length; i++) {
                String name = arrayStrProduct[i].substring(0, arrayStrProduct[i].indexOf("=")).trim();
                Integer price = parser.parseCount((arrayStrProduct[i].substring(arrayStrProduct[i].indexOf("=") + 1).trim()));
                products.add(new Product(name, price));
            }

            while (bufferedReader.ready()) {
                String buy = bufferedReader.readLine();
                    if (buy.equals("END")) {
                        break;
                    } else {
                        String name = buy.substring(0, buy.indexOf("-")).trim();
                        String productname = buy.substring(buy.indexOf("-") + 1).trim();
                        Person bayer = null;
                        Product product = null;
                        for (Person p : persons) {
                            if (p.getName().equals(name)) {
                                bayer = p;
                            }
                        }
                        for (Product p : products) {
                            if (p.getName().equals(productname)) {
                                product = p;
                            }
                        }
                        bufferedWriter.write(bayer.addProductToBasket(product)+ "\n"); //+ "\r\n"
                    }
                }
            for (int i = 0; i < persons.size(); i++) {
                bufferedWriter.write(persons.get(i).getProductFromBasket() + "\n");
                bufferedWriter.flush();
            }
            fileReader.close();
            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}