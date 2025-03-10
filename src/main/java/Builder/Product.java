package Builder;

public abstract class Product {
    protected String material;
    protected String size;
    protected String color;
    protected String id;
    protected String name;

    public Product() {
    }

    public Product(String material, String size, String color, String id, String name) {
        this.material = material;
        this.size = size;
        this.color = color;
        this.id = id;
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract double getPrice();

    @Override
    public String toString() {
        return "Product{" +
                "material='" + material + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
