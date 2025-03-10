package Builder;

public class PantsBuilder {
    private Pants pants = new Pants();

    public PantsBuilder setMaterial(String material) {
        if (material == null || material.isEmpty()) {
            throw new IllegalArgumentException("Material is missing");
        }
        pants.setMaterial(material);
        return this;
    }

    public PantsBuilder setSize(String size) {
        if (size == null || size.isEmpty()) {
            throw new IllegalArgumentException("Size is missing");
        }
        pants.setSize(size);
        return this;
    }

    public PantsBuilder setColor(String color) {
        if (color == null || color.isEmpty()) {
            throw new IllegalArgumentException("Color is missing");
        }
        pants.setColor(color);
        return this;
    }

    public Pants build() {
        if (pants.getMaterial() == null || pants.getMaterial().isEmpty()) {
            throw new IllegalStateException("Pants must have a material");
        }
        if (pants.getSize() == null || pants.getSize().isEmpty()) {
            throw new IllegalStateException("Pants must have a size");
        }
        if (pants.getColor() == null || pants.getColor().isEmpty()) {
            throw new IllegalStateException("Pants must have a color");
        }
        return pants;
    }

}


