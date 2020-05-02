package shoppingList.console;

import java.util.List;
import java.util.Scanner;


public class ConsoleUI {
    private final List<Action> actions;

    public ConsoleUI( List<Action> actions) {
        this.actions = actions;
    }

    public void startConsoleUI() {

                Scanner scanner = new Scanner(System.in);
                int response = 0;

                while (response >= 0) {
                    printMenu();
                    try {
                        response = scanner.nextInt();
                        actions.get(response).execute();

                    } catch (Exception e) {
                        System.out.println("Incorrect choice. Please insert number less than 5.");
                        e.printStackTrace();

                    }
                }
    }
        private void printMenu() {
            for (int i = 0; i < actions.size(); i++) {
                System.out.println(i + ". " + actions.get(i));
            }
        }
    }


