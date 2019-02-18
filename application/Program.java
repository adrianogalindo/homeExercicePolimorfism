package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List <Product> list = new ArrayList<>();

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++){
            System.out.printf("Product #%d data:", i);
            System.out.print("Common, used or imported (c/u/i)? ");
            sc.nextLine();
            char ch = sc.nextLine().charAt(0);
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            if (ch == 'i') {
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customsFee));
            }
            else if (ch == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date date = sdf.parse(sc.next());
                list.add(new UsedProduct(name, price, date));
            }
            else if (ch == 'c') {
                list.add(new Product(name, price));
            }
        }

        System.out.println();
        System.out.println("PRICES TAGS:");
        for (Product prod : list) {
            System.out.println(prod.priceTag());
        }

        sc.close();
    }
}
