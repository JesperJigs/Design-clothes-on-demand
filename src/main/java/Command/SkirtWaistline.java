package Command;

import Builder.Product;
import Builder.Skirt;

public class SkirtWaistline implements Command{
    private String waistline;

    public SkirtWaistline(String waistline) {
        this.waistline = waistline;
    }



    @Override
    public void execute(Product product) {
        if (product instanceof Skirt){
            Skirt skirt = (Skirt) product;
            skirt.setWaistline(waistline);
        }

    }

    @Override
    public String toString() {
        return waistline + " Waistline";
    }
}
