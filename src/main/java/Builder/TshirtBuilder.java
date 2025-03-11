package Builder;

public class TshirtBuilder {
    private Tshirt tshirt = new Tshirt();

    public TshirtBuilder setMaterial(String material) {
        if (material == null || material.isEmpty()) {
            tshirt.setMaterial(material);
        }
        tshirt.setMaterial(material);
        return this;
    }
    public TshirtBuilder setSize(String size) {
        if (size == null || size.isEmpty()) {
            tshirt.setSize(size);
        }
        tshirt.setSize(size);
        return this;
    }

    public TshirtBuilder setColor(String color) {
        if (color == null || color.isEmpty()) {
            tshirt.setColor(color);
        }
        tshirt.setColor(color);
        return this;
    }
    public Tshirt build() {
        if (tshirt.getMaterial() == null || tshirt.getMaterial().isEmpty()) {
            throw new IllegalStateException("Tshirt must have a material");
        }
        if (tshirt.getSize() == null || tshirt.getSize().isEmpty()) {
            throw new IllegalStateException("Tshirt must have a size");
        }
        if (tshirt.getColor() == null || tshirt.getColor().isEmpty()) {
            throw new IllegalStateException("Tshirt must have a color");
        }
        return tshirt;

    }




}
