
import service.impl.SomeBlock;
import service.impl.SomeCompositeBlock;
import service.impl.Wall;


public class MainApp {

    public static void main(String[] args) {

        Wall wall = new Wall();

        SomeBlock someBlock1 = new SomeBlock("Black", "Brick1");
        SomeBlock someBlock2 = new SomeBlock("White", "Brick2");
        SomeBlock someBlock3 = new SomeBlock("Blue", "Brick3");

        SomeCompositeBlock compositeBlock1 = new SomeCompositeBlock("Red", "Brick4");
        SomeCompositeBlock compositeBlock2 = new SomeCompositeBlock("Green", "Brick5");
        SomeCompositeBlock compositeBlock3 = new SomeCompositeBlock("Red", "Brick4");
        compositeBlock1.addCompositeBlock(someBlock1);
        compositeBlock2.addCompositeBlock(someBlock2);
        compositeBlock1.addCompositeBlock(compositeBlock2);

        wall.addBlock(someBlock3);
        wall.addBlock(someBlock1);
        //wall.addBlock(compositeBlock1);

        //System.out.println(wall);
        System.out.println(compositeBlock1);
        //System.out.println(compositeBlock2);
       // System.out.println(compositeBlock3);

        System.out.println(wall.count());
        System.out.println(compositeBlock1.getBlocks().size());

        // wall.addBlock(List.of(compositeBlock, someBlock1, someBlock2, someBlock3));


    }
}
