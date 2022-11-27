package service.impl;

import org.junit.jupiter.api.Test;
import service.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    @Test
    void shouldReturnCorrectBlockByColor() {
        //given
        List<Block> blockList = new ArrayList<>();
        blockList.add(new Wall("Black", "Brick"));
        blockList.add(new Wall("Red", "Brick"));
        blockList.add(new Wall("White", "Brick"));
        Wall wall = new Wall(blockList);
        Optional expectedResult = (new Wall("Red", "Brick").findBlockByColor("Red"));
        //when
        String color = "Red";
        Optional result = wall.findBlockByColor(color);
        //then
        assertEquals(expectedResult, result);
    }
}