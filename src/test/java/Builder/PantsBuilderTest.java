package Builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PantsBuilderTest {

    @Test
    void testPantsBuild() {
        Pants pants = new PantsBuilder()
                .setMaterial("Denim")
                .setSize("M")
                .setColor("Black")
                .build();

        assertEquals("Denim", pants.getMaterial());
        assertEquals("M", pants.getSize());
        assertEquals("Black", pants.getColor());
    }

    @Test
    void testSetMaterial() {
        PantsBuilder builder = new PantsBuilder()
                .setMaterial("Cotton")
                .setSize("M")
                .setColor("Black");
        assertEquals("Cotton", builder.build().getMaterial());
    }

    @Test
    void testSetSize() {
        PantsBuilder builder = new PantsBuilder()
                .setMaterial("Denim")
                .setSize("M")
                .setColor("Black");

        assertEquals("M", builder.build().getSize());
    }

    @Test
    void testSetColor() {
        PantsBuilder builder = new PantsBuilder()
                .setMaterial("Denim")
                .setSize("M")
                .setColor("Black");

        assertEquals("Black", builder.build().getColor());
    }


    @Test
    void testSetMaterialIsNullOrEmpty() {
        PantsBuilder builder = new PantsBuilder();
        assertThrows(IllegalArgumentException.class, () -> builder.setMaterial(null));
        assertThrows(IllegalArgumentException.class, () -> builder.setMaterial(""));
    }

    @Test
    void testSetSizeIsNullOrEmpty() {
        PantsBuilder builder = new PantsBuilder();
        assertThrows(IllegalArgumentException.class, () -> builder.setSize(null));
        assertThrows(IllegalArgumentException.class, () -> builder.setSize(""));
    }

    @Test
    void testSetColorIsNullOrEmpty() {
        PantsBuilder builder = new PantsBuilder();
        assertThrows(IllegalArgumentException.class, () -> builder.setColor(null));
        assertThrows(IllegalArgumentException.class, () -> builder.setColor(""));
    }

    @Test
    void testBuildWithoutSizeThrowsException() {
        PantsBuilder builder = new PantsBuilder()
                .setMaterial("Denim")
                .setColor("Black");

        assertThrows(IllegalStateException.class, builder::build);
    }
    @Test
    void testBuildWithoutMaterialThrowsException() {
        PantsBuilder builder = new PantsBuilder()
                .setSize("M")
                .setColor("Black");

        assertThrows(IllegalStateException.class, builder::build);
    }

    @Test
    void testBuildWithoutColorThrowsException() {
        PantsBuilder builder = new PantsBuilder()
                .setMaterial("Denim")
                .setSize("M");

        assertThrows(IllegalStateException.class, builder::build);
    }

    @Test
    void testBuildWithoutMaterialSizeAndColorThrowsException() {
        PantsBuilder builder = new PantsBuilder();

        assertThrows(IllegalStateException.class, builder::build);
    }

}