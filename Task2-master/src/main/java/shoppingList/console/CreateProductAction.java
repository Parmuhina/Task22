package shoppingList.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppingList.domain.Product;
import shoppingList.service.Service;
import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class CreateProductAction implements Action {
    private final Service service;
    final int minLength=3;
    final int maxLength=32;
    final int minPricePercent=0;
    final int min=1;
    final int max=2;
    @Autowired
    public CreateProductAction(Service service){
        this.service = service;
    }

    @Override
    public  void execute () {
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        product.setName(name);

       while ((product.getName().length() < minLength) || (product.getName().length() > maxLength)) {

            System.out.println("Name need to be more than 2 and less than 33 symbols." +
                    "Enter new name.");

            if ((product.getName().length() < minLength) || (product.getName().length() > maxLength)) {
                name = scanner.nextLine();
                product.setName(name);
            }
        }

        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        product.setPrice(price);

       BigDecimal bigDecimalNull = new BigDecimal("0");
        while (product.getPrice().compareTo(bigDecimalNull) <= minPricePercent) {
            System.out.println("Price need to be more than 0.");
            if (product.getPrice().compareTo(bigDecimalNull) <= minPricePercent) {
                price = new BigDecimal(scanner.nextLine());
                product.setPrice(price);
            }
        }
        System.out.println("If you want to enter category, press 1, if you don`t want to enter category, press 2.");
        Integer userInput1 = Integer.valueOf(scanner.nextLine());
        if (userInput1 == min) {
            System.out.println("Enter product category: ");
            String category = scanner.nextLine();
            product.setCategory(category);
        }

        while (userInput1 != min && userInput1 != max) {
            System.out.println("You entered incorrect value. " +
                    "If you want to enter category, press 1, if you don`t want to enter category, press 2.");
            userInput1 = Integer.valueOf(scanner.nextLine());
            if (userInput1 == min) {
                System.out.println("Enter product category: ");
                String category = scanner.nextLine();
                product.setCategory(category);
            }
        }
        System.out.println("Enter product percents: ");
        BigDecimal percent = new BigDecimal(scanner.nextLine());
        product.setPercent(percent);

        BigDecimal bigDecimalThousand = new BigDecimal("100");
        while (product.getPercent().compareTo(bigDecimalNull) < minPricePercent ||
                product.getPercent().compareTo(bigDecimalThousand) > minPricePercent) {
            System.out.println("Percents need to be more than 0 and less than 100 percents.");
            if (product.getPercent().compareTo(bigDecimalNull) < minPricePercent ||
                    product.getPercent().compareTo(bigDecimalThousand) > minPricePercent) {
                percent = new BigDecimal(scanner.nextLine());
                product.setPercent(percent);
            }
        }

        Long id = service.createProduct(product);
        System.out.println("Result: " + id);
    }
    @Override
    public String toString(){
        return "Create Product";
    }
}
