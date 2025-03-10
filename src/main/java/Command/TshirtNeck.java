package Command;

import Builder.Product;
import Builder.Tshirt;

public class TshirtNeck implements Command {
    private String neck;

    public TshirtNeck(String neck) {
        this.neck = neck;
    }

    @Override
    public void execute(Product product) {
        if (product instanceof Tshirt){
            Tshirt tshirt = (Tshirt) product;
            tshirt.setNeck(neck);
        }

    }

    @Override
    public String toString() {
        return neck + "Neck";
    }
}
