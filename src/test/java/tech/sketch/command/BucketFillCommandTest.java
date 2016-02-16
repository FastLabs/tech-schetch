package tech.sketch.command;


import org.junit.Test;
import tech.sketch.canvas.SketchCanvas;
import tech.sketch.canvas.utils.BufferedRendererAsserter;
import tech.sketch.canvas.utils.CanvasFactory;
import tech.sketch.shape.Rectangle;

import static org.junit.Assert.assertFalse;

public class BucketFillCommandTest {

    final String[] emptyCanvas = new String[]{
            "----------------------",
            "|                    |",
            "|                    |",
            "|                    |",
            "|                    |",
            "|                    |",
            "|                    |",
            "|                    |",
            "|                    |",
            "|                    |",
            "|                    |",
            "|                    |",
            "|                    |",
            "----------------------"
    };


    private final boolean showOnScreen = false;

    @Test
    public void notEnoughArguments() {
        final BucketFillCommand cmd = new BucketFillCommand(new String[]{"B", "0"});
        assertFalse("Not enough arguments", cmd.isValidCommand());
    }

    @Test
    public void testFullFill() {
        final SketchCanvas canvas = CanvasFactory.defaultCanvas();
        final BufferedRendererAsserter asserter = new BufferedRendererAsserter();
        asserter.render(canvas.printCanvas());
        if (showOnScreen) {
            System.out.println(canvas.printCanvas());
        }
        asserter.assertContent(emptyCanvas); // empty canvas

        final String[] expected = new String[]{
                "----------------------",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "----------------------"
        };

        BucketFillCommand cmd = new BucketFillCommand(new String[]{"B", "2", "2", "@"});
        cmd.execute(canvas, asserter);
        if (showOnScreen) {
            System.out.println(canvas.printCanvas());
        }
        asserter.assertContent(expected);
    }

    @Test
    public void testAreaFillIn() throws Exception{
        final SketchCanvas canvas = CanvasFactory.defaultCanvas();
        final BufferedRendererAsserter asserter = new BufferedRendererAsserter();
        asserter.render(canvas.printCanvas());
        asserter.assertContent(emptyCanvas); // empty canvas
        Rectangle r = new Rectangle(3, 3, 5, 5);
        canvas.draw(r);

        final String[] expect = new String[]{
                "----------------------",
                "|                    |",
                "|                    |",
                "|                    |",
                "|   ******           |",
                "|   *@@@@*           |",
                "|   *@@@@*           |",
                "|   *@@@@*           |",
                "|   *@@@@*           |",
                "|   ******           |",
                "|                    |",
                "|                    |",
                "|                    |",
                "----------------------"
        };

        final BucketFillCommand cmd = new BucketFillCommand(new String[]{"B", "4", "4", "@"});
        cmd.execute(canvas, asserter);
        asserter.assertContent(expect);
    }

    @Test
    public void testAreaFillOut() throws Exception{
        final SketchCanvas canvas = CanvasFactory.defaultCanvas();
        final BufferedRendererAsserter asserter = new BufferedRendererAsserter();
        asserter.render(canvas.printCanvas());
        asserter.assertContent(emptyCanvas); // empty canvas
        final Rectangle r = new Rectangle(3, 3, 5, 5);
        canvas.draw(r);
        final String[] expect = new String[]{
                "----------------------",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@******@@@@@@@@@@@|",
                "|@@@*    *@@@@@@@@@@@|",
                "|@@@*    *@@@@@@@@@@@|",
                "|@@@*    *@@@@@@@@@@@|",
                "|@@@*    *@@@@@@@@@@@|",
                "|@@@******@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "----------------------",};

        BucketFillCommand cmd = new BucketFillCommand(new String[]{"B", "2", "2", "@"});
        cmd.execute(canvas, asserter);
        if (showOnScreen) {
            System.out.println(asserter.getContent());
        }

        asserter.assertContent(expect);
    }
}
