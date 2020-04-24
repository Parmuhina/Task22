package shoppingList;
import shoppingList.configuration.ApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;
import shoppingList.console.ConsoleUI;

public class ShoppingList {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        ConsoleUI consoleUI = context.getBean(ConsoleUI.class);
        consoleUI.startConsoleUI();
    }
}