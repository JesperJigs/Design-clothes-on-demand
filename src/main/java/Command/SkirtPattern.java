package Command;

import Builder.Product;
import Builder.Skirt;

public class SkirtPattern implements Command {


    private String pattern;

    public SkirtPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public void execute(Product product) {
        if (product instanceof Skirt){
            Skirt skirt = (Skirt) product;
            skirt.setPattern(pattern);
        }

    }

    @Override
    public String toString() {
       return pattern + " Pattern";
    }
}
