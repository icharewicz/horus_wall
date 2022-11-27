package service;

import service.Block;

import java.util.List;

public interface CompositeBlock extends Block {

    List<Block> getBlocks();

}
