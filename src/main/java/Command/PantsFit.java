package Command;

import Builder.Pants;
import Builder.Product;

public class PantsFit implements Command {
    private String fit;

    public PantsFit(String fit) {
        this.fit = fit;
    }

    @Override
    public void execute(Product product) {
        if (product instanceof Pants){
            Pants pants = (Pants)product;
            pants.setFit(fit);
        }
    }

    @Override
    public String toString() {
        return fit + " Fit";
    }
}
