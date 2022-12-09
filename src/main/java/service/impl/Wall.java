package service.impl;

import exceptions.NotFoundException;
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

    public void addBlock(Block block) {
        blocks.add(block);
    }

    //zwraca dowolny element o podanym kolorze
    @Override
    public Optional<Block> findBlockByColor(String color) {
        Optional<Block> blockOptional = blocks.stream()
                .filter(c -> color.equals(c.getColor()))
                .findFirst();
        if (blockOptional.isPresent()) {
            return blockOptional;
        } else {
            try {
                throw new NotFoundException("Color not found!");
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //zwraca wszystkie elementy z danego materiału
    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .filter(block -> material.equals(block.getMaterial()))
                .collect(Collectors.toList());
    }

    //zwraca liczbę wszystkich elementów tworzących strukturę
    @Override
    public int count() {
        return (int) blocks.stream().count();
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
