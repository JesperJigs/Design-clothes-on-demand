package Command;

import Builder.Pants;
import Builder.Product;

public class PantsLength implements Command {
    private String length;

    public PantsLength(String length) {
        this.length = length;
    }

    @Override
    public void execute(Product product) {
        if (product instanceof Pants){
            Pants pants = (Pants) product;
            pants.setLength(length);
        }
    }
    @Override
    public String toString() {
        return length + " Length";
    }
}
