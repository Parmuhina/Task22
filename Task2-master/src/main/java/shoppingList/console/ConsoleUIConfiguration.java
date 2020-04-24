package shoppingList.console;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConsoleUIConfiguration {
    private final Action createProductAction;
    private final Action findProductIdAction;
    private final Action changeProductAction;
    private final Action deleteProductAction;
    private final Action exitAction;

    public ConsoleUIConfiguration (Action createProductAction,
                                   Action findProductIdAction,
                                   Action changeProductAction,
                                   Action deleteProductAction,
                                   Action exitAction){

        this.createProductAction = createProductAction;
        this.findProductIdAction = findProductIdAction;
        this.changeProductAction = changeProductAction;
        this.deleteProductAction = deleteProductAction;
        this.exitAction= exitAction;
    }

    @Bean
    public List<Action> actions(){
        List<Action> actions = new ArrayList<>();
        actions.add(createProductAction);
        actions.add(findProductIdAction);
        actions.add(changeProductAction);
        actions.add(deleteProductAction);
        actions.add(exitAction);
        return actions;
    }
}
