package Command;

import Builder.Product;
import Builder.Tshirt;

public class TshirtSleeve implements Command {
    private String sleeve;

    public TshirtSleeve(String sleeve) {
        this.sleeve = sleeve;
    }


    @Override
    public void execute(Product product) {
        if (product instanceof Tshirt) {
            Tshirt tshirt = (Tshirt) product;
            tshirt.setSleeves(sleeve);


        }

    }

    @Override
    public String toString() {
        return sleeve + "Sleeve";
    }
}
