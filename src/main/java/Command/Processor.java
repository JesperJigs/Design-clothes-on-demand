package Command;

import Builder.Product;

import java.util.ArrayList;
import java.util.List;

public class Processor {
    private List<Command> commands = new ArrayList<>();

    public void add(Command command) {
        commands.add(command);

    }
    public void process(Product product) {
        for (Command command : commands) {
            command.execute(product);
            System.out.println(product.getClass().getSimpleName() + " updated to " + command);

        }
    }

    public void clear() {
        commands.clear();
    }
}
