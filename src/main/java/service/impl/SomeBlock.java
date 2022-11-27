package service.impl;

import service.Block;

import java.util.Objects;
import java.util.stream.Stream;

public class SomeBlock implements Block {

    private String color;
    private String material;

    public SomeBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public Stream<Block> toStream() {
        return Stream.of(this);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "SomeBlock: " +
                "color: " + color +
                ", material: " + material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeBlock someBlock = (SomeBlock) o;
        return Objects.equals(color, someBlock.color) && Objects.equals(material, someBlock.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, material);
    }
}
