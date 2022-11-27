import service.Block;
import service.impl.Wall;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        List<Block> blockList = new ArrayList<>();
        blockList.add(new Wall("Black", "Brick"));
        blockList.add(new Wall("White1", "Brick6"));
        blockList.add(new Wall("Red", "Brick"));
        blockList.add(new Wall("Red", "Brick6"));
        blockList.add(new Wall("White", "Brick3"));

        Wall wall = new Wall(blockList);
        //wall.findBlockByColor("Red");
        //System.out.println(wall.findBlockByColor("White"));
        //wall.showBlocks();
        System.out.println(wall.findBlocksByMaterial("Brick6"));
    }
}
