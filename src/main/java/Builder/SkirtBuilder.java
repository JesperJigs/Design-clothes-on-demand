package Builder;

public class SkirtBuilder {
    private Skirt skirt = new Skirt();

    public SkirtBuilder setMaterial(String material) {
        if (material == null || material.isEmpty()) {
            throw new IllegalArgumentException("Material is missing");
        }
        skirt.setMaterial(material);
        return this;
    }

    public SkirtBuilder setColor(String color) {
        if (color == null || color.isEmpty()) {
            throw new IllegalArgumentException("Color is missing");
        }
        skirt.setColor(color);
        return this;
    }

    public SkirtBuilder setSize(String size) {
        if (size == null || size.isEmpty()) {
            throw new IllegalArgumentException("Size is missing");
        }
        skirt.setSize(size);
        return this;
    }
    public Skirt build() {
        return skirt;
    }
}
