package shoppingList.console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppingList.domain.Product;
import shoppingList.service.Service;
import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class ChangeProductAction implements Action {
    private final Service service;

    @Autowired
    public ChangeProductAction(Service service){
        this.service = service;
    }
    final int min=1;
    final int max=2;
    @Override
    public void execute (){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Enter product id to change it: ");
        Long id = scanner.nextLong();
        Product product = service.findProductById(id);
        product.setId(id);

        System.out.println("Enter product name: ");
        String name = scanner2.nextLine();
        product.setName(name);

        System.out.println("Enter product price: ");

        BigDecimal price = new BigDecimal(scanner1.nextLine());
        product.setPrice(price);

        System.out.println("If you want to enter category, press 1, if you don`t want to enter category, press 2.");
        Integer userInput1 = Integer.parseInt(scanner4.nextLine());
        if (userInput1 == min) {
            System.out.println("Enter product category: ");
            String category = scanner4.nextLine();
            product.setCategory(category);
        }
        while (userInput1 != min && userInput1 != max) {
            System.out.println("You entered incorrect value. " +
                    "If you want to enter category, press 1, if you don`t want to enter category, press 2.");
            userInput1 = Integer.parseInt(scanner4.nextLine());
            if (userInput1 == min) {
                System.out.println("Enter product category: ");
                String category = scanner4.nextLine();
                product.setCategory(category);
            }
        }

        System.out.println("Enter product percents: ");
        BigDecimal percent = new BigDecimal(scanner2.nextLine());
        product.setPercent(percent);
    }
    @Override
    public String toString(){
        return "Change product";
    }
}
