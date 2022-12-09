package service.impl;

import exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import service.Block;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    private static final SomeBlock someBlock1 = new SomeBlock("Black", "Brick1");
    private static final SomeBlock someBlock2 = new SomeBlock("White", "Brick2");
    private static final SomeBlock someBlock3 = new SomeBlock("Blue", "Brick3");

    private static final SomeCompositeBlock compositeBlock1 = new SomeCompositeBlock("Red", "Brick4");
    private static final SomeCompositeBlock compositeBlock2 = new SomeCompositeBlock("Green", "Brick5");
    private static final SomeCompositeBlock compositeBlock3 = new SomeCompositeBlock("Red", "Brick4");

    private Wall wall = new Wall();

    @Test
    void shouldReturnCorrectBlockByColor() throws NotFoundException {
        //given
        wall.addBlock(someBlock1);
        wall.addBlock(someBlock2);
        wall.addBlock(someBlock3);
        //when
        Optional<Block> coloredBlock = wall.findBlockByColor("Black");
        //then
        assertTrue(coloredBlock.isPresent());
    }

    @Test
    void shouldReturnCorrectBlockByMaterial() {
        //given
        wall.addBlock(someBlock1);
        wall.addBlock(someBlock2);
        wall.addBlock(someBlock1);
        //when
        List<Block> materialBlock = wall.findBlocksByMaterial("Brick1");
        //then
        assertThat(materialBlock).hasSize(2);
    }

    @Test
    void shouldReturnCorrectCount(){
        //given
        wall.addBlock(someBlock1);
        wall.addBlock(someBlock2);
        //when
        int count = wall.count();
        //then
        assertThat(count).isEqualTo(2);
    }
}