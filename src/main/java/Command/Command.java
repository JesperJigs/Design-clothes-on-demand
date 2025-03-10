package Command;

import Builder.Product;

public interface Command {
    void execute(Product product);
}
