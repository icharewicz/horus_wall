package service.impl;

import service.Block;
import service.CompositeBlock;
import service.Structure;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure, CompositeBlock {

    private List<Block> blocks;
    private String color;
    private String material;
    private CompositeBlock compositeBlock;

    @Override
    public List<Block> getBlocks() {
        return compositeBlock.getBlocks();
    }

    //konstruktor Wall z blocks
    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    public Wall(String color, String material) {
        this.color = color;
        this.material = material;
    }

    public void showBlocks() {
        for (Block b : blocks) {
            System.out.println(b);
        }
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    //zwraca dowolny element o podanym kolorze
    @Override
    public Optional<Block> findBlockByColor(String color) {
        Optional<Block> blockOptional = blocks.stream()
                .filter(c -> c.getColor().equals(color))
                .findFirst();
        return blockOptional;
    }

    //zwraca wszystkie elementy z danego materiału
    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .filter(block -> block.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    //zwraca liczbę wszystkich elementów tworzących strukturę
    @Override
    public int count() {
        return 0;
    }

    @Override
    public String toString() {
        return "Wall: " +
                "color: " + color +
                ", material: " + material;
    }
}
