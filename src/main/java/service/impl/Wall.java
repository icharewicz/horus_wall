package service.impl;

import service.Block;
import service.CompositeBlock;
import service.Structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure {

    private List<Block> blocks = new ArrayList<>();

//    public List<Block> getBlocks() {
//        return blocks;
//    }

//    public void showBlocks() {
//        for (Wall w : blocks) {
//            System.out.println(b);
//        }
//    }

    public void addBlock(Block block){
        blocks.add(block);
    }

    //zwraca dowolny element o podanym kolorze
    @Override
    public Optional<Block> findBlockByColor(String color) {
        Optional<Block> blockOptional = blocks.stream()
//                .filter(b -> b instanceof SomeCompositeBlock)
//                .flatMap(b -> ((SomeCompositeBlock)b).getBlocks().stream())
                .flatMap(b -> b.toStream())
                .filter(c -> color.equals(c.getColor()))
                .findFirst();
        if (blockOptional.isPresent()){
            return blockOptional;
        }
        return blocks.stream()
                .filter(c -> color.equals(c.getColor())).findFirst();
    }

    //zwraca wszystkie elementy z danego materiału
    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .flatMap(b -> b.toStream())
                .filter(block -> material.equals(block.getMaterial()))
                .collect(Collectors.toList());
    }

    //zwraca liczbę wszystkich elementów tworzących strukturę
    @Override
    public int count() {
        return (int) blocks.stream().flatMap(b -> b.toStream()).count();
    }

    @Override
    public String toString() {
        return "Wall: " +
                "blocks: " + blocks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wall wall = (Wall) o;
        return Objects.equals(blocks, wall.blocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blocks);
    }
}
