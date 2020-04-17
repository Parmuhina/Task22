import console.ConsoleUI;
import org.springframework.beans.factory.annotation.Autowired;

public class ShoppingList {
@Autowired
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.execute();
    }
}