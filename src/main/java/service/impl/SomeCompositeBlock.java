package service.impl;

import service.Block;
import service.CompositeBlock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class SomeCompositeBlock extends SomeBlock implements CompositeBlock {

    private List<Block> blockList = new ArrayList<>();

    public SomeCompositeBlock(String color, String material) {
        super(color, material);
    }
//    public SomeCompositeBlock(List<Block> blockList) {
//        super(color, material);
//        this.blockList = blockList;
//    }

    @Override
    public Stream<Block> toStream() {
        return Stream.concat(super.toStream(),
                blockList.stream().flatMap(block -> block.toStream()));
    }

    public void addCompositeBlock(Block block){
        blockList.add(block);
    }

    @Override
    public List<Block> getBlocks() {
        //return new ArrayList<>(blockList);
        return Collections.unmodifiableList(blockList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeCompositeBlock that = (SomeCompositeBlock) o;
        return Objects.equals(blockList, that.blockList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), blockList);
    }

    @Override
    public String toString() {
        return "SomeCompositeBlock{" +
                "blockList=" + blockList +
                '}';
    }
}
