package shoppingList.console;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleUI {
    private final List<Action> actions;

    @Autowired
    public ConsoleUI(@Qualifier("actions") List<Action> actions) {
        this.actions = actions;
    }

    public void startConsoleUI() {

        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                for (int i = 0; i < actions.size(); i++) {
                    System.out.println(i + ". " + actions.get(i));
                }
                int userInput = scanner.nextInt();
                actions.get(userInput).execute();
            } catch (Exception e) {
                System.out.println("Incorrect choice. Please insert number less than 5.");
                e.printStackTrace();

            }
        }
    }
}

